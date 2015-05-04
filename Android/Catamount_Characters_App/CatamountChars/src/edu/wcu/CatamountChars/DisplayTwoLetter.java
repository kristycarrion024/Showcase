package edu.wcu.CatamountChars;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

/**
 *
 * This class will display the two letters that were passed to this class from the TwoLetters class.
 *
 * @author Kristy Carrion
 * @date 9/19/13
 */
public class DisplayTwoLetter extends Activity {

    // Initiating the strings.
    String textA, textB;

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
        setContentView(R.layout.displaytwoletter);

        // Gets the extras that have been passed.
        Bundle extras = getIntent().getExtras();

        // Sets the string equal to an empty string.
        textA = "";
        textB = "";

        // Makes sure that extras is not equal to null before trying to access it.
        if (extras != null) {
            textA = extras.getString("textA");
            textB = extras.getString("textB");
        }

        //Check to see what image to display on the top image view.

        if(textA.equalsIgnoreCase(" ")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.space_bl);
        }
        else if(textA.equalsIgnoreCase("1")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.one_bl);
        }
        else if(textA.equalsIgnoreCase("2")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.two_bl);
        }
        else if(textA.equalsIgnoreCase("3")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.three_bl);
        }
        else if(textA.equalsIgnoreCase("4")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.four_bl);
        }
        else if(textA.equalsIgnoreCase("5")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.five_bl);
        }
        else if(textA.equalsIgnoreCase("6")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.six_bl);
        }
        else if(textA.equalsIgnoreCase("7")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.seven_bl);
        }
        else if(textA.equalsIgnoreCase("8")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.eight_bl);
        }
        else if(textA.equalsIgnoreCase("9")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.nine_bl);
        }
        else if(textA.equalsIgnoreCase("0")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.zero_bl);
        }
        else if(textA.equalsIgnoreCase("a")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.a_bl);
        }
        else if(textA.equalsIgnoreCase("b")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.b_bl);
        }
        else if(textA.equalsIgnoreCase("c")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.c_bl);
        }
        else if(textA.equalsIgnoreCase("d")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.d_bl);
        }
        else if(textA.equalsIgnoreCase("e")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.e_bl);
        }
        else if(textA.equalsIgnoreCase("f")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.f_bl);
        }
        else if(textA.equalsIgnoreCase("g")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.g_bl);
        }
        else if(textA.equalsIgnoreCase("h")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.h_bl);
        }
        else if(textA.equalsIgnoreCase("i")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.i_bl);
        }
        else if(textA.equalsIgnoreCase("j")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.j_bl);
        }
        else if(textA.equalsIgnoreCase("k")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.k_bl);
        }
        else if(textA.equalsIgnoreCase("l")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.l_bl);
        }
        else if(textA.equalsIgnoreCase("m")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.m_bl);
        }
        else if(textA.equalsIgnoreCase("n")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.n_bl);
        }
        else if(textA.equalsIgnoreCase("o")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.o_bl);
        }
        else if(textA.equalsIgnoreCase("p")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.p_bl);
        }
        else if(textA.equalsIgnoreCase("q")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.q_bl);
        }
        else if(textA.equalsIgnoreCase("r")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.r_bl);
        }
        else if(textA.equalsIgnoreCase("s")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.s_bl);
        }
        else if(textA.equalsIgnoreCase("t")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.t_bl);
        }
        else if(textA.equalsIgnoreCase("u")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.u_bl);
        }
        else if(textA.equalsIgnoreCase("v")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.v_bl);
        }
        else if(textA.equalsIgnoreCase("w")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.w_bl);
        }
        else if(textA.equalsIgnoreCase("x")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.x_bl);
        }
        else if(textA.equalsIgnoreCase("y")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.y_bl);
        }
        else if(textA.equalsIgnoreCase("z")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterA);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.z_bl);
        }

        //Checking for which picture to use in the bottom picture view.

        if(textB.equalsIgnoreCase(" ")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.space_bl);
        }
        else if(textB.equalsIgnoreCase("1")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.one_bl);
        }
        else if(textB.equalsIgnoreCase("2")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.two_bl);
        }
        else if(textB.equalsIgnoreCase("3")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.three_bl);
        }
        else if(textB.equalsIgnoreCase("4")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.four_bl);
        }
        else if(textB.equalsIgnoreCase("5")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.five_bl);
        }
        else if(textB.equalsIgnoreCase("6")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.six_bl);
        }
        else if(textB.equalsIgnoreCase("7")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.seven_bl);
        }
        else if(textB.equalsIgnoreCase("8")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.eight_bl);
        }
        else if(textB.equalsIgnoreCase("9")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.nine_bl);
        }
        else if(textB.equalsIgnoreCase("0")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.zero_bl);
        }
        else if(textB.equalsIgnoreCase("a")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.a_bl);
        }
        else if(textB.equalsIgnoreCase("b")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.b_bl);
        }
        else if(textB.equalsIgnoreCase("c")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.c_bl);
        }
        else if(textB.equalsIgnoreCase("d")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.d_bl);
        }
        else if(textB.equalsIgnoreCase("e")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.e_bl);
        }
        else if(textB.equalsIgnoreCase("f")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.f_bl);
        }
        else if(textB.equalsIgnoreCase("g")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.g_bl);
        }
        else if(textB.equalsIgnoreCase("h")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.h_bl);
        }
        else if(textB.equalsIgnoreCase("i")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.i_bl);
        }
        else if(textB.equalsIgnoreCase("j")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.j_bl);
        }
        else if(textB.equalsIgnoreCase("k")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.k_bl);
        }
        else if(textB.equalsIgnoreCase("l")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.l_bl);
        }
        else if(textB.equalsIgnoreCase("m")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.m_bl);
        }
        else if(textB.equalsIgnoreCase("n")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.n_bl);
        }
        else if(textB.equalsIgnoreCase("o")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.o_bl);
        }
        else if(textB.equalsIgnoreCase("p")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.p_bl);
        }
        else if(textB.equalsIgnoreCase("q")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.q_bl);
        }
        else if(textB.equalsIgnoreCase("r")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.r_bl);
        }
        else if(textB.equalsIgnoreCase("s")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.s_bl);
        }
        else if(textB.equalsIgnoreCase("t")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.t_bl);
        }
        else if(textB.equalsIgnoreCase("u")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.u_bl);
        }
        else if(textB.equalsIgnoreCase("v")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.v_bl);
        }
        else if(textB.equalsIgnoreCase("w")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.w_bl);
        }
        else if(textB.equalsIgnoreCase("x")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.x_bl);
        }
        else if(textB.equalsIgnoreCase("y")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.y_bl);
        }
        else if(textB.equalsIgnoreCase("z")) {
            //Get the image view from the layout
            ImageView im1 = (ImageView)this.findViewById(R.id.imageViewTwoLetterB);
            //Set the image of the image view to drawable im1
            im1.setImageResource(R.drawable.z_bl);
        }
    }
}