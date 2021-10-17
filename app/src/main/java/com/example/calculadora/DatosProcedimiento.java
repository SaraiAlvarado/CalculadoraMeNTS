package com.example.calculadora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class DatosProcedimiento extends AppCompatActivity {
    int TotalEnfermedad;
    int TotalCalculado3;
    String NombrePaciente;

    TextView sitio1;
    Spinner SitioG;

    int totalSitio;
    int totalDuración;
    int totalQuirofano;
    int totalUci;
    int totalSangre;
    int totalEquipo;
    int totalIntubacion;

    Slider quirofano1;
    Slider uci1;
    Slider sangre1;
    Slider equipo1;
    Slider intubacion1;

    RadioGroup radioduracion;

    Button siguiente3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_procedimiento);

        Bundle Total3=getIntent().getExtras();
        TotalEnfermedad = Total3.getInt("SubtotalDatosPaciente2");
        NombrePaciente = Total3.getString("NombrePaciente");
        System.out.println(NombrePaciente);

        siguiente3 = findViewById(R.id.siguiente3);
        siguiente3.setOnClickListener(view -> {
            System.out.println("Total duración ="+totalDuración);
            System.out.println("Total sitio ="+totalSitio);
            System.out.println("Total intubacion ="+totalIntubacion);
            System.out.println("Total quirofano="+totalQuirofano);
            System.out.println("Total uci ="+totalUci);
            System.out.println("Total sangre ="+totalSangre);
            System.out.println("Total equipo ="+totalEquipo);
            System.out.println("Total ANTERIOR ="+TotalEnfermedad);
            TotalCalculado3 = totalDuración+totalSitio+totalIntubacion+totalQuirofano+totalUci+totalSangre+totalEquipo+TotalEnfermedad;
            System.out.println("Total FINAL="+TotalCalculado3);
            Intent paso3 = new Intent(getApplicationContext(), Umbral.class);
            paso3.putExtra("SubtotalDatosPaciente3",TotalCalculado3);
            paso3.putExtra("NombrePaciente",NombrePaciente);
            startActivity(paso3);
        });

        quirofano1 = findViewById(R.id.quirofano);
        quirofano1.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                //try {
                int quirofano = (int)value;
                System.out.println(value);
                if (quirofano<= 30) {
                    totalQuirofano = 1;
                } else if (quirofano >= 31 && quirofano <= 60) {
                    totalQuirofano = 2;
                } else if (quirofano >= 61 && quirofano <= 120) {
                    totalQuirofano = 3;
                } else if (quirofano >= 121 && quirofano <= 65) {
                    totalQuirofano = 4;
                } else {
                    totalQuirofano = 5;
                }
                //}
                //catch(Exception e){
                //System.out.println("Hay un error");
                //System.out.println(e);
                //}
            }
        });

        uci1 = findViewById(R.id.uci);
        uci1.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int uci = (int)value;
                System.out.println(value);
                if (uci == 0) {
                    totalUci = 1;
                } else if (uci > 0 && uci <5) {
                    totalUci = 2;
                } else if (uci >= 5 && uci <= 10) {
                    totalUci = 3;
                } else if ( uci >= 11 && uci <= 25) {
                    totalUci = 4;
                } else {
                    totalUci = 5;
                }
            }
        });

        sangre1 = findViewById(R.id.sangre);
        sangre1.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int sangre = (int)value;
                System.out.println(value);
                if (sangre < 100) {
                    totalSangre = 1;
                } else if (sangre >=100 && sangre <=250) {
                    totalSangre = 2;
                } else if (sangre >= 251 && sangre <= 500) {
                    totalSangre = 3;
                } else if ( sangre >= 501 && sangre <= 750) {
                    totalSangre = 4;
                } else {
                    totalSangre = 5;
                }
            }
        });

        equipo1 = findViewById(R.id.equipo);
        equipo1.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int equipo = (int)value;
                System.out.println(value);
                if (equipo == 1) {
                    totalEquipo = 1;
                } else if (equipo==2) {
                    totalEquipo = 2;
                } else if (equipo==3) {
                    totalEquipo = 3;
                } else if (equipo==4) {
                    totalEquipo = 4;
                } else {
                    totalEquipo = 5;
                }
            }
        });

        intubacion1 = findViewById(R.id.intubacion);
        intubacion1.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int intubacion = (int)value;
                System.out.println(value);
                if (intubacion <=1) {
                    totalIntubacion = 1;
                } else if (intubacion >1 && intubacion <=5) {
                    totalIntubacion = 2;
                } else if (intubacion >=6 && intubacion <= 10) {
                    totalIntubacion = 3;
                } else if (intubacion >= 11 && intubacion <= 25) {
                    totalIntubacion = 4;
                } else {
                    totalIntubacion = 5;
                }
            }
        });

        radioduracion = (RadioGroup) findViewById(R.id.radiorduracion);
        radioduracion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.ambulatorio:
                        totalDuración = 1;
                        break;
                    case R.id.horas1:
                        totalDuración = 2;
                        break;
                    case R.id.horas2:
                        totalDuración = 3;
                        break;
                    case R.id.horas3:
                        totalDuración= 4;
                        break;
                    case R.id.horas4:
                        totalDuración = 5;
                        break;
                }
            }
        });

        sitio1 = findViewById(R.id.sitio1);
        SitioG =findViewById(R.id.SitioG);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Sitio, android.R.layout.simple_spinner_dropdown_item);
        SitioG.setAdapter(adapter);

        SitioG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalSitio = 2;
                        break;
                    case 2:
                        totalSitio = 3;
                        break;
                    case 3:
                        totalSitio = 4;
                        break;
                    case 4:
                        totalSitio = 5;
                        break;
                    case 5:
                        totalSitio = 1;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}