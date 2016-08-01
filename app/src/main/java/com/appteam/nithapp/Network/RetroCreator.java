package com.appteam.nithapp.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * Created by Ramola on 7/31/2016.
 */
public class RetroCreator {
    public static RetroService getService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder oBuilder = new OkHttpClient.Builder();
        oBuilder.addNetworkInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).client(oBuilder.build()).build();
        RetroService service = retrofit.create(RetroService.class);
        return service;
    }
}


