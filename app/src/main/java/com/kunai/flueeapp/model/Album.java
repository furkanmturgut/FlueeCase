
package com.kunai.flueeapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Album {

    @SerializedName("strAlbum")
    @Expose
    private String strAlbum;
    @SerializedName("intYearReleased")
    @Expose
    private String intYearReleased;

    public String getStrAlbum() {
        return strAlbum;
    }

    public void setStrAlbum(String strAlbum) {
        this.strAlbum = strAlbum;
    }

    public String getIntYearReleased() {
        return intYearReleased;
    }

    public void setIntYearReleased(String intYearReleased) {
        this.intYearReleased = intYearReleased;
    }

}
