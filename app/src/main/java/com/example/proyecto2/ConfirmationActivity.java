package com.example.proyecto2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView tvNombreCompleto = findViewById(R.id.tvNombreCompleto);
        TextView tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono = findViewById(R.id.tvTelefono);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvDescripcion = findViewById(R.id.tvDescripcion);
        Button btnEditarDatos = findViewById(R.id.btnEditarDatos);

        // Recibir los datos del Intent
        Intent intent = getIntent();
        String nombreCompleto = intent.getStringExtra("nombreCompleto");
        String fechaNacimiento = intent.getStringExtra("fechaNacimiento");
        String telefono = intent.getStringExtra("telefono");
        String email = intent.getStringExtra("email");
        String descripcion = intent.getStringExtra("descripcion");

        // Mostrar los datos en los TextViews
        tvNombreCompleto.setText("Nombre Completo: " + nombreCompleto);
        tvFechaNacimiento.setText("Fecha de Nacimiento: " + fechaNacimiento);
        tvTelefono.setText("Teléfono: " + telefono);
        tvEmail.setText("Email: " + email);
        tvDescripcion.setText("Descripción: " + descripcion);

        // Botón para editar datos
        btnEditarDatos.setOnClickListener(v -> {
            Intent editIntent = new Intent(ConfirmationActivity.this, ContactFormActivity.class);
            editIntent.putExtra("nombreCompleto", nombreCompleto);
            editIntent.putExtra("fechaNacimiento", fechaNacimiento);
            editIntent.putExtra("telefono", telefono);
            editIntent.putExtra("email", email);
            editIntent.putExtra("descripcion", descripcion);
            startActivity(editIntent);
        });
    }
}

