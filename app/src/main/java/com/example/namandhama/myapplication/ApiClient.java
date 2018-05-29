package com.example.namandhama.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class ApiClient {

    public static final String BASE_URL="https://simplifiedcoding.net/demos/";

    public static Retrofit retrofit=null;


    public static Retrofit getApiClient()
    {

        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();


            }




       return retrofit;
    }
}
