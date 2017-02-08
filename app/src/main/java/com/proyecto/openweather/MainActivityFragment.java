package com.proyecto.openweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private CityAdapter adapter;
    private ArrayList<City> items;

    ListView listWeather;


    public MainActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainFragment =  inflater.inflate(R.layout.fragment_main, container, false);


        listWeather = (ListView)mainFragment.findViewById(R.id.listaTiempo);

//        String [] tiempo = {
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona",
//                "dia 1 Barcelona"
//
//        };

        items = new ArrayList<>();
        adapter = new CityAdapter(
                getContext(),
                R.layout.weatherrow,
                items
        );

        listWeather.setAdapter(adapter);
        listWeather.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                City city = (City) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("city", city);

                startActivity(intent);
            }
        });

        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(getActivity(),SettingsActivity.class);

            startActivity(intent);

            return true;
        }else if (id == R.id.refreshButton) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void refresh() {

        RefreshBack back = new RefreshBack();
        back.execute();

    }

    private class RefreshBack extends AsyncTask<Void,Void,ArrayList<City>> {

        @Override
        protected ArrayList<City> doInBackground(Void... voids) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            String ciudad = preferences.getString("Ciudad", "");
            String dias = preferences.getString("Dias Prediccion","");
//            int Lat = preferences.getInt("Latitud",0);
//            int Long = preferences.getInt("Longitud",0);

            LlamadaWeather llamadaWeather = new LlamadaWeather();

            ArrayList<City> result = null;


            if(dias.equals("") && ciudad.equals("")){

                result = llamadaWeather.getCiudadesDefecto();

            }else if(dias.equals("1") || dias.equals("2") || dias.equals("3") || dias.equals("4") || dias.equals("5")){

                result = llamadaWeather.getWeatherDays(ciudad,dias);

            //Pongo 12 pero seria mayor de 5.
            } else if(dias.equals("6") || dias.equals("7") || dias.equals("8") || dias.equals("9") || dias.equals("10") || dias.equals("11") || dias.equals("12")){

                result = llamadaWeather.getWeatherDays(ciudad,dias);
                Snackbar.make(listWeather, "Dia de Prediccion incorrecto maximo 5 dias", Snackbar.LENGTH_LONG)
                        .show();

            }
    // else if(Lat >= 1 && Long >= 1){
    //                llamadaWeather.getCiudadesCircumferencia(Lat,Long);
    //            }

            Log.d("DEBUUUUG",result.toString());

            return result;

        }

        @Override
        protected void onPostExecute(ArrayList<City> cities) {

            adapter.clear();
            for(City ciudad : cities){
                adapter.add(ciudad);
            }

        }
    }


}
