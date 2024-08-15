package com.example.proyecto2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class ContactFormActivity extends AppCompatActivity {

    private EditText etNombreCompleto, etFechaNacimiento, etTelefono, etEmail, etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        etNombreCompleto = findViewById(R.id.etNombreCompleto);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);
        Button btnSiguiente = findViewById(R.id.btnSiguiente);

        // Verificar si hay datos precargados
        Intent intent = getIntent();
        if (intent != null) {
            etNombreCompleto.setText(intent.getStringExtra("nombreCompleto"));
            etFechaNacimiento.setText(intent.getStringExtra("fechaNacimiento"));
            etTelefono.setText(intent.getStringExtra("telefono"));
            etEmail.setText(intent.getStringExtra("email"));
            etDescripcion.setText(intent.getStringExtra("descripcion"));
        }

        // Configuración del DatePicker para la fecha de nacimiento
        etFechaNacimiento.setOnClickListener(v -> {
            final Calendar calendario = Calendar.getInstance();
            int anio = calendario.get(Calendar.YEAR);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(ContactFormActivity.this,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        String fechaSeleccionada = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        etFechaNacimiento.setText(fechaSeleccionada);
                    }, anio, mes, dia);
            datePickerDialog.show();
        });

        // Navegar a la siguiente actividad y enviar los datos ingresados
        btnSiguiente.setOnClickListener(v -> {
            Intent confirmIntent = new Intent(ContactFormActivity.this, ConfirmationActivity.class);
            confirmIntent.putExtra("nombreCompleto", etNombreCompleto.getText().toString());
            confirmIntent.putExtra("fechaNacimiento", etFechaNacimiento.getText().toString());
            confirmIntent.putExtra("telefono", etTelefono.getText().toString());
            confirmIntent.putExtra("email", etEmail.getText().toString());
            confirmIntent.putExtra("descripcion", etDescripcion.getText().toString());
            startActivity(confirmIntent);
        });
    }
}
