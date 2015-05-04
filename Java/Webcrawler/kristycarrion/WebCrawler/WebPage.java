package kristycarrion.WebCrawler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class that parses/'crawls' through a specified web page, and recurses down
 * from the initial web page to the specified depth.
 * This also saves all the elements it finds in the apropriate category.
 * @author Kristy Carrion
 * @version 11/20/2012
 */
public class WebPage implements WebElement
{
    /**
     * A string that holds the specified 'Hyper Text Protocol' that defines
     * the beginning of every url.
     * This specific String is used to help reduce redundancy in the code,
     * getting rid of magic numbers and values.
     */
    private static final String HTTP = "http://";
    /**
     * An int that holds the length of the string HTTP.
     * This specific int is used to help reduce redundancy in the code,
     * getting rid of magic numbers and values.
     */
    private static final int HTTP_MATCH_LENGTH = HTTP.length();
    /**
     * An int that holds the length of the html tag that defines an image
     * link.
     * This specific int is used to help reduce redundancy in the code,
     * getting rid of magic numbers and values.
     */
    private static final int SRC_MATCH_LENGTH  = "src=\"".length();
    /**
     * An int that holds the length of the html tag that defines a link.
     * This specific int is used to help reduce redundancy in the code,
     * getting rid of magic numbers and values.
     */
    private static final int HREF_MATCH_LENGTH = "href=\"".length();
    /**
     * Declares a collection of WebPage elements.
     */
    private Collection<WebPage>  pages;
    /**
     * Declares a collection of WebImage elements.
     */
    private Collection<WebImage> images;
    /**
     * Declares a collection of WebFile elements.
     */
    private Collection<WebFile>  files;
    /**
     * Declares a url field to hold the pre-specified url in which to begin
     * the crawl.
     */
    private URL url;
    /**
     * Constructor that takes in two parameters and initializes the
     * pre-specified collections into new LinkedLists.
     * @param url specifies the url in which the crawl is to begin.
     * @param depth specifies the depth at which the class is going to need to
     *              recurse down to.
     * precondition: True.
     * postcondition: Makes new LinkedList then passed everything else to the
     *                next constructor.
     */
    public WebPage(URL url, int depth)
    {
        this(url, depth, new LinkedList<WebPage>(),
                         new LinkedList<WebImage>(),
                         new LinkedList<WebFile>());
    }
    /**
     * Second constructor that has 5 parameters of which are passed down from
     * the first constructor and initializes it's parameters.
     * As well as checking to make the crawl depth that is specified is
     * greater than zero and then passes it to the third constructor.
     * @param url specifies the url in which the crawl is to begin.
     * @param depth specifies the depth of which the crawl should go.
     * @param pages specifies the collection of WebPages.
     * @param images specifies the collection of WebImages.
     * @param files specifies the collection of WebFiles.
     * precondition: True.
     * postcondition: Sets everything equal to it's corresponding fields.
     *                Checks that: depth > 0.
     */
    private WebPage(URL url, int depth, Collection<WebPage> pages,
                    Collection<WebImage> images, Collection<WebFile> files)
    {
        this.url      = url;
        this.pages    = pages;
        this.images   = images;
        this.files    = files;
        if (depth > 0)
        {
            this.crawl(depth);
        }
    }
    /**
     * This method takes in one parameter the specifies the depth of the crawl.
     * Then the method calls upon helper methods in order to parse the web
     * page. It connects to the web page, turns it into a string with the
     * use of StringBuilder then parses it, looking for all possible links
     * using the java class Pattern.
     *
     * Then checks the links that are found depending on the html tag,
     * giving them to the corresponding helper method so they can be sorted
     * into the proper collection of their kind.
     * @param depth specifies the depth at which the crawl needs to crawl to.
     * precondition: True.
     * postcondition: Crawls the webpage and adds the images and files to
     *                it's corresponding collection.
     */
    public void crawl(int depth)
    {
        StringBuilder html = new StringBuilder();
        this.makePage(html);
        String originalURL = null;
        try
        {
            originalURL = (new URI(url.toString())).getHost();
        }
        catch (URISyntaxException e)
        {
            System.out.println(e.getMessage());
        }
        if (originalURL.length() < HTTP_MATCH_LENGTH)
        {
            originalURL = HTTP + originalURL;
        }
        else
        {
            if (!originalURL.substring(0, HTTP_MATCH_LENGTH).equals(HTTP))
            {
                originalURL = HTTP + originalURL;
            }
        }
        Pattern link       = Pattern.compile("href=\"([^\"]+)*");
        Matcher match      = link.matcher(html);
        Pattern link2      = Pattern.compile("src=\"([^\"]+)*");
        Matcher match2     = link2.matcher(html);
        this.findLinkMatches(match, originalURL, depth);
        this.findImageMatches(match2, originalURL);
    }
    /**
     * This private helper method checks to see if the match and original url
     * fit the category of an image match defined by a working url, and
     * if it is found in the src html tag.
     * @param match a matcher used in checking if the found match is an image.
     * @param originalURL a string representation of the original url where
     *                    the match was found.
     * precondition: True.
     * postcondition: Checks to make sure that the match passed is actually
     *                an image and then adds it to the image collection.
     */
    private void findImageMatches(Matcher match, String originalURL)
    {
        Pattern checkLink = Pattern.compile(HTTP);
        Matcher matchLink = null;
        while (match.find())
        {
            String next   = match.group();
            next          = next.substring(SRC_MATCH_LENGTH, next.length());
            matchLink     = checkLink.matcher(next);
            if (next.length() == 0)
            {
                continue;
            }
            if (!matchLink.find())
            {
                next    = originalURL + this.addSlash(next);
            }
            URL newItem    = null;
            try
            {
                newItem = new URL(next);
            }
            catch (MalformedURLException e)
            {
                System.out.println(e.getMessage());
                continue;
            }
            boolean exists = false;
            for (WebImage image : images)
            {
                if (newItem.equals(image.getURL()))
                {
                    exists = true;
                    break;
                }
            }
            if (!exists)
            {
                this.images.add(new WebImage(newItem));
            }
        }
    }
    /**
     * Private helper method checks to see if the match and the original url
     * fir the category of an link match defined by a working url, and if it
     * is found to have "http://" or "https://" in the url.
     * If it is a url it will use it to crawl down into defined by the depth
     * in terms of recursion. If the url is not a link to another web page
     * it is placed in to the files collection.
     * @param match the match found that can be ether a webpage or a file.
     * @param originalURL the original address of the url.
     * @param depth the depth that should be crawled to.
     * precondition: True.
     * postcondition: Checks the match to see if it is a link vs. a web page.
     *                If it is a file it is added to the files collection.
     */
    private void findLinkMatches(Matcher match, String originalURL, int depth)
    {
        Pattern checkLink = Pattern.compile("http(s)?://");
        Matcher matchLink = null;
        boolean isLink;
        while (match.find())
        {
            isLink        = true;
            String next   = match.group();
            next          = next.substring(HREF_MATCH_LENGTH, next.length());
            matchLink     = checkLink.matcher(next);
            if (next.length() == 0)
            {
                continue;
            }
            if (!matchLink.find())
            {
                next   = originalURL + this.addSlash(next);
                isLink = false;
            }
            URL newItem = null;
            try
            {
                newItem = new URL(next);
            }
            catch (MalformedURLException e)
            {
                System.out.println(e.getMessage());
                continue;
            }
            if (newItem != null)
            {
                boolean exists = false;
                if (isLink)
                {
                    for (WebPage page : pages)
                    {
                        if (newItem.equals(page.getURL()))
                        {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists)
                    {
                        pages.add(new WebPage(newItem, depth - 1, this.pages,
                                                this.images, this.files));
                    }
                }
                else
                {
                    for (WebFile file : files)
                    {
                        if (newItem.equals(file.getURL()))
                        {
                            exists = true;
                            break;
                        }
                    }
                    if (!exists)
                    {
                        files.add(new WebFile(newItem));
                    }
                }
            }
        }
    }
    /**
     * This private helper method creates the webpage that is passed to it
     * as a StringBuilder and parses through it, line by line.
     * @param html a Stringbuilder representation by string,
     *             from a pre-specified url.
     * precondition: True.
     * postcondition: Makes a page based on the StringBuilder passed to it.
     */
    private void makePage(StringBuilder html)
    {
        BufferedReader parse = null;
        String temp          = null;
        try
        {
            parse = new BufferedReader(new InputStreamReader(
                                           url.openStream()));
            temp  = parse.readLine();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        while (temp != null)
        {
            html.append(temp);
            try
            {
                temp = parse.readLine();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * This private helper method takes in a string to check if it has
     * a slash at the beginning. This is important because on some websites
     * they link pages without the use of "http" in their href and src tags.
     * When they do not have the http, an openStream() connection cannot be
     * made properly. Therefore, check to see if there is a slash, if not
     * add it in.
     * @param checkMe a string representation of a url that needs to be
     *                checked for a slash.
     * @return String if the string that needed to be checked did not have a
     *                slash then it is added in and returned.
     * precondition: True.
     * postcondition: Adds a slash if the string does not already have a slash.
     */
    private String addSlash(String checkMe)
    {
        if (checkMe.charAt(0) != '/')
        {
            checkMe = '/' + checkMe;
        }
        return checkMe;
    }
    /**
     * Saves a file to the specified directory.
     * This method is not implemented in this class.
     * @param path the path where the file is to be saved.
     * precondition: True.
     * postcondition: Throws a new UnsupportedOperationException.
     */
    public void saveToDisk(Path path)
    {
        throw new UnsupportedOperationException("Unsupported Operation");
    }
    /**
     * An accessor method that returns the collection of WebImages.
     * @return Collection<WebImage> the collection of complied web images.
     * precondition: True.
     * postcondition: Returns the collection of images.
     */
    public Collection<WebImage> getImages()
    {
        return images;
    }
    /**
     * An accessor method that returns the collection of WebFiles.
     * @return Collection<WebFile> the collection of complied web files.
     * precondition: True.
     * postcondition: Returns the collection of files.
     */
    public Collection<WebFile> getFiles()
    {
        return files;
    }
    /**
     * An accessor method that returns the collection of WebPages.
     * @return Collection<WebPage> the collection of complied web pages.
     * precondition: True.
     * postcondition: Returns the collection of webpages.
     */
    public Collection<WebPage> getWebPages()
    {
        return pages;
    }
    /**
     * An accessor method that returns the url's to string.
     * @return String the toString() of the url.
     * precondition: True.
     * postcondition: Returns the url toString().
     */
    public String toString()
    {
        return url.toString();
    }
    /**
     * An accessor method that returns the url.
     * @return URL the classes url.
     * precondition: True.
     * postcondition: Returns the url.
     */
    public URL getURL()
    {
        return url;
    }
}
