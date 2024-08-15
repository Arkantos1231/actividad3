package com.example.proyecto2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritasActivity extends AppCompatActivity {

    private RecyclerView rvFavoritas;
    private ArrayList<Mascota> mascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        // Habilitar botón de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvFavoritas = findViewById(R.id.rvFavoritas);
        rvFavoritas.setLayoutManager(new LinearLayoutManager(this));

        inicializarMascotasFavoritas();
        inicializarAdaptador();
    }

    private void inicializarMascotasFavoritas() {
        mascotasFavoritas = new ArrayList<>();
        mascotasFavoritas.add(new Mascota("Ronny", 3, R.drawable.doggy));
        mascotasFavoritas.add(new Mascota("Catty", 5, R.drawable.catty));
        // Añadir más mascotas de forma "Dummy"
    }

    private void inicializarAdaptador() {
        MascotaAdapter adaptador = new MascotaAdapter(mascotasFavoritas, this);
        rvFavoritas.setAdapter(adaptador);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Vuelve a la actividad padre
        return true;
    }
}
