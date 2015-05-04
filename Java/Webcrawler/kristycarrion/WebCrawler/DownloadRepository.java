package kristycarrion.WebCrawler;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Singleton enumeration LOAD that saves the specified url to the specified
 * target directory.
 * @author Kristy Carrion
 * @version 11/20/2012
 */
public enum DownloadRepository
{
    /**
     * The singleton enumeration for DownloadRepository.
     */
    LOAD;
    /**
     * An int counter that starts at zero and is used to name each separate
     * image that is saved.
     * This is done in order to make sure that each url that is saved has a
     * unique name and does not contain any punctuation that cannot be used
     * as a file name, for instance "." , ":" , etc ...
     * */
    private int countImage = 0;
    /**
     * An int counter that starts at zero and is used to name each separate
     * file that is saved.
     * This is done in order to make sure that each url that is saved has a
     * unique name and does not contain any punctuation that cannot be used
     * as a file name, for instance "." , ":" , etc ...
     */
    private int countFile  = 0;
    /**
     * A boolen counter used to denoted if file and image sub folders have
     * been created inside the denoted folder.
     */
    private boolean isReal = false;
    /**
     * Method that gabs the specified URL <url> from the internet and then
     * saves it to the specified target directory <targetDir>.
     * This method will create and openstream and proceed to read the data
     * from the specified path byte by byte and then write it a local
     * integer b.
     * Then it will assign the new file that is created at the specified
     * directory a name based on the integer <counter>, catching
     * IOExceptions along the way.
     * @param targetDir the intended path to the specified directory where
     *                  the files will be saved to.
     * @param url the specified url where the file that is to be copied
     *            is found.
     * @param sufix defines whether the url is an image or a file which is
     *              going be used to define the file name.
     * @see IOException
     * precondition: True.
     * postcondition: Saves the url to the targetDir, inside the corresponding
     *                subfolder, i.e: image or files, with the name based on
     *                the passed sufix.
     */
    public void save(Path targetDir, URL url, String sufix)
    {
        if (isReal)
        {
            try
            {
                InputStream in            = new BufferedInputStream(
                                                    url.openStream());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int b;
                while ((b = in.read()) != -1)
                {
                    out.write(b);
                }
                if (sufix.equals("i"))
                {
                    File temp = new File(targetDir.toString() + "/images/" + sufix + countImage);
                    temp.createNewFile();
                    System.out.println("Images: " + temp.toString());
                    new FileOutputStream(temp).write(out.toByteArray());
                    countImage++;
                }
                else
                {
                    File temp = new File(targetDir.toString() + "/files/" + sufix + countFile);
                    temp.createNewFile();
                    System.out.println("Files: " + temp.toString());
                    new FileOutputStream(temp).write(out.toByteArray());
                    countFile++;
                }
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            makeDirectory(targetDir);
        }
    }
    /**
     * Private helper method used to make separate image and file directories
     * which are used to help order any time of files passed to the
     * save method.
     * It uses the parameter to create the image and file sub directories
     * inside of the original directory.
     * @param targetDir path to be used to create the sub directories in.
     * precondition: Boolean == false.
     * postcondition: Makes sub directories.
     */
    private void makeDirectory(Path targetDir)
    {
        try
        {
            Path image = Paths.get(targetDir.toString() + "/images");
            Path files = Paths.get(targetDir.toString() + "/files");
            Files.createDirectory(image);
            Files.createDirectory(files);
            isReal     = true;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
