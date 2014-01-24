package com.example.rascunho;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;


/**
 * Created by revmob on 1/24/14.
 */
public class SurfaceBitmap {

    private Bitmap mBitmap;
    int left, top, cX, cY;

    public void draw(Canvas canvas, int angle, Paint paint){
        canvas.save();
        canvas.rotate(angle, cX, cY);
        canvas.drawBitmap(mBitmap,left, top, paint);
        canvas.restore();
    }

    public Bitmap bitmap(){
        return mBitmap;
    }




}
