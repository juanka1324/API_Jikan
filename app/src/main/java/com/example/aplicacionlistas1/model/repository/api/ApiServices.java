package com.example.aplicacionlistas1.model.repository.api;

import com.example.aplicacionlistas1.model.model.Animes;
import com.example.aplicacionlistas1.model.utils.Responses;

import java.net.HttpURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServices {
    private ApiService API_SERVICE;
    private String BASE_URL = "https://api.jikan.moe/v4/";

    public ApiServices() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();
        API_SERVICE = new Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService.class);

    }

    public void getAnimes(final Responses.responseAnimesApi responseData) {
        API_SERVICE.getAnimes().enqueue(new Callback<Animes>() {
            @Override
            public void onResponse(Call<Animes> call, Response<Animes> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    responseData.onGetData(response.body());
                }
            }

            @Override
            public void onFailure(Call<Animes> call, Throwable t) {
                responseData.onError();
            }
        });
    }
}