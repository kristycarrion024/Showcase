package edu.wcu.CatamountChars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 *
 * This class will be the menu for displaying one letter on the screen. It will take in one input of
 * an alpha-numeric character (a-zA-Z SPACE 0-9). Then this class will pass the appropriate value
 * to the next activity.
 *
 * @author  Kristy Carrion
 * @date 9/18/13
 *
 */
public class OneLetter extends Activity implements View.OnClickListener {

    /*
     * This method will make the button listener for the only button.
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Removes the title that is part of the theme. I could have changed the theme but this works too!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.oneletter);

        // Button listener for the only button in the layout.
        Button button1 = (Button)findViewById(R.id.buttonOneLetter);
        button1.setOnClickListener(this);

    }

    /*
     * This method will be run when a button click is detected this will be run. This method will take the
     * input the user entered into the EditText field and pass it along to the next Activity.
     */
    public void onClick(View v) {
        EditText textEdit   = (EditText)findViewById(R.id.editText1a);
        String text         = textEdit.getText().toString();
        Intent activityNext = new Intent(this, edu.wcu.CatamountChars.DisplayOneLetter.class);
        activityNext.putExtra("text", text);
        this.startActivity(activityNext);
    }
}