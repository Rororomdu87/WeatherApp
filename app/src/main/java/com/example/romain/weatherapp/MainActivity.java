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

        AssetManager am = getAssets();
        InputStream is = null;
        BufferedReader reader = null;
        String contents = "";

        try {
            is = am.open("test.json");
            reader = new BufferedReader(new InputStreamReader(is));
            contents = reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                contents += line;
            }

            Log.e("content", contents);
            Type collectionType = new TypeToken<ArrayList<City>>(){}.getType();

            Gson gson=new Gson();
            ArrayList<City> cities = gson.fromJson(contents, collectionType);
            for(City c:cities) {
                Log.e("ville : ",c.toString());
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally { //fermeture du fichier
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ignored) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}

