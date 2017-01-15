package com.proyecto.openweather;

import java.io.Serializable;

/**
 * Created by alex on 13/01/2017.
 */

public class City implements Serializable{

    Integer id;
    String name;
    Double lon;
    Double lat;
    Double temp;
    Integer pressure;
    Integer humidity;
    Double tempday;
    Double tempnigth;
    Double tempeve;
    Double tempmorn;
    Double tempMin;
    Double tempMax;
    Double speed;
    String description;
    String icon;


    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getTempday() {
        return tempday;
    }

    public void setTempday(Double tempday) {
        this.tempday = tempday;
    }

    public Double getTempnigth() {
        return tempnigth;
    }

    public void setTempnigth(Double tempnigth) {
        this.tempnigth = tempnigth;
    }

    public Double getTempeve() {
        return tempeve;
    }

    public void setTempeve(Double tempeve) {
        this.tempeve = tempeve;
    }

    public Double getTempmorn() {
        return tempmorn;
    }

    public void setTempmorn(Double tempmorn) {
        this.tempmorn = tempmorn;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", tempday=" + tempday +
                ", tempnigth=" + tempnigth +
                ", tempeve=" + tempeve +
                ", tempmorn=" + tempmorn +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", speed=" + speed +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
