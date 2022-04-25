
package com.kunai.flueeapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Artist {


    @SerializedName("strArtist")
    @Expose
    private String strArtist;

    @SerializedName("strBiographyEN")
    @Expose
    private String strBiographyEN;

    @SerializedName("strArtistThumb")
    @Expose
    private String strArtistThumb;

    private List<SearchModelFluee> articles = null;


    public String getStrArtist() {
        return strArtist;
    }

    public void setStrArtist(String strArtist) {
        this.strArtist = strArtist;
    }


    public String getStrBiographyEN() {
        return strBiographyEN;
    }

    public void setStrBiographyEN(String strBiographyEN) {
        this.strBiographyEN = strBiographyEN;
    }



    public String getStrArtistThumb() {
        return strArtistThumb;
    }

    public void setStrArtistThumb(String strArtistThumb) {
        this.strArtistThumb = strArtistThumb;
    }



}
