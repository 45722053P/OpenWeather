package com.proyecto.openweather;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alex on 13/01/2017.
 */

public class LlamadaWeather {

    private final String BASE_URL = "http://api.openweathermap.org/data/2.5";
    private final String APIKEY = "6ccb7be7c112de46b04c27a3f1dafda9";
    private final String lang = "es";
    private final String units = "metric";



    ArrayList<City> getCiudadesDefecto() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("find")
                .appendQueryParameter("lat","41")
                .appendQueryParameter("lon","2")
                .appendQueryParameter("lang", lang)
                .appendQueryParameter("units",units)
                .appendQueryParameter("appid",APIKEY)
                .build();
        String url = builtUri.toString();

        return llama(url);
    }

    ArrayList<City>getWeatherDays(String ciudad,String dias){
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("forecast")
                .appendPath("daily")
                .appendQueryParameter("q",ciudad)
                .appendQueryParameter("lang", lang)
                .appendQueryParameter("units",units)
                .appendQueryParameter("cnt",dias)
                .appendQueryParameter("appid",APIKEY)
                .build();
        String url = builtUri.toString();

        return llama(url);

    }



    @Nullable
    private ArrayList<City> llama(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private ArrayList<City> processJson(String jsonResponse) {

        ArrayList<City> cities = new ArrayList<>();

        try {

            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonCities = data.getJSONArray("list");

            for (int i = 0; i < jsonCities.length(); i++) {

                JSONObject jsonCity = jsonCities.getJSONObject(i);

                City city = new City();


                city.setId(jsonCity.getInt("id"));
                city.setName(jsonCity.getString("name"));

                if(jsonCity.has("coord")){
                            city.setLon(jsonCity.getJSONObject("coord").getDouble("lon"));
                            city.setLat(jsonCity.getJSONObject("coord").getDouble("lat"));
                }


                if(jsonCity.has("main")) {

                            city.setTemp(jsonCity.getJSONObject("main").getDouble("temp"));
                            city.setPressure(jsonCity.getJSONObject("main").getInt("pressure"));
                            city.setHumidity(jsonCity.getJSONObject("main").getInt("humidity"));
                            city.setTempMin(jsonCity.getJSONObject("main").getDouble("temp_min"));
                            city.setTempMax(jsonCity.getJSONObject("main").getDouble("temp_max"));

                }

                if(jsonCity.has("wind")){

                            city.setSpeed(jsonCity.getJSONObject("wind").getDouble("speed"));
                }



                if(jsonCity.has("weather")){

                        city.setDescription(jsonCity.getJSONArray("weather").getJSONObject(0).getString("description"));
                        city.setIcon((jsonCity.getJSONArray("weather").getJSONObject(0).getString("icon")));

                }


                Log.d("CITYYY",city.toString());
                cities.add(city);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cities;
    }


}
