package com.example.domenger.testappli;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by domenger on 27/01/2017.
 */

public class VuDesBatiments extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vu_batiment);

        ImageView imageView = (ImageView) findViewById(R.id.rdcBD);
        imageView.setImageResource(R.drawable.rdcbd);

    }

}
