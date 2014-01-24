package com.example.rascunho;

import com.example.rascunho.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class InitialView extends Activity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    public int gameplay;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_initial_view);

        final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final View contentView = findViewById(R.id.fullscreen_content);

        Button game_play_1;
        Button game_play_2;
        Button game_play_3;
        Button game_play_4;

        // Set up an instance of SystemUiHider to control the system UI for
        // this activity.
        mSystemUiHider = SystemUiHider.getInstance(this, contentView, HIDER_FLAGS);
        mSystemUiHider.setup();
        mSystemUiHider
                .setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
                    // Cached values.
                    int mControlsHeight;
                    int mShortAnimTime;

                    @Override
                    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
                    public void onVisibilityChange(boolean visible) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                            // If the ViewPropertyAnimator API is available
                            // (Honeycomb MR2 and later), use it to animate the
                            // in-layout UI controls at the bottom of the
                            // screen.
                            if (mControlsHeight == 0) {
                                mControlsHeight = controlsView.getHeight();
                            }
                            if (mShortAnimTime == 0) {
                                mShortAnimTime = getResources().getInteger(
                                        android.R.integer.config_shortAnimTime);
                            }
                            controlsView.animate()
                                    .translationY(visible ? 0 : mControlsHeight)
                                    .setDuration(mShortAnimTime);
                        } else {
                            // If the ViewPropertyAnimator APIs aren't
                            // available, simply show or hide the in-layout UI
                            // controls.
                            controlsView.setVisibility(visible ? View.VISIBLE : View.GONE);
                        }

                        if (visible && AUTO_HIDE) {
                            // Schedule a hide().
                           // delayedHide(AUTO_HIDE_DELAY_MILLIS);
                        }
                    }
                });

        // Set up the user interaction to manually show or hide the system UI.
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TOGGLE_ON_CLICK) {
                    mSystemUiHider.toggle();
                } else {
                    mSystemUiHider.show();
                }
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.

        game_play_1 = (Button) findViewById(R.id.game_play_1);
        game_play_2 = (Button) findViewById(R.id.game_play_2);
        game_play_3 = (Button) findViewById(R.id.game_play_3);
        game_play_4 = (Button) findViewById(R.id.game_play_4);

        game_play_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                gameplay = Constants.choice.gp1;
                sceneToCall();
            }
        });
        game_play_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                gameplay = Constants.choice.gp2;
                sceneToCall();
            }
        });

        game_play_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                gameplay = Constants.choice.gp3;
                sceneToCall();
            }
        });

        game_play_4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                gameplay = Constants.choice.gp4;
                sceneToCall();
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
       // delayedHide(100);
    }

    private void sceneToCall() {
        Log.e("scene", "tocall");
        switch (gameplay){

            case 1:{
                Intent myIntent = new Intent(this,
                        game1.class);
                startActivity(myIntent);
                Log.e("este", "aso 1");
                break;
            }
            case 2:{
                Intent myIntent = new Intent(this,
                        game2.class);
                startActivity(myIntent);
                Log.e("este", "aso 2");
                break;
            }
            case 3:{
                Intent myIntent = new Intent(this,
                        game3.class);
                startActivity(myIntent);
                Log.e("este", "aso3");
                break;
            }
            case 4:{
                Intent myIntent = new Intent(this,
                        game4.class);
                startActivity(myIntent);
                Log.e("este", "aso4");
                break;
            }
        }
        Log.e("valor gameplay pos click", String.valueOf(gameplay));
    }
}
