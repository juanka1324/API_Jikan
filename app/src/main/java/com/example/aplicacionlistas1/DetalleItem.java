package com.example.aplicacionlistas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.aplicacionlistas1.databinding.ActivityDetalleItemBinding;

public class DetalleItem extends AppCompatActivity implements View.OnClickListener {

    ActivityDetalleItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleItemBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        Persona per =(Persona)getIntent().getSerializableExtra("elemento");
        Glide.with(this).load(per.getUrlImagen()).into(binding.imgperson);
        binding.txtnameperson.setText(per.getNombre());
        binding.txtsurnameperson.setText(per.getApellido());
        binding.btnback.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnback){
            finish();
        }


    }
}