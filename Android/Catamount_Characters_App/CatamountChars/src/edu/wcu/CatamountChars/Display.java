package edu.wcu.CatamountChars;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

/**
 * This class will display the basic images as was pre-defined.
 *
 * @author Kristy Carrion
 * @date 9/19/13
 *
 */
public class Display extends Activity {

    // Initiates this variable for future use.
    String buttonText;

    /**
     *
     * This method is called when activity is created, and will set the appropriate values to the pre instantiated
     * variables.
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Removes the title that is part of the theme. I could have changed the theme but this works too!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.display);

        // Gets the extras that have been passed.
        Bundle extras = getIntent().getExtras();

        // Sets the string equal to an empty string.
        buttonText = "";

        // Makes sure that extras is not equal to null before trying to access it.
        if (extras != null) {
            buttonText = extras.getString("buttonText");
        }

        //Check to see what image to display in the image view.
        if(buttonText.equalsIgnoreCase("catamount")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView) this.findViewById(R.id.imageView2);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.cat);
        }
        else if(buttonText.equalsIgnoreCase("tower")) {
            //Get the image view from the layout
            ImageView im2 = (ImageView) this.findViewById(R.id.imageView2);
            //Set the image of the image view to drawable im1
            im2.setImageResource(R.drawable.tower);
        }
        else if(buttonText.equalsIgnoreCase("computer")) {

            //Get the image view from the layout
            ImageView im3 = (ImageView) this.findViewById(R.id.imageView2);
            //Set the image of the image view to drawable im1
            im3.setImageResource(R.drawable.computer);
        }
        else if(buttonText.equalsIgnoreCase("science")) {

            //Get the image view from the layout
            ImageView im4 = (ImageView) this.findViewById(R.id.imageView2);
            //Set the image of the image view to drawable im1
            im4.setImageResource(R.drawable.science);
        }
        else if(buttonText.equalsIgnoreCase("2013")) {

            //Get the image view from the layout
            ImageView im5 = (ImageView) this.findViewById(R.id.imageView2);
            //Set the image of the image view to drawable im1
            im5.setImageResource(R.drawable.cs467);
        }
    }

    /**
     *
     * This method will detect if the screen has been switched sideways and then change the image appropriately.
     *
     * @param newConfig
     */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            if(buttonText.equalsIgnoreCase("catamount")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.cat_h);
            }
            else if(buttonText.equalsIgnoreCase("tower")) {
                //Get the image view from the layout
                ImageView im2 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im2.setImageResource(R.drawable.tower_h);
            }
            else if(buttonText.equalsIgnoreCase("computer")) {

                //Get the image view from the layout
                ImageView im3 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im3.setImageResource(R.drawable.computer_h);
            }
            else if(buttonText.equalsIgnoreCase("science")) {

                //Get the image view from the layout
                ImageView im4 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im4.setImageResource(R.drawable.science_h);
            }
            else if(buttonText.equalsIgnoreCase("2013")) {

                //Get the image view from the layout
                ImageView im5 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im5.setImageResource(R.drawable.cs467_h);
            }

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            if(buttonText.equalsIgnoreCase("catamount")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.cat);
            }
            else if(buttonText.equalsIgnoreCase("tower")) {
                //Get the image view from the layout
                ImageView im2 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im2.setImageResource(R.drawable.tower);
            }
            else if(buttonText.equalsIgnoreCase("computer")) {

                //Get the image view from the layout
                ImageView im3 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im3.setImageResource(R.drawable.computer);
            }
            else if(buttonText.equalsIgnoreCase("science")) {

                //Get the image view from the layout
                ImageView im4 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im4.setImageResource(R.drawable.science);
            }
            else if(buttonText.equalsIgnoreCase("2013")) {

                //Get the image view from the layout
                ImageView im5 = (ImageView) this.findViewById(R.id.imageView2);
                //Set the image of the image view to drawable im1
                im5.setImageResource(R.drawable.cs467);
            }

        }
    }
}