package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DatosEnfermedad extends AppCompatActivity {
    int TotalPaciente;
    String NombrePaciente;

    TextView eficacia1;
    Spinner EficaciaG;

    TextView disponibilidad1;
    Spinner DisponibilidadG;

    Button siguiente2;

    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    RadioGroup rg4;

    int TotalCalculado2;
    int totalDispo;
    int totalEfi;
    int totalImpacto2;
    int totalImpacto6;
    int totalDificultad2;
    int totalDificultad6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_enfermedad);

        Bundle Total1=getIntent().getExtras();
        TotalPaciente = Total1.getInt("SubtotalDatosPaciente");
        NombrePaciente = Total1.getString("NombrePaciente");
        System.out.println(NombrePaciente);

        siguiente2 = findViewById(R.id.siguiente2);
        siguiente2.setOnClickListener(view -> {
            System.out.println("Total disponibilidad ="+totalDispo);
            System.out.println("Total eficacia ="+totalEfi);
            System.out.println("Total impacto2 ="+totalImpacto2);
            System.out.println("Total impacto6 ="+totalImpacto6);
            System.out.println("Total dificultad2 ="+totalDificultad2);
            System.out.println("Total dificultad6 ="+totalDificultad6);
            System.out.println("Total ANTERIOR ="+TotalPaciente);

            TotalCalculado2 = totalDispo+totalEfi+totalImpacto2+totalImpacto6+totalDificultad2+totalDificultad6+TotalPaciente;
            System.out.println("Total calculado ="+ TotalCalculado2);
            Intent paso1 = new Intent(getApplicationContext(), DatosProcedimiento.class);
            paso1.putExtra("SubtotalDatosPaciente2",TotalCalculado2);
            paso1.putExtra("NombrePaciente",NombrePaciente);
            startActivity(paso1);
        });

        disponibilidad1 = findViewById(R.id.disponibilidad1);
        DisponibilidadG =findViewById(R.id.DisponibilidadG);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Disponibilidad, android.R.layout.simple_spinner_dropdown_item);
        DisponibilidadG.setAdapter(adapter);

        DisponibilidadG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalDispo = 1;
                        break;
                    case 2:
                        totalDispo = 2;
                        break;
                    case 3:
                        totalDispo = 3;
                        break;
                    case 4:
                        totalDispo = 4;
                        break;
                    case 5:
                        totalDispo = 5;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        eficacia1 = findViewById(R.id.eficacia1);
        EficaciaG =findViewById(R.id.EficaciaG);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.Eficacia, android.R.layout.simple_spinner_dropdown_item);
        EficaciaG.setAdapter(adapter1);

        EficaciaG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalEfi = 1;
                        break;
                    case 2:
                        totalEfi = 2;
                        break;
                    case 3:
                        totalEfi = 3;
                        break;
                    case 4:
                        totalEfi = 4;
                        break;
                    case 5:
                        totalEfi = 5;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        rg1 = findViewById(R.id.impacto2);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.N11:
                        totalImpacto2 = 1;
                        break;
                    case R.id.N21:
                        totalImpacto2 = 2;
                        break;
                    case R.id.N31:
                        totalImpacto2 = 3;
                        break;
                    case R.id.N41:
                        totalImpacto2 = 4;
                        break;
                    case R.id.N51:
                        totalImpacto2 = 5;
                        break;
                }
            }
        });

        rg2 = (RadioGroup) findViewById(R.id.impacto6);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.N1:
                        totalImpacto6 = 1;
                        break;
                    case R.id.N2:
                        totalImpacto6 = 2;
                        break;
                    case R.id.N3:
                        totalImpacto6 = 3;
                        break;
                    case R.id.N4:
                        totalImpacto6 = 4;
                        break;
                    case R.id.N5:
                        totalImpacto6 = 5;
                        break;
                }
            }
        });

        rg3 = (RadioGroup) findViewById(R.id.dificultad2);
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.D1:
                        totalDificultad2 = 1;
                        break;
                    case R.id.D2:
                        totalDificultad2 = 2;
                        break;
                    case R.id.D3:
                        totalDificultad2 = 3;
                        break;
                    case R.id.D4:
                        totalDificultad2 = 4;
                        break;
                    case R.id.D5:
                        totalDificultad2 = 5;
                        break;
                }
            }
        });

        rg4 = (RadioGroup) findViewById(R.id.dificultad6);
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.D11:
                        totalDificultad6 = 1;
                        break;
                    case R.id.D21:
                        totalDificultad6 = 2;
                        break;
                    case R.id.D31:
                        totalDificultad6 = 3;
                        break;
                    case R.id.D41:
                        totalDificultad6 = 4;
                        break;
                    case R.id.D51:
                        totalDificultad6 = 5;
                        break;
                }
            }
        });

    }

}