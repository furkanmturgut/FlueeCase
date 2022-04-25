package com.kunai.flueeapp.retrofit;

import com.kunai.flueeapp.model.Artist;
import com.kunai.flueeapp.model.DiscographyModel;
import com.kunai.flueeapp.model.SearchModelFluee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("api/v1/json/2/search.php")
    Call<SearchModelFluee> myData (@Query("s") String name);

    @GET("api/v1/json/2/discography.php")
    Call<DiscographyModel> discographyData(@Query("s")String name);
}
