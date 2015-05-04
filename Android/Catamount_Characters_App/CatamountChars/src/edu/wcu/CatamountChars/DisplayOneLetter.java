package edu.wcu.CatamountChars;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

/**
 * This class will display one letter that is given by the user.
 *
 * @author Kristy Carrion
 * @date 9/19/13
 */
public class DisplayOneLetter extends Activity {

    // Initiates this variable for future use.
    String text;

    /**
     *
     * This method is called when activity is created, and will set the appropriate values to the pre instantiated
     * variables. Then this method will determine the string that was passed and show the correct alpha-numeric
     * character.
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Removes the title that is part of the theme. I could have changed the theme but this works too!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.displayoneletter);

        // Gets the extras that have been passed.
        Bundle extras = getIntent().getExtras();

        // Sets the string equal to an empty string.
        text = "";

        // Makes sure that extras is not equal to null before trying to access it.
        if (extras != null) {
            text = extras.getString("text");
        }

        //Check to see what image to display in the image view.
        if(text.equalsIgnoreCase(" ")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.space_bl);
        }
        else if(text.equalsIgnoreCase("1")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.one_bl);
        }
        else if(text.equalsIgnoreCase("2")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.two_bl);
        }
        else if(text.equalsIgnoreCase("3")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.three_bl);
        }
        else if(text.equalsIgnoreCase("4")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.four_bl);
        }
        else if(text.equalsIgnoreCase("5")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.five_bl);
        }
        else if(text.equalsIgnoreCase("6")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.six_bl);
        }
        else if(text.equalsIgnoreCase("7")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.seven_bl);
        }
        else if(text.equalsIgnoreCase("8")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.eight_bl);
        }
        else if(text.equalsIgnoreCase("9")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.nine_bl);
        }
        else if(text.equalsIgnoreCase("0")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.zero_bl);
        }
        else if(text.equalsIgnoreCase("a")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.a_bl);
        }
        else if(text.equalsIgnoreCase("b")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.b_bl);
        }
        else if(text.equalsIgnoreCase("c")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.c_bl);
        }
        else if(text.equalsIgnoreCase("d")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.d_bl);
        }
        else if(text.equalsIgnoreCase("e")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.e_bl);
        }
        else if(text.equalsIgnoreCase("f")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.f_bl);
        }
        else if(text.equalsIgnoreCase("g")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.g_bl);
        }
        else if(text.equalsIgnoreCase("h")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.h_bl);
        }
        else if(text.equalsIgnoreCase("i")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.i_bl);
        }
        else if(text.equalsIgnoreCase("j")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.j_bl);
        }
        else if(text.equalsIgnoreCase("k")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.k_bl);
        }
        else if(text.equalsIgnoreCase("l")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.l_bl);
        }
        else if(text.equalsIgnoreCase("m")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.m_bl);
        }
        else if(text.equalsIgnoreCase("n")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.n_bl);
        }
        else if(text.equalsIgnoreCase("o")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.o_bl);
        }
        else if(text.equalsIgnoreCase("p")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.p_bl);
        }
        else if(text.equalsIgnoreCase("q")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.q_bl);
        }
        else if(text.equalsIgnoreCase("r")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.r_bl);
        }
        else if(text.equalsIgnoreCase("s")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.s_bl);
        }
        else if(text.equalsIgnoreCase("t")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.t_bl);
        }
        else if(text.equalsIgnoreCase("u")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.u_bl);
        }
        else if(text.equalsIgnoreCase("v")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.v_bl);
        }
        else if(text.equalsIgnoreCase("w")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.q_bl);
        }
        else if(text.equalsIgnoreCase("x")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.q_bl);
        }
        else if(text.equalsIgnoreCase("y")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.q_bl);
        }
        else if(text.equalsIgnoreCase("z")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.q_bl);
        }

    }//end onCreate()


    /**
     *
     * This method will detect if the screen has been switched sideways and then change the image appropriately.
     *
     * @param newConfig
     */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // If the orientation is sideways it switches the images.
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if(text.equalsIgnoreCase(" ")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.space_bl);
            }
            else if(text.equalsIgnoreCase("1")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.one_sl);
            }
            else if(text.equalsIgnoreCase("2")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.two_sl);
            }
            else if(text.equalsIgnoreCase("3")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.three_sl);
            }
            else if(text.equalsIgnoreCase("4")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.four_sl);
            }
            else if(text.equalsIgnoreCase("5")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.five_sl);
            }
            else if(text.equalsIgnoreCase("6")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.six_sl);
            }
            else if(text.equalsIgnoreCase("7")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.seven_sl);
            }
            else if(text.equalsIgnoreCase("8")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.eight_sl);
            }
            else if(text.equalsIgnoreCase("9")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.nine_sl);
            }
            else if(text.equalsIgnoreCase("0")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.zero_sl);
            }
            else if(text.equalsIgnoreCase("a")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.a_sl);
            }
            else if(text.equalsIgnoreCase("b")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.b_sl);
            }
            else if(text.equalsIgnoreCase("c")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.c_sl);
            }
            else if(text.equalsIgnoreCase("d")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.d_sl);
            }
            else if(text.equalsIgnoreCase("e")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.e_sl);
            }
            else if(text.equalsIgnoreCase("f")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.f_sl);
            }
            else if(text.equalsIgnoreCase("g")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.g_sl);
            }
            else if(text.equalsIgnoreCase("h")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.h_sl);
            }
            else if(text.equalsIgnoreCase("i")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.i_sl);
            }
            else if(text.equalsIgnoreCase("j")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.j_sl);
            }
            else if(text.equalsIgnoreCase("k")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.k_sl);
            }
            else if(text.equalsIgnoreCase("l")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.l_sl);
            }
            else if(text.equalsIgnoreCase("m")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.m_sl);
            }
            else if(text.equalsIgnoreCase("n")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.n_sl);
            }
            else if(text.equalsIgnoreCase("o")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.o_sl);
            }
            else if(text.equalsIgnoreCase("p")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.p_sl);
            }
            else if(text.equalsIgnoreCase("q")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.q_sl);
            }
            else if(text.equalsIgnoreCase("r")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.r_sl);
            }
            else if(text.equalsIgnoreCase("s")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.s_sl);
            }
            else if(text.equalsIgnoreCase("t")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.t_sl);
            }
            else if(text.equalsIgnoreCase("u")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.u_sl);
            }
            else if(text.equalsIgnoreCase("v")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.v_sl);
            }
            else if(text.equalsIgnoreCase("w")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.w_sl);
            }
            else if(text.equalsIgnoreCase("x")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.x_sl);
            }
            else if(text.equalsIgnoreCase("y")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.y_sl);
            }
            else if(text.equalsIgnoreCase("z")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.z_sl);
            }

        // If the orientation is then changed back to portrait it will then switch it back to it's appropriate image.
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            if(text.equalsIgnoreCase(" ")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.space_bl);
            }
            else if(text.equalsIgnoreCase("1")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.one_bl);
            }
            else if(text.equalsIgnoreCase("2")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.two_bl);
            }
            else if(text.equalsIgnoreCase("3")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.three_bl);
            }
            else if(text.equalsIgnoreCase("4")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.four_bl);
            }
            else if(text.equalsIgnoreCase("5")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.five_bl);
            }
            else if(text.equalsIgnoreCase("6")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.six_bl);
            }
            else if(text.equalsIgnoreCase("7")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.seven_bl);
            }
            else if(text.equalsIgnoreCase("8")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.eight_bl);
            }
            else if(text.equalsIgnoreCase("9")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.nine_bl);
            }
            else if(text.equalsIgnoreCase("0")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.zero_bl);
            }
            else if(text.equalsIgnoreCase("a")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.a_bl);
            }
            else if(text.equalsIgnoreCase("b")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.b_bl);
            }
            else if(text.equalsIgnoreCase("c")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.c_bl);
            }
            else if(text.equalsIgnoreCase("d")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.d_bl);
            }
            else if(text.equalsIgnoreCase("e")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.e_bl);
            }
            else if(text.equalsIgnoreCase("f")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.f_bl);
            }
            else if(text.equalsIgnoreCase("g")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.g_bl);
            }
            else if(text.equalsIgnoreCase("h")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.h_bl);
            }
            else if(text.equalsIgnoreCase("i")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.i_bl);
            }
            else if(text.equalsIgnoreCase("j")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.j_bl);
            }
            else if(text.equalsIgnoreCase("k")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.k_bl);
            }
            else if(text.equalsIgnoreCase("l")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.l_bl);
            }
            else if(text.equalsIgnoreCase("m")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.m_bl);
            }
            else if(text.equalsIgnoreCase("n")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.n_bl);
            }
            else if(text.equalsIgnoreCase("o")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.o_bl);
            }
            else if(text.equalsIgnoreCase("p")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.p_bl);
            }
            else if(text.equalsIgnoreCase("q")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.q_bl);
            }
            else if(text.equalsIgnoreCase("r")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.r_bl);
            }
            else if(text.equalsIgnoreCase("s")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.s_bl);
            }
            else if(text.equalsIgnoreCase("t")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.t_bl);
            }
            else if(text.equalsIgnoreCase("u")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.u_bl);
            }
            else if(text.equalsIgnoreCase("v")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.v_bl);
            }
            else if(text.equalsIgnoreCase("w")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.w_bl);
            }
            else if(text.equalsIgnoreCase("x")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.x_bl);
            }
            else if(text.equalsIgnoreCase("y")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.y_bl);
            }
            else if(text.equalsIgnoreCase("z")) {
                //Get the image view from the layout
                ImageView im1 = (ImageView)this.findViewById(R.id.imageViewOneLetter);
                //Set the image of the image view to drawable im1
                im1.setImageResource(R.drawable.z_bl);
            }
        }
    }
}