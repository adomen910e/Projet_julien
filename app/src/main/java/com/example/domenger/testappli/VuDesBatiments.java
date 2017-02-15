package com.example.domenger.testappli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import static com.example.domenger.testappli.R.id.imageView;

/**
 * Created by domenger on 27/01/2017.
 */

public class VuDesBatiments extends Activity {

    String ici;
    String labas;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vu_batiment);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            ici = (String) b.get("ici");
            labas = (String) b.get("labas");
        }

        if (ici.charAt(0) != '0')
            afficher_ici();

        if (labas.charAt(0) != '0')
            afficher_labas();
    }

    public void afficher_ici(){
        if (ici.charAt(0) == 'R' ) {
            if (ici.charAt(1) == 'B'){
                if (ici.charAt(2) == 'G'){
                    ImageView image = (ImageView) findViewById(R.id.rdcBG);
                    image.setImageResource(R.drawable.rdcbg);
                }else{
                    ImageView image = (ImageView) findViewById(R.id.rdcBD);
                    image.setImageResource(R.drawable.rdcbd);
                }
            }else{
                if (ici.charAt(2) == 'G'){
                    ImageView image = (ImageView) findViewById(R.id.rdcHG);
                    image.setImageResource(R.drawable.rdchg);
                }else{
                    ImageView image = (ImageView) findViewById(R.id.rdcHD);
                    image.setImageResource(R.drawable.rdchd);
                }
            }
        }else{
            if (ici.charAt(1) == 'B'){
                if (ici.charAt(2) == 'G'){
                    ImageView image = (ImageView) findViewById(R.id.etbg);
                    image.setImageResource(R.drawable.etbg);
                }else{
                    ImageView image = (ImageView) findViewById(R.id.etbd);
                    image.setImageResource(R.drawable.etbd);
                }
            }else{
                if (ici.charAt(2) == 'G'){
                    ImageView image = (ImageView) findViewById(R.id.ethg);
                    image.setImageResource(R.drawable.ethg);
                }else{
                    ImageView image = (ImageView) findViewById(R.id.ethd);
                    image.setImageResource(R.drawable.ethd);
                }
            }
        }
    }

    public void afficher_labas(){
        if (labas.charAt(0) == 'R' ) {
            if (labas.charAt(1) == 'B'){
                if (labas.charAt(2) == 'G'){
                    ImageView image = (ImageView) findViewById(R.id.imageView8);
                    image.setImageResource(R.drawable.bleubg);
                }else{
                    ImageView image = (ImageView) findViewById(R.id.imageView7);
                    image.setImageResource(R.drawable.bleubd);
                }
            }else{
                if (labas.charAt(2) == 'G'){
                    ImageView image = (ImageView) findViewById(R.id.imageView10);
                    image.setImageResource(R.drawable.bleuhg);
                }else{
                    ImageView image = (ImageView) findViewById(R.id.imageView9);
                    image.setImageResource(R.drawable.bleuhd);
                }
            }
        }else{
            if (labas.charAt(1) == 'B'){
                if (labas.charAt(2) == 'G'){
                    ImageView image = (ImageView) findViewById(R.id.etbleubg);
                    image.setImageResource(R.drawable.etbleubg);
                }else{
                    ImageView image = (ImageView) findViewById(R.id.etbleubd);
                    image.setImageResource(R.drawable.etbleubd);
                }
            }else{
                if (labas.charAt(2) == 'G'){
                    ImageView image = (ImageView) findViewById(R.id.etbleuhg);
                    image.setImageResource(R.drawable.etbleuhg);
                }else{
                    ImageView image = (ImageView) findViewById(R.id.etbleuhd);
                    image.setImageResource(R.drawable.etbleuhd);
                }
            }
        }
    }
}
