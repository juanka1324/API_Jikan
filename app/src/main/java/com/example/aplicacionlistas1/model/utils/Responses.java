package com.example.aplicacionlistas1.model.utils;

import com.example.aplicacionlistas1.model.model.Animes;

public class Responses {
    public static interface responseAnimesApi {
        void onGetData(Animes animes);
        void onError();
    }

    public interface ResponseAnimesData {
        void onGetData(Boolean correcto, Animes animes);

    }
}
