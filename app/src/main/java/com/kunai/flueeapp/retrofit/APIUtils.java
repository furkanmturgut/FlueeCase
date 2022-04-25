package com.kunai.flueeapp.retrofit;

public class APIUtils {
    public static  String BaseURL = "https://www.theaudiodb.com/";

    public static RetrofitInterface getFluueApp(){
        return RetrofitBuilder.getClient(BaseURL).create(RetrofitInterface.class);

    }
}
