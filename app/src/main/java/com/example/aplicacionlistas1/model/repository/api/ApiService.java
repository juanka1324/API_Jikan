package com.example.aplicacionlistas1.model.repository.api;

import com.example.aplicacionlistas1.model.model.Animes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("anime")
    Call<Animes> getAnimes();
}
