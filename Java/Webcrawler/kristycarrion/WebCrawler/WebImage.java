package kristycarrion.WebCrawler;
import java.net.URL;
import java.nio.file.Path;
/**
 * This class implements WebElement and handles all images from the web.
 *
 * @author Kristy Carrion
 * @version 11/20/2012
 */
public class WebImage implements WebElement
{
    /**
     * Declares a URL named url.
     */
    private URL url;
    /**
     * Declares and Initiates a String to the character "i" because it will
     * be used to give a relevant name to the file when it is to be saved.
     */
    private String prefix = "i";
    /**
     * Constructor that has a single parameter of a URL and
     * initializes the parameter to the field.
     * @param url a url of an image.
     * precondition: True.
     * postcondition: This classes url is set to param url.
     */
    public WebImage(URL url)
    {
        this.url = url;
    }
    /**
     * Calls upon the singleton class LOAD to save the url that it has in
     * at the location specified by the path. This method has one parameter
     * that is a path which specifies the location where the url is to
     * be saved to.
     * @param path The path that leads to the directory where the url
     *             is to be saved to.
     * precondition: True.
     * postcondition: Saves the url to the intended path with a name based
     *                on the passed prefix.
     */
    public void saveToDisk(Path path)
    {
        DownloadRepository.LOAD.save(path, url, prefix);
    }
    /**
     * A toString() method that returns the toString() of url.
     * @return String the toString() of the url.
     * precondition: True.
     * postcondition: Returns the url's toString().
     */
    public String toString()
    {
        return url.toString();
    }
    /**
     * A accessor method that gets the url field.
     * @return URL the url that is the field.
     * precondition: True.
     * postcondition: Returns the url.
     */
    public URL getURL()
    {
        return url;
    }
}
