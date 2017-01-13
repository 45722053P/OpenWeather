package com.proyecto.openweather;

/**
 * Created by alex on 14/01/2017.
 */

public class Cordenadas {

    String lat;
    String lon;


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Cordenadas() {
    }

    @Override
    public String toString() {
        return "Cordenadas{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
