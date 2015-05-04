package edu.wcu.CatamountChars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class will take two inputs from a user and then when the user presses the button it will pass along those
 * values to the next screen where they will be interrupted and displayed.
 *
 * @author Kristy Carrion
 * @date 9/18/13
 */
public class TwoLetters extends Activity implements View.OnClickListener {

    /*
     * This method is ran when this activity is ran.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Removes the title that is part of the theme. I could have changed the theme but this works too!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.twoletter);

        // Button listeners are attached to the button.
        Button button1 = (Button)findViewById(R.id.buttonTwoLetter);
        button1.setOnClickListener(this);
    }

    /*
     * When the listener detects a click it will call this method, in order to pass the values entered by the user
     * to the next activity.
     */
    public void onClick(View v) {
        EditText textEditA  = (EditText)findViewById(R.id.editText2a);
        EditText textEditB  = (EditText)findViewById(R.id.editText2b);

        String textA        = textEditA.getText().toString();
        String textB        = textEditB.getText().toString();

        Intent activityNext = new Intent(this, edu.wcu.CatamountChars.DisplayTwoLetter.class);

        activityNext.putExtra("textA", textA);
        activityNext.putExtra("textB", textB);

        this.startActivity(activityNext);

    }
}