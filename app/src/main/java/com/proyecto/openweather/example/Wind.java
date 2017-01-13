
package com.proyecto.openweather.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private Double speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;
    @SerializedName("var_beg")
    @Expose
    private Integer varBeg;
    @SerializedName("var_end")
    @Expose
    private Integer varEnd;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Integer getVarBeg() {
        return varBeg;
    }

    public void setVarBeg(Integer varBeg) {
        this.varBeg = varBeg;
    }

    public Integer getVarEnd() {
        return varEnd;
    }

    public void setVarEnd(Integer varEnd) {
        this.varEnd = varEnd;
    }

}
