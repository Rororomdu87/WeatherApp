package com.example.romain.weatherapp;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s = getVilles();

        Gson gson = new Gson();
        ArrayList<City> cities= new ArrayList<>();
        Type type = new TypeToken<ArrayList<City>>(){}.getType();
        cities = gson.fromJson(s,type);
        for (City city:cities) {
            Log.i("city",city.toString());
        }

        //recyclerview

        // Création de l'Adapter avec pour paramètre la liste des Cities (passage par référence !!!) et un Listener pour gérer le clic
        final RecyclerView.Adapter<CityHolder> adapter = new CityAdapter(cities, new CityAdapter.OnCityListener() {
            @Override
            public void onCityClick(City city) {
                // Action lors du clic sur un item de la liste
                Toast.makeText(MainActivity.this, city.getName() + " " + city.getCountry() /*+ " " + city.getCoord()*/, Toast.LENGTH_LONG).show();
            }
        });

        // Récupération du recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Affectation du LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Affectation de l'Adapter
        recyclerView.setAdapter(adapter);

        //Fin recyclerView
    }

    public String getVilles() {
        String s = "";
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("city_france.json");
            if (inputStream != null) {
                BufferedReader br = null;
                StringBuilder sb = new StringBuilder();

                String line;
                try {

                    br = new BufferedReader(new InputStreamReader(inputStream));
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                s = sb.toString();
                Log.i("ville", s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}

