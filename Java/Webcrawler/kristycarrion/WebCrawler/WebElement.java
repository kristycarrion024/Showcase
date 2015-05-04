package kristycarrion.WebCrawler;
import java.nio.file.Path;
/**
 * Interface for all web classes, that is able to be changed in the future.
 *
 * @author Kristy carrion
 * @version 11/20/2012
 */
public interface WebElement
{
    /**
     * This method will save the intended web element to the path specified.
     * @param path denotes the path in which the given web element will be
     *             saved to.
     * precondition: True.
     * postcondition: save to the intended to path.
     */
    public void saveToDisk(Path path);
}
