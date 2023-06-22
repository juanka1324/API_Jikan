package com.example.aplicacionlistas1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class personAdapter extends BaseAdapter {

Context context;
ArrayList<Persona> personas;

    public personAdapter(Context context, ArrayList<Persona> personas) {
        this.context = context;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Persona getItem(int i) {
        return personas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = LayoutInflater.from(context).inflate(
                    R.layout.item_list,
                    viewGroup,
                    false
            );
        }
        Persona persona = personas.get(i);
        TextView txtname = view.findViewById(R.id.txtNameItem);
        TextView txtSurname = view.findViewById(R.id.txtSurnameItem);
        ImageView imgPerson = view.findViewById(R.id.imgElement);

        String fullName = persona.getNombre() + " " + persona.getApellido();

        txtname.setText(fullName);
        txtSurname.setText(persona.getMateria());

        Glide.with(context).load(persona.getUrlImagen()).into(imgPerson);
        return view;
    }
}
