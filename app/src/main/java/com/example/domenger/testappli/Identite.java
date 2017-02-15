package com.example.domenger.testappli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Identite extends Activity{
    EditText classe, heure, jour;
    Button continuer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identite_utilisateur);

        classe = (EditText)findViewById(R.id.txtclasse);
        heure = (EditText)findViewById(R.id.txthoraire);
        jour = (EditText)findViewById(R.id.txtjour);

        ImageView image = (ImageView) findViewById(R.id.imageView3);
        image.setImageResource(R.drawable.tpe);


        continuer = (Button) findViewById(R.id.btnCancel);

        continuer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String txtClasse = classe.getText().toString();
                Log.v("Classe: ",txtClasse);

                String txtHeure = heure.getText().toString();
                Log.v("Heure: ",txtHeure);

                String txtJour = jour.getText().toString();
                Log.v("Jour: ",txtJour);

                Intent intent = new Intent(Identite.this, Scanner.class);
                intent.putExtra("classe", txtClasse);
                intent.putExtra("heure", txtHeure);
                intent.putExtra("jour", txtJour);
                startActivity(intent);
            }
        });

    }
}
