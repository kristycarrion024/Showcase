package kristycarrion.WebCrawler;
import java.net.URL;
import java.nio.file.Path;
/**
 * This class handles all Web Files that are handed to it.
 * @author Kristy Carrion
 * @version 11/20/1202
 */
public class WebFile
{
    /**
     * Declares an instance of a URL class.
     */
    private URL url;
    /**
     * Declares and Initializes a String to the character "f" in order to
     * assist in naming the file.
     */
    private String prefix = "f";
    /**
     * Constructor that takes in one parameter of a URL and initializes
     * that to the field.
     * @param url a url of a web file.
     * precondition: True.
     * postcondition: url is set to url.
     */
    public WebFile(URL url)
    {
        this.url = url;
    }
    /**
     * Method that calls upon the Singleton class LOAD, passes it the path
     * that the method receives as a parameter and the url so that it may
     * save the url.
     * @param path the path where the url should be saved to.
     * precondition: True.
     * postcondition: Saves the current url to the intended path.
     */
    public void saveToDisk(Path path)
    {
        DownloadRepository.LOAD.save(path, url, prefix);
    }
    /**
     * A toString methat that returns the toString of the url.
     * @return String the toString of the url.
     * precondition: True.
     * postcondition: Returns the url toString().
     */
    public String toString()
    {
        return url.toString();
    }
    /**
     * A accessor method that returns the url.
     * @return URL the url in the field.
     * precondition: True.
     * postcondition: Returns the url.
     */
    public URL getURL()
    {
        return url;
    }
}
