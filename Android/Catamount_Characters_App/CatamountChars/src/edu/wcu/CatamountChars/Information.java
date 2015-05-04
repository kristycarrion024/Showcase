package edu.wcu.CatamountChars;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 *
 * This class will display the appropriate information layout.
 *
 * @author Kristy Carrion
 * @date 9/19/13
 */
public class Information extends Activity {
    /**
     * This method will be run when this activity is initiated and will the information layout.
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.information);
    }
}