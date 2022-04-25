
package com.kunai.flueeapp.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SearchModelFluee {

    @SerializedName("artists")
    @Expose
    private List<Artist> artists = null;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

}
