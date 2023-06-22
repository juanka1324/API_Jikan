package com.example.aplicacionlistas1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aplicacionlistas1.model.model.Anime;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AnimeAdapter extends BaseAdapter {
    Context context;
    List<Anime> animes;

    public AnimeAdapter(Context context, List<Anime> animes) {
        this.context = context;
        this.animes = animes;
    }

    @Override
    public int getCount() {
        return animes.size();
    }

    @Override
    public Object getItem(int i) {
        return animes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        }
        Anime anime = animes.get(i);

        TextView txtName = view.findViewById(R.id.txtNameItem);
        TextView txtSurname = view.findViewById(R.id.txtSurnameItem);
        ImageView imgAnime = view.findViewById(R.id.imgElement);

        txtName.setText(anime.getTitle());
        txtSurname.setText(anime.getType());
        Glide.with(context).load(anime.getImages().getJpg().getImageUrl()).into(imgAnime);

        return view;
    }
}
