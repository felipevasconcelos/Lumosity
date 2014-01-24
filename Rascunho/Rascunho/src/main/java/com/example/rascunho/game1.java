package com.example.rascunho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Debug;
import android.util.DebugUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by revmob on 1/23/14.
 */
public class game1 extends Activity {

    Integer [] imgs = {
            R.drawable.circle,
            R.drawable.square,
            R.drawable.triangle
    };

    List<Integer> pics = Arrays.asList(imgs);

    ImageView img = null;

    ImageView showAnswer = null;

    Timer timer = new Timer();

    Button yes;
    Button no;

    Context mContext;

    int oldImageIndex;
    int imageIndex;
    int points = 0;
    private int i =0;

    Random rand = new Random();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_layout);

        showAnswer = (ImageView) findViewById(R.id.answer);
        img = (ImageView) findViewById(R.id.imageView);

        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);

        yes.setVisibility(View.INVISIBLE);
        no.setVisibility(View.INVISIBLE);

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                if (oldImageIndex == imageIndex) {
                    points++;
                    showAnswer.setImageResource(R.drawable.correct);
                    Log.e("pontos", String.valueOf(points));

                }
                else {
                    showAnswer.setImageResource(R.drawable.wrong);
                    Log.e("pontos", String.valueOf(points));
                }
                oldImageIndex = imageIndex;
                imageIndex = rand.nextInt(3);
                img.setImageResource(imgs[imageIndex]);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (oldImageIndex == imageIndex) {
                    showAnswer.setImageResource(R.drawable.wrong);
                    Log.e("pontos", String.valueOf(points));
                }
                else {
                    points++;
                    showAnswer.setImageResource(R.drawable.correct);
                    Log.e("pontos", String.valueOf(points));
                }
                oldImageIndex = imageIndex;
                imageIndex = rand.nextInt(3);
                img.setImageResource(imgs[imageIndex]);

            }
        });

        imageIndex = rand.nextInt(3);
        img.setImageResource(imgs[imageIndex]);


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (i==0) {
                    showButtons();
                }

                /*if (i == 1){
                    Intent myIntent = new Intent(mContext,
                            InitialView.class);
                    startActivity(myIntent);
                    timer.cancel();
                }*/

                if(i == 1){
                    Log.e("pontos", String.valueOf(points));
                    timer.cancel();
                }

                i++;

            }
        }, 3 * 1000 , 1000 * 10);

    }

    private void showButtons() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);

                oldImageIndex = imageIndex;
                imageIndex = rand.nextInt(3);
                img.setImageResource(imgs[imageIndex]);
            }
        });
    }


    public void imageLeaving(Canvas canvas, int angle, Paint paint) {

        SurfaceBitmap bitmap;
        Bitmap teste;
        teste = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.square);






    }

}
