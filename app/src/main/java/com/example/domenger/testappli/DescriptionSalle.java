package com.example.domenger.testappli;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DescriptionSalle extends Activity {

    private String tclasse;
    private String tjour;
    private String theure;
    private String tici;

    private String aileIci = "0";
    private String aileLaBas = "0";

    private Jour monday;
    private ArrayList emploiDuTemps;

    public class Horaire {
        public String hour;
        public String classe;
    }

    public class Jour {
        public String jour;
        public ArrayList horaires;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.itineraire);
        TextView Textclasse = (TextView) findViewById(R.id.textclasse);
        TextView Textheure = (TextView) findViewById(R.id.textheure);
        TextView Textjour = (TextView) findViewById(R.id.textjour);
        TextView txtresult = (TextView) findViewById(R.id.result);
        TextView txtinfo = (TextView) findViewById(R.id.information);
        TextView txtinfo2 = (TextView) findViewById(R.id.textView2);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            tclasse = (String) b.get("classe");
            Textclasse.setText(tclasse);
            tjour = (String) b.get("jour");
            Textjour.setText(tjour);
            theure = (String) b.get("heure");
            Textheure.setText(theure);
            tici = (String) b.get("ici");
            txtinfo2.setText(tici);
        }

        createEmploiDuTemps();
        String resultat = findClasse();
        txtresult.setText(resultat);

        if (resultat != "not found") {
            if(resultat != "aleatoire") {
                int res = Integer.parseInt(resultat);
                aileLaBas = "1";
                String info = localisation(res, "La salle de cours ");
                txtinfo.setText(info);
            }else{
                txtinfo.setText("La salle de votre prochain cours change aléatoirement, veuillez regarder sur le tableau pour la connaitre.");
            }
        }else{
            txtinfo.setText("La salle de cours n'a pas été trouvé, cela vient peu etre du fait que vous n'ayez pas cours a l'horaire rentré.");
        }


        if (tici.charAt(0) != 'V') {
            int int_ici = Integer.parseInt(tici);
            String info2 = localisation(int_ici, "La salle devant laquelle vous êtes, ");
            txtinfo2.setText(info2);
        }else{
            txtinfo2.setText("Vous n'avez pas lancer le scanner précédement");
        }


        Button bat = (Button) findViewById(R.id.vuBat);

        bat.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(DescriptionSalle.this, VuDesBatiments.class);
                intent.putExtra("ici", aileIci);
                intent.putExtra("labas", aileLaBas);
                startActivity(intent);
            }
        });

    }

    public void trouverAile(String b){
        if (aileLaBas == "1")
            aileLaBas = b;
        else
            aileIci = b;
    }

    public String localisation(int salle, String deb){
        String infos;
        //int salleInt = Integer.parseInt(salle);
        int salleInt = salle;
        System.out.println(salleInt);
        if (salleInt > 100) {
            infos = deb + "se trouve au premier étage,";
            if (salleInt<120){
                infos = infos + " dans l'aile en bas a gauche (sur le plan_rdc)";
                trouverAile("EBG");
            }else{
                if (salleInt<150) {
                    infos = infos + " dans l'aile en haut a gauche (sur le plan_rdc)";
                    trouverAile("EHG");
                }else{
                    if (salleInt<170) {
                        infos = infos + " dans l'aile en haut a droite (sur le plan_rdc)";
                        trouverAile("EHD");
                    }else{
                        infos = infos + " dans l'aile en bas a droite (sur le plan_rdc)";
                        trouverAile("EBD");
                    }
                }
            }
        }else {
            infos = deb + "se trouve au rez de chaussée";
            if (salleInt<20){
                infos = infos + " dans l'aile en bas a gauche (sur le plan_rdc)";
                trouverAile("RBG");
            }else{
                if (salleInt<40) {
                    infos = infos + " dans l'aile en haut a gauche (sur le plan_rdc)";
                    trouverAile("RHG");
                }else{
                    if (salleInt<70) {
                        infos = infos + " dans l'aile en haut a droite (sur le plan_rdc)";
                        trouverAile("RHD");
                    }else{
                        infos = infos + " dans l'aile en bas a droite (sur le plan_rdc)";
                        trouverAile("RBD");
                    }
                }
            }
        }
        return infos;
    }


    public void createEmploiDuTemps() {

        Horaire h1 = new Horaire();
        h1.hour = "8h10";
        h1.classe = "106";

        Horaire h2 = new Horaire();
        h2.hour = "9h05";
        h2.classe = "134";

        Horaire h3 = new Horaire();
        h3.hour = "10h15";
        h3.classe = "000"; //on ne connait pas la salle

        Horaire h4 = new Horaire();
        h4.hour = "11h05";
        h4.classe = "000"; //on ne connait pas la salle

        Horaire h5 = new Horaire();
        h5.hour = "13h55";
        h5.classe = "006";

        monday = new Jour();
        monday.jour = "lundi";
        monday.horaires = new ArrayList();
        monday.horaires.add(h1);
        monday.horaires.add(h2);
        monday.horaires.add(h3);
        monday.horaires.add(h4);
        monday.horaires.add(h5);

        Horaire h11 = new Horaire();
        h11.hour = "10h15";
        h11.classe = "182";

        Horaire h21 = new Horaire();
        h21.hour = "11h05";
        h21.classe = "182";

        Horaire h31 = new Horaire();
        h31.hour = "13h55";
        h31.classe = "156";

        Horaire h41 = new Horaire();
        h41.hour = "14h50";
        h41.classe = "160";

        Jour thuesday = new Jour();
        thuesday.jour = "mardi";
        thuesday.horaires = new ArrayList();
        thuesday.horaires.add(h11);
        thuesday.horaires.add(h21);
        thuesday.horaires.add(h31);
        thuesday.horaires.add(h41);

/*Horaire h12 = new Horaire();
      h12.hour = "8h10";
      h12.classe = "101";*/

        Horaire h22 = new Horaire();
        h22.hour = "10h15";
        h22.classe = "59";

        Horaire h32 = new Horaire();
        h32.hour = "11h05";
        h32.classe = "136";


        Jour wednesday = new Jour();
        wednesday.jour = "mercredi";
        wednesday.horaires = new ArrayList();
        //wednesday.horaires.add(h12);
        wednesday.horaires.add(h22);
        wednesday.horaires.add(h32);

        Horaire h13 = new Horaire();
        h13.hour = "8h10";
        h13.classe = "134";

        Horaire h23 = new Horaire();
        h23.hour = "9h05";
        h23.classe = "76";

        Horaire h33 = new Horaire();
        h33.hour = "10h15";
        h33.classe = "107";

        Horaire h43 = new Horaire();
        h43.hour = "11h05";
        h43.classe = "107";

        Horaire h53 = new Horaire();
        h53.hour = "12h55";
        h53.classe = "156";

        Horaire h63 = new Horaire();
        h63.hour = "13h55";
        h63.classe = "134";

        Horaire h73 = new Horaire();
        h73.hour = "14h50";
        h73.classe = "182";

        Horaire h83 = new Horaire();
        h83.hour = "16h00";
        h83.classe = "107";

        Horaire h93 = new Horaire();
        h73.hour = "16h50";
        h73.classe = "182";

        Jour thur = new Jour();
        thur.jour = "jeudi";
        thur.horaires = new ArrayList();
        thur.horaires.add(h13);
        thur.horaires.add(h23);
        thur.horaires.add(h33);
        thur.horaires.add(h43);
        thur.horaires.add(h53);
        thur.horaires.add(h63);
        thur.horaires.add(h73);
        thur.horaires.add(h83);
        thur.horaires.add(h93);


        Horaire h14 = new Horaire();
        h14.hour = "8h10";
        h14.classe = "182";

        Horaire h24 = new Horaire();
        h24.hour = "10h25";
        h24.classe = "aleatoire";

        Horaire h34 = new Horaire();
        h34.hour = "12h00";
        h34.classe = "176";

        Horaire h44 = new Horaire();
        h44.hour = "13h55";
        h44.classe = "2";


        Jour friday = new Jour();
        friday.jour = "vendredi";
        friday.horaires = new ArrayList();
        friday.horaires.add(h14);
        friday.horaires.add(h24);
        friday.horaires.add(h34);
        friday.horaires.add(h44);



        emploiDuTemps = new ArrayList();
        emploiDuTemps.add(monday);
        emploiDuTemps.add(thuesday);
        emploiDuTemps.add(wednesday);
        emploiDuTemps.add(thur);
        emploiDuTemps.add(friday);


    }

    public String findClasse() {

        for (int i = 0; i < emploiDuTemps.size(); i++) {
            Object o = emploiDuTemps.get(i);
            Jour j = (Jour) o;
            if (j.jour.charAt(0) == tjour.charAt(0) && j.jour.charAt(1) == tjour.charAt(1)) {
                for (int k = 0; k < j.horaires.size(); k++) {
                    Object o2 = j.horaires.get(k);
                    Horaire h = (Horaire) o2;
                    if (h.hour.charAt(0) == theure.charAt(0) && h.hour.charAt(1) == theure.charAt(1)){
                        return h.classe;
                    }
                }
            }
        }
        return "not found";
    }
}




