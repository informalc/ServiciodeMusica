package com.example.aceptacioncondiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView nombre, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.txtNombre);
        edad = findViewById(R.id.txtEdad);
    }

    public void btnVerificar (View view){

        //Verificar que los campos no están vacíos
        if (nombre.getText().length() != 0 && edad.getText().length() != 0) {
            if (Integer.parseInt(edad.getText().toString()) > 100 || Integer.parseInt(edad.getText().toString()) < 0){
                Toast.makeText(MainActivity.this, "Introduce edad válida", Toast.LENGTH_LONG).show();
            } else if(Integer.parseInt(edad.getText().toString()) > 17){
                // Llamar Activity 2
                Toast.makeText(MainActivity.this, "+18", Toast.LENGTH_LONG).show();
            } else{
                // Llamar Activiy Menores
                Toast.makeText(MainActivity.this, "-18", Toast.LENGTH_LONG).show();
            }
        }else if(nombre.getText().length() == 0 && edad.getText().length() == 0){ // Nombre y Edad están vacíos
            Toast.makeText(MainActivity.this, "Campos vacíos", Toast.LENGTH_LONG).show();
        }else if(nombre.getText().length() == 0 && edad.getText().length() != 0){ //Nombre vacío
            Toast.makeText(MainActivity.this, "Introduce nombre", Toast.LENGTH_LONG).show();
        } else{ //Edad vacía
            Toast.makeText(MainActivity.this, "Introduce edad", Toast.LENGTH_LONG).show();
        }

    }
}