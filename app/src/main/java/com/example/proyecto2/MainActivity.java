package com.example.proyecto2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorites) {
            Intent intent = new Intent(this, FavoritasActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMascotas = findViewById(R.id.rvMascotas);
        rvMascotas.setLayoutManager(new LinearLayoutManager(this));

        inicializarMascotas();
        inicializarAdaptador();
    }

    private void inicializarMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Catty", 5, R.drawable.catty));
        mascotas.add(new Mascota("Doggy", 3, R.drawable.doggy));
        // Agregar más mascotas aquí
    }

    private void inicializarAdaptador() {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }
}

