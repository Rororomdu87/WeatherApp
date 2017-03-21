package com.example.romain.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityInfosVilles extends AppCompatActivity {

    private static String API_KEY = "e6fb900e3feb77b61e5b8fbe065f8b1d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_villes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        City city = intent.getParcelableExtra("CITY");

        setTitle(city.getName());
        TextView nomVille = (TextView) findViewById(R.id.nomVille);
        TextView paysVille = (TextView) findViewById(R.id.paysVille);
        TextView latVille = (TextView) findViewById(R.id.latVille);
        TextView lonVille = (TextView) findViewById(R.id.lonVille);
        nomVille.setText("Ville : " + city.getName());
        paysVille.setText("Pays : " + city.getCountry());
        latVille.setText("Latitude : " + city.getCoord().getLat());
        lonVille.setText("Longitude : " + city.getCoord().getLon());
    }
}
