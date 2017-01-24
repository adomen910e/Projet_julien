package com.example.domenger.testappli;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;

import static com.example.domenger.testappli.R.id.image;


/**
 * Created by domenger on 24/01/2017.
 */

public class BoutonPlan extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.ecole);
    }



}
