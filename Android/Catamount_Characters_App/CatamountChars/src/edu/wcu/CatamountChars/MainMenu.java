package edu.wcu.CatamountChars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

/**
 *
 * Main menu class that will act as the central activity for the application.
 *
 * @author Kristy Carrion
 * @date 9/18/13
 *
 */
public class MainMenu extends Activity implements View.OnClickListener {

    /*
     * This method will be run when this application is created. This method wil create
     * listeners for all the buttons on the main menu.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Removes the title that is part of the theme. I could have changed the theme but this works too!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mainmenu);

        //Below are all the individual button listeners.

        Button button1        = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2        = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3        = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);

        ImageButton imgButton = (ImageButton)findViewById(R.id.imageButton);
        imgButton.setOnClickListener(this);
    }//end onCreate


    /*
     * This method will be run every time a button click is detected by a button listener.
     * This method will figure out which button was clicked and then take the appropriate action.
     */
    public void onClick(View v)
    {
        /*
         * Switch statement will compare which view was passed to the onClick method and then compare it's
         * ID which is the name ID of the the button that has been clicked. Then the when the correct
         * ID is matched with that button, this switch method will take the appropriate action for that
         * particular button.
         */
        switch (v.getId()) {
            case R.id.button1:
                Intent activityNext = new Intent(this, edu.wcu.CatamountChars.OneLetter.class);
                this.startActivity(activityNext);
                break;
            case R.id.button2:
                Intent activityNext2 = new Intent(this, edu.wcu.CatamountChars.TwoLetters.class);
                this.startActivity(activityNext2);
                break;
            case R.id.button3:
                Intent activityNext3 = new Intent(this, edu.wcu.CatamountChars.Image.class);
                this.startActivity(activityNext3);
                break;
            case R.id.imageButton:
                Intent activityNext4 = new Intent(this, edu.wcu.CatamountChars.Information.class);
                this.startActivity(activityNext4);
                break;
        }//end switch
    }//end onClick
}