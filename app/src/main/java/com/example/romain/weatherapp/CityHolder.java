package com.example.romain.weatherapp;

import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Romain on 17/03/2017.
 */

public class CityHolder extends RecyclerView.ViewHolder{
    private View view;
    private TextView nomView;
    private TextView countryView;
    private TextView latView;
    private TextView longView;

    private City city;

    // Constructeur
    public CityHolder(View itemView) {
        super(itemView);

        view = itemView;
        nomView = (TextView) view.findViewById(R.id.name);
        countryView = (TextView) view.findViewById(R.id.country);
        /*latView = (TextView) view.findViewById(R.id.coord);
        longView = (TextView) view.findViewById(R.id.coord);*/
    }

    // Méthode qui lie les données du City aux champs correspondant ainsi que le listener
    public void bind(City city, final CityAdapter.OnCityListener listener) {
        this.city = city;

        // Modification des champs
        nomView.setText(city.getName());
        countryView.setText(city.getCountry());
        /*latView.setText(String.valueOf(city.getCoord().getLat()));
        longView.setText(String.valueOf(city.getCoord().getLon()));*/

        // Affectation du listener
        if(listener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCityClick(CityHolder.this.city);
                }
            });

            /*view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onCityLongClick(CityHolder.this.city);
                    return false;
                }
            });*/
        }
    }
}

