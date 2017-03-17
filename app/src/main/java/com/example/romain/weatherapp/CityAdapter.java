package com.example.romain.weatherapp;

import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romain on 17/03/2017.
 */

public class CityAdapter extends RecyclerView.Adapter<CityHolder> {

    // Interface permettant de gérer les actions sur une cellule
    public interface OnCityListener {
        void onCityClick(City city);
        //void onCityLongClick(City city);
    }

    private static final String TAG = "CityAdapter";
    private ArrayList<City> items;
    private OnCityListener listener;

    public CityAdapter(ArrayList<City> items, OnCityListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Création de la cellule
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_adapter, parent, false);

        // Création du holder à partir de la cellule
        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(CityHolder holder, int position) {
        // Bind de la cellule à partir de la City à la position
        City city = items.get(position);
        holder.bind(city, listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
