package com.example.aplicacionlistas1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.example.aplicacionlistas1.databinding.ActivityMainBinding;
import com.example.aplicacionlistas1.model.model.Anime;
import com.example.aplicacionlistas1.model.model.Animes;
import com.example.aplicacionlistas1.model.utils.Responses;
import com.example.aplicacionlistas1.model.viewModels.AnimeViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private ArrayList<Persona> nombres;
    AnimeViewModel animeViewModel;
    //private Persona per;


    //String url ="https://www.oxigeno.fm/wp-content/uploads/2023/04/bross.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        nombres = new ArrayList<>();
        //apellidos = new ArrayList<>();
        View view = binding.getRoot();
        setContentView(view);
        animeViewModel = new ViewModelProvider(this).get(AnimeViewModel.class);
        animeViewModel.getAnimes((ok, data) -> {
            if (ok) {
                updateListViewAnime(data);
            } else {

            }
        });
        binding.btnaceptar.setOnClickListener(this);
        binding.lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Persona per=(Persona)binding.lstView.getItemAtPosition(i);
                Intent intent=new Intent(MainActivity.this, DetalleItem.class);
                intent.putExtra("elemento",(Serializable) per);
                startActivity(intent);
                //Toast.makeText(MainActivity.this,per.getNombre().toString(),Toast.LENGTH_SHORT).show();
        }
        });

        }


    private void updateListView(ArrayList<Persona> datos) {

        personAdapter adapter= new personAdapter(this, nombres);


        binding.lstView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    private void updateListViewAnime(Animes datos) {

        AnimeAdapter adapter = new AnimeAdapter(this, datos.getData());


        binding.lstView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    private void addNames(String name,String apellido,String Url) {
        if (!name.equalsIgnoreCase("")) {
            Persona persona =new Persona(name,apellido,"Moviles",Url);
            nombres.add(persona);
            binding.txtApellido.setText("");
            binding.txtName.setText("");
            binding.txtUrl.setText("");
            updateListView(nombres);
        } else
        {
            Toast.makeText(this, "Ingrese un valor correcto", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.btnaceptar ){
           String nombre=binding.txtName.getText().toString();
           String apellido=binding.txtApellido.getText().toString();
           String url=binding.txtUrl.getText().toString();
           addNames(nombre,apellido,url);

       }
    }
}