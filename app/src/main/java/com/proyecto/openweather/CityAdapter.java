package com.proyecto.openweather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alex on 13/01/2017.
 */

public class CityAdapter extends ArrayAdapter<City> {

    TextView nameCity,descripcion;
    ImageView weatherImage;



    public CityAdapter(Context context, int resource, List<City> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtenim l'objecte en la possició corresponent
        City city = getItem(position);
        Log.w("XXXX", city.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.weatherrow, parent, false);
        }

        nameCity = (TextView) convertView.findViewById(R.id.nameCity);
        descripcion = (TextView) convertView.findViewById(R.id.descripcion);
        weatherImage = (ImageView) convertView.findViewById(R.id.weatherImage);

        nameCity.setText("Ciudad: " + city.getName());
        descripcion.setText("Cielo: " + city.getDescription());
        //Glide.with(getContext()).load(city.getIcon()).into(weatherImage);

        // Retornem la View replena per a mostrarla
        return convertView;
    }

}