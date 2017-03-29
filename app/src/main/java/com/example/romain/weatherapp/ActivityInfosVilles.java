package com.example.romain.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ActivityInfosVilles extends AppCompatActivity {

    public static ArrayList favoris = new ArrayList<City>();
    private static String TAG = "Weather";
    private static String API_KEY = "e6fb900e3feb77b61e5b8fbe065f8b1d";
    private static DecimalFormat df = new DecimalFormat("#.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos_villes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final City city = intent.getParcelableExtra("CITY");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if(favoris.contains(city)){
            //fab.setBackground(R.drawable.ic_star_black_24dp);
        }
        else{
            //fab.setBackground(R.drawable.ic_star_border_black_24dp);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favoris.contains(city)) {
                    favoris.remove(city);
                    Snackbar.make(view, "Vous avez retiré " + city.getName() + " des favoris", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    favoris.add(city);
                    Log.e("Favoris : ", favoris.toString());
                    Snackbar.make(view, "Vous avez ajouté " + city.getName() + " aux favoris", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        setTitle(city.getName());

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/weather?id=" + city.get_id() + "&appid=" + API_KEY + "&units=metric&lang=fr";
        Log.i("URL : ",url);

        // Request a string response from the provided URL.
        GsonRequest<CityWeather> request = new GsonRequest<>(url, CityWeather.class, null,
            new Response.Listener<CityWeather>() {
                @Override
                    public void onResponse(CityWeather response) {
                        Log.e(TAG, response.toString());
                        TextView temp = (TextView) findViewById(R.id.temp);
                        TextView main = (TextView) findViewById(R.id.main);
                        TextView description = (TextView) findViewById(R.id.description);
                        TextView temp_min = (TextView) findViewById(R.id.temp_min);
                        TextView temp_max = (TextView) findViewById(R.id.temp_max);
                        TextView humidity = (TextView) findViewById(R.id.humidity);
                        TextView pressure = (TextView) findViewById(R.id.pressure);
                        ImageView weatherIcon = (ImageView) findViewById(R.id.weatherIcon);
                        Glide.with(ActivityInfosVilles.this).load("http://openweathermap.org/img/w/" + response.getIcon() + ".png").into(weatherIcon);
                        TextView wind = (TextView) findViewById(R.id.wind);
                        temp.setText(response.getTemp() + "°C");
                        main.setText("Main : " + response.getMain());
                        description.setText("Description : " + response.getDescription());
                        temp_min.setText("Température minimale : " + response.getTemp_min() + "°C");
                        temp_max.setText("Température maximale : " + response.getTemp_max() + "°C");
                        humidity.setText("Humidité : " + response.getHumidity() + "%");
                        pressure.setText("Pression atmosphérique : " + response.getPressure() + " hPa");
                        wind.setText("Vitesse du vent : " + df.format(response.getWind()*3.6) + " Km/h");
                    }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.e("Erreur : ",error.toString());
                Toast.makeText(ActivityInfosVilles.this, "Erreur", Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(request);
    }
}
