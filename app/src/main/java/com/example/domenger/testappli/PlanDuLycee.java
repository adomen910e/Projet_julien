package com.example.domenger.testappli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by domenger on 24/01/2017.
 */

public class PlanDuLycee extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_rdc);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.ecole);

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
                imageView2.setImageResource(R.drawable.ecole1);

            }
        });
    }



}
