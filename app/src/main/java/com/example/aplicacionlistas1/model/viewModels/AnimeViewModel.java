package com.example.aplicacionlistas1.model.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.aplicacionlistas1.model.model.Animes;
import com.example.aplicacionlistas1.model.repository.api.ApiServices;
import com.example.aplicacionlistas1.model.utils.Responses;

public class AnimeViewModel extends AndroidViewModel {
    ApiServices api;

    public AnimeViewModel(@NonNull Application application) {
        super(application);
        api = new ApiServices();
    }

    public void getAnimes(Responses.ResponseAnimesData ra){
        api.getAnimes(new Responses.responseAnimesApi() {
            @Override
            public void onGetData(Animes animes) {
                ra.onGetData(true, animes);
            }

            @Override
            public void onError() {
                ra.onGetData(false, null);
            }
        });
    }
}
