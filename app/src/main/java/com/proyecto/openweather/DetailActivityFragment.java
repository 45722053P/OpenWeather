package com.proyecto.openweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    TextView titulo,id,name,lat,lon,pais,descripcion,temperatura,tempdia,tempmañana,tempnoche,tempmedianoche,tempmax,tempmin,speedWind,humedad,presion;
    ImageView iconoday;
    View viewDetails;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewDetails = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent i = getActivity().getIntent();

        if (i != null) {
            City ciudad = (City) i.getSerializableExtra("city");

            if (ciudad != null) {
                updateUi(ciudad);
            }
        }

        return viewDetails;
    }
    private void updateUi(City ciudad) {
        Log.d("CIUDAAAD", ciudad.toString());

        iconoday = (ImageView) viewDetails.findViewById(R.id.iconoday);
        titulo = (TextView) viewDetails.findViewById(R.id.tituloDetails);
        id = (TextView) viewDetails.findViewById(R.id.idDetails);
        name = (TextView) viewDetails.findViewById(R.id.namecityDetails);
        lat = (TextView) viewDetails.findViewById(R.id.latdetails);
        lon = (TextView) viewDetails.findViewById(R.id.longdetails);
        pais = (TextView) viewDetails.findViewById(R.id.paisdetails);
        descripcion = (TextView) viewDetails.findViewById(R.id.descripciondetails);
        temperatura = (TextView) viewDetails.findViewById(R.id.totalTemperatura);
        tempdia = (TextView) viewDetails.findViewById(R.id.tempdaydetails);
        tempmañana = (TextView) viewDetails.findViewById(R.id.tempmorndetails);
        tempnoche = (TextView) viewDetails.findViewById(R.id.tempsnigthdetails);
        tempmedianoche = (TextView) viewDetails.findViewById(R.id.tempevedetails);
        tempmin = (TextView) viewDetails.findViewById(R.id.tempmindetails);
        tempmax = (TextView) viewDetails.findViewById(R.id.tempmaxdetails);
        speedWind = (TextView) viewDetails.findViewById(R.id.speeddetails);
        humedad = (TextView) viewDetails.findViewById(R.id.humedaddetails);
        presion = (TextView) viewDetails.findViewById(R.id.presiondetails);

        titulo.setText(ciudad.getName());
        id.setText("ID CIUDAD: " + ciudad.getId());
        name.setText("NOMBRE: " + ciudad.getName());
        lat.setText("LATITUD: " + ciudad.getLat());
        lon.setText("LONGITUD" + ciudad.getLon());
        pais.setText("PAIS: " + ciudad.getCountry());
        descripcion.setText("ESTADO DEL CIELO: " + ciudad.getDescription());
        temperatura.setText("TEMPERATURAS: ");
        tempdia.setText("TEMPERATURA DE DIA: " + ciudad.getTempday());
        tempmañana.setText("TEMPERATURA DE MAÑANA: " + ciudad.getTempmorn());
        tempnoche.setText("TEMPERATURA DE NOCHE: " + ciudad.getTempnigth());
        tempmedianoche.setText("TEMPERATURA DE MEDIANOCHE: " + ciudad.getTempeve());
        tempmin.setText("TEMPERATURA MINIMA: " + ciudad.getTempMin());
        tempmax.setText("TEMPERATURA MAXIMA: " + ciudad.getTempMax());
        speedWind.setText("VELOCIDAD DEL VIENTO: " + ciudad.getSpeed());
        humedad.setText("HUMEDAD EN EL AMBIENTE: " + ciudad.getHumidity());
        presion.setText("PRESION ATMOSFERICA: " + ciudad.getPressure());
    }

}
