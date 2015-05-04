package kristycarrion.WebCrawler;
import java.net.URL;
import java.net.MalformedURLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
/**
 * Creates an instance of WebPage to assure that the crawl method is
 * working as intended and is saving files, images and pages.
 * The test class crawls through Dr.Khrealing’s agora page to the
 * specified depth of 1.
 *
 * @author Kristy Carrion
 * @version 12/3/2012
 */
public class WebCrawlerTest {
    /**
     * Declares an instance of a WebPage, in which is used for testing.
     */
    private WebPage pages;
    /**
     * Declares an instance of a URL, in which is used for testing.
     */
    private URL url;
    /**
     * This is the method that is run before the test that sets up
     * everything for the test. This method creates a url pointing
     * at Dr.Khrealing’s agora web page, then uses that in the
     * initialization of the instance of the WebPage object.
     * It specifies that is crawls through that webpage at the
     * depth of 1. It catches a MalformedURLException if it is
     * thrown, in which case it fails.
     * precondition: True.
     * postcondition: Creates an instance of a url object that points
     *                 to Dr.Khrealing’s web page. As well as insures the
     *                 correct initialization of the field pages.
     */
    @Before
    public void preTestInit() {
        try
        {
            url = new URL("http://agora.cs.wcu.edu/~wck”);
        }
        catch(MalformedURLException e)
        {
            fail("Bad URL");
        }
        pages   = new WebPage(url, 5);
    }
    /**
     * This method is called after the preTestInit method and is used
     * to properly test the WebPage class in order to ensure that it's
     * crawl is working correctly and saving files. It also makes
     * sure that it is pointing to the right webpage by checking it's
     * toString matches the toString of the url that was passed to it
     * upon initialization.
     * precondition: True.
     * postcondition: All collections of Pages, Images and Files is
     *                equal to false.
     *                The toString's of the url passed to it and the
     *                url we have created are equal.
     */
    @Test
    public void ensureWorks() {
        assertFalse(pages.getImages() == null);
        assertFalse(pages.getFiles() == null);
        assertFalse(pages.getWebPages() == null);
        assertEquals(url.toString(), pages.getURL().toString());
    }
}
