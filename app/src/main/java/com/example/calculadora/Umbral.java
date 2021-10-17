package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Umbral extends AppCompatActivity {

    int Resultado;
    String Nombre;

    TextView verresultado;
    EditText umbral;
    TextView recomendacion;

    String opciones;

    Button calcular;
    TextView nombrepaciente;

    Button terminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umbral);
        try {
            Bundle TotalFinal =getIntent().getExtras();
            Resultado = TotalFinal.getInt("SubtotalDatosPaciente3");
            verresultado = findViewById(R.id.numresultado);
            verresultado.setText(Integer.toString(Resultado));
            System.out.println(Resultado);
        }
        catch(Exception e) {
            System.out.println("Hay un error");
            System.out.println(e);
        }

        umbral = findViewById(R.id.umbral);

        calcular = (Button) findViewById(R.id.calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int umbral = Integer.parseInt(Umbral.this.umbral.getText().toString());
                try {
                    Bundle nombrep =getIntent().getExtras();
                    Nombre = nombrep.getString("NombrePaciente");
                    System.out.println(Nombre);
                    nombrepaciente = findViewById(R.id.nombrep);
                    nombrepaciente.setText(Nombre);
                }
                catch(Exception e) {
                    System.out.println("Hay un error");
                    System.out.println(e);
                }
                if (Resultado > umbral) {
                    opciones = "Procedimiento NO justificado.";
                } else {
                    opciones = "Procedimiento justificado.";
                }
                try {
                    recomendacion = findViewById(R.id.recomendacion);
                    recomendacion.setText(opciones);
                    System.out.println(Resultado);
                }
                catch(Exception e) {
                    System.out.println("Hay un error");
                    System.out.println(e);
                }
            }
        });

        terminar = findViewById(R.id.terminar);
        terminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pasof = new Intent(getApplicationContext(), InicioSesion.class);
                startActivity(pasof);
            }
        });


    }

}