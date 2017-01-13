package com.proyecto.openweather;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

            LlamadaWeather llamadaWeather = new LlamadaWeather();

            ArrayList<City> result = llamadaWeather.getCiudadesDefecto();

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
