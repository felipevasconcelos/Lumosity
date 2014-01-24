package com.example.rascunho;

import android.os.Bundle;
import android.util.Log;

/**
 * Created by revmob on 1/24/14.
 */
public class resultadoGame1 extends game1 {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("pontuacao", String.valueOf(points));

    }

}
