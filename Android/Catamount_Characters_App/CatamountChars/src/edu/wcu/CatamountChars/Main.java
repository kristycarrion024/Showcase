package edu.wcu.CatamountChars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

/**
 * This is the splash screen activity that is displayed when the application is started.
 *
 * @author Kristy Carrion
 * @date 09/19/2013
 */
public class Main extends Activity {

    // This is a final variable used to hold the int time the splash will be displayed on the screen.
    final int PAUSE = 5000;
    // Handler object for postDelayed.
    Handler handler;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Removes the title that is part of the theme. I could have changed the theme but this works too!
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
    }

    /*
     * Protect method that is run when the application is started. This method creates a handler and makes the
     * splash picture run for 5000 milliseconds, or 5 seconds.
     */
    protected void onStart() {
        super.onStart();
        handler = new Handler();
        handler.postDelayed(r, PAUSE);
    }  //end of onStart

    /*
     * Runnable method that will automatically run the next screen after the 5000 milliseconds is up.
     */
    final Runnable r = new Runnable()
    {
        public void run()
        {
            goToNextScreen();
        }
    };

    /*
     * goToNextScreen will generate a new intent, start the next activity, and then finish the splash screen.
     */
    private void goToNextScreen()
    {
        Intent menu = new Intent(this, edu.wcu.CatamountChars.MainMenu.class);
        this.startActivity(menu);
        finish();
    }
}
