package com.proyecto.openweather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
    // pagina para iconos. SOLEADO:         http://openweathermap.org/img/w/01d.png
    //                      sol nubes:      http://openweathermap.org/img/w/02d.png
    //                      nubes:          http://openweathermap.org/img/w/03d.png
    //                      nubes1negra:    http://openweathermap.org/img/w/04d.png
    //                      nubes lloviendo:http://openweathermap.org/img/w/09d.png
    //                SOL CON NUBES LLUEVE: http://openweathermap.org/img/w/10d.png
    //                  Lluvia con rayos:   http://openweathermap.org/img/w/11d.png
    //                  nubes nieve         http://openweathermap.org/img/w/13d.png

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

        if(city.getDescription().equals("cielo claro")){
            city.setIcon("http://openweathermap.org/img/w/01d.png");

        }else if(city.getDescription().equals("algo de nubes")){
            city.setIcon("http://openweathermap.org/img/w/02d.png");

        }else if(city.getDescription().equals("nubes dispersas")){
            city.setIcon("http://openweathermap.org/img/w/03d.png");

        }else if(city.getDescription().equals("nubes rotas")){
            city.setIcon("http://openweathermap.org/img/w/04d.png");

        }else if(city.getDescription().equals("lluvia ligera")){
            city.setIcon("http://openweathermap.org/img/w/10d.png");

        }else if(city.getDescription().equals("lluvia moderada")){
            city.setIcon("http://openweathermap.org/img/w/09d.png");

        }else if(city.getDescription().equals("lluvia de gran intensidad")){
            city.setIcon("http://openweathermap.org/img/w/09d.png");
        }

        
        Glide.with(getContext()).load(city.getIcon()).into(weatherImage);

        // Retornem la View replena per a mostrarla
        return convertView;
    }

}