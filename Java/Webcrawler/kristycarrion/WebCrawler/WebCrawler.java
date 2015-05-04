package kristycarrion.WebCrawler;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
/**
 * This class holds the driver for the crawler.
 *
 * @author Kristy Carrion
 * @version 11/20/2012
 */
public class WebCrawler
{
    /**
     * Driver used to run the program. It takes it three in line command
     * arguments, checks to see that they are correct, creates an instance
     * of the WebPage class and hands it the information it was given,
     * receiving the collection of complied WebPages, WebImages and WebFiles.
     * The driver also lets the user know if the Directory does not exist then
     * goes on to create it.
     * @param args an array of Strings that take in command line arguments.
     * precondition: True.
     * postcondition: Web pages parsed to the denoted depth and objects saved.
     */
    public static void main(String[] args)
    {
        if (args.length != 3)
        {
            usage();
        }
        URL url   = null;
        int args1 = -1;
        Path path = null;
        try
        {
            url       = new URL(args[0]);
            args1     = Integer.parseInt(args[1]);
            path      = new File(args[2]).toPath();
            if (!Files.isDirectory(path))
            {
                System.out.println("Directory does not exist");
                Files.createDirectory(path);
            }
        }
        catch (MalformedURLException e)
        {
            System.out.println(e.getMessage());
            usage();
        }
        catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
            usage();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        WebPage page1              = new WebPage(url, args1);
        Collection<WebPage> test   = page1.getWebPages();
        Collection<WebImage> test2 = page1.getImages();
        Collection<WebFile> test3  = page1.getFiles();
        System.out.println("Webpage: ");
        for (WebPage page : test)
        {
            System.out.println(page.toString());
        }
        System.out.println("WebImage: ");
        for (WebImage image : test2)
        {
            image.saveToDisk(path);
        }
        System.out.println("WebFiles: ");
        for (WebFile file : test3)
        {
            file.saveToDisk(path);
        }
    }
    /**
     * Method tells the user that they have entered in incorrect information.
     * Whether that be the web address, the depth, or the directory.
     * precondition: True.
     * postcondition: Prints out an error message if any of the three arguments
     *                are not correct, and closes the user out of the program.
     */
    public static void usage()
    {
        String message = "<Web Address> <Depth> <Save Directory>";
        System.out.println("Usage: java WebCrawler " + message);
        System.exit(1);
    }
}
