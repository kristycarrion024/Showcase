package edu.wcu.CatamountChars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 *
 * This class will act as the menu for the pre-specified images, mainly logos, etc...
 *
 * @author Kristy Carrion
 * @date 9/18/13
 */
public class Image extends Activity implements View.OnClickListener {
    /**
     *
     * This method will be called when the activity starts, and it will set up the button listeners.
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Removes the title that is part of the theme. I could have changed the theme but this works too!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.image);


        // Below here are the button listeners needed for all the buttons.
        Button button1 = (Button)findViewById(R.id.button1a);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button2a);
        button2.setOnClickListener(this);

        Button button3 = (Button)findViewById(R.id.button3a);
        button3.setOnClickListener(this);

        Button button4 = (Button)findViewById(R.id.button4a);
        button4.setOnClickListener(this);

        Button button5 = (Button)findViewById(R.id.button5a);
        button5.setOnClickListener(this);
    }

    /**
     *
     * This method will be called when the button listener detects a click.
     *
     * @param v
     */
    public void onClick(View v) {
        /*
         * This switch state determines what button has been pressed and then takes the appropriate action.
         */
        switch (v.getId()) {
            case R.id.button1a:
                Button button1 = (Button)v;
                String buttonText = button1.getText().toString();
                Intent activityNext = new Intent(this, edu.wcu.CatamountChars.Display.class);
                activityNext.putExtra("buttonText", buttonText);
                this.startActivity(activityNext);
                break;
            case R.id.button2a:
                Button button2 = (Button)v;
                String buttonText2 = button2.getText().toString();
                Intent activityNext2 = new Intent(this, edu.wcu.CatamountChars.Display.class);
                activityNext2.putExtra("buttonText", buttonText2);
                this.startActivity(activityNext2);
                break;
            case R.id.button3a:
                Button button3 = (Button)v;
                String buttonText3 = button3.getText().toString();
                Intent activityNext3 = new Intent(this, edu.wcu.CatamountChars.Display.class);
                activityNext3.putExtra("buttonText", buttonText3);
                this.startActivity(activityNext3);
                break;
            case R.id.button4a:
                Button button4 = (Button)v;
                String buttonText4 = button4.getText().toString();
                Intent activityNext4 = new Intent(this, edu.wcu.CatamountChars.Display.class);
                activityNext4.putExtra("buttonText", buttonText4);
                this.startActivity(activityNext4);
                break;
            case R.id.button5a:
                Button button5 = (Button)v;
                String buttonText5 = button5.getText().toString();
                Intent activityNext5 = new Intent(this, edu.wcu.CatamountChars.Display.class);
                activityNext5.putExtra("buttonText", buttonText5);
                this.startActivity(activityNext5);
                break;
        } //end switch
    } //end onClick
}