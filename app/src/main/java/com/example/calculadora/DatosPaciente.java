package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class DatosPaciente extends AppCompatActivity {

    TextView pulmonar1;
    Spinner EnfermedadPulmonarG;

    TextView cardiaca1;
    Spinner EnfermedadCardiacaG;

    TextView diabetes1;
    Spinner DiabetesG;

    TextView inmuno1;
    Spinner InmunoG;

    TextView obstructiva1;
    Spinner ObstructivaG;

    TextView covid1;
    Spinner CovidG;

    RadioGroup rg;

    RadioButton b1,b2;

    EditText edad1;
    EditText nombre1;

    int totalCovid;
    int totalPulmonar;
    int totalCardiaca;
    int totalDiabetes;
    int totalImuno;
    int totalApnea;
    int totalGripa;
    int totalEdad;

    Button siguiente;

    int TotalCalculado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_paciente);

        edad1 = findViewById(R.id.edad);

        pulmonar1 = (TextView) findViewById(R.id.pulmonar1);
        EnfermedadPulmonarG =findViewById(R.id.EnfermedadPulmonarG);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.EnfermedadPulmonar, android.R.layout.simple_spinner_dropdown_item);
        EnfermedadPulmonarG.setAdapter(adapter);

        EnfermedadPulmonarG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalPulmonar = 1;
                        break;
                    case 2:
                        totalPulmonar = 4;
                        break;
                    case 3:
                        totalPulmonar = 5;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        cardiaca1 = (TextView) findViewById(R.id.cardiaca1);
        EnfermedadCardiacaG =findViewById(R.id.EnfermedadCardiacaG);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.EnfermedadCardiaca, android.R.layout.simple_spinner_dropdown_item);
        EnfermedadCardiacaG.setAdapter(adapter1);

        EnfermedadCardiacaG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalCardiaca = 1;
                        break;
                    case 2:
                        totalCardiaca = 2;
                        break;
                    case 3:
                        totalCardiaca = 3;
                        break;
                    case 4:
                        totalCardiaca = 4;
                        break;
                    case 5:
                        totalCardiaca = 5;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        diabetes1 = (TextView) findViewById(R.id.diabetes1);
        DiabetesG =findViewById(R.id.DiabetesG);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.Diabetes, android.R.layout.simple_spinner_dropdown_item);
        DiabetesG.setAdapter(adapter2);

        DiabetesG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalDiabetes = 1;
                        break;
                    case 2:
                        totalDiabetes = 3;
                        break;
                    case 3:
                        totalDiabetes = 4;
                        break;
                    case 4:
                        totalDiabetes = 5;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        inmuno1 = (TextView) findViewById(R.id.inmuno1);
        InmunoG =findViewById(R.id.InmunoG);
        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.Inmuno, android.R.layout.simple_spinner_dropdown_item);
        InmunoG.setAdapter(adapter3);

        InmunoG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalImuno = 1;
                        break;
                    case 2:
                        totalImuno = 4;
                        break;
                    case 3:
                        totalImuno = 5;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        obstructiva1 = (TextView) findViewById(R.id.obstructiva1);
        ObstructivaG =findViewById(R.id.ObstructivaG);
        ArrayAdapter<CharSequence> adapter4=ArrayAdapter.createFromResource(this,R.array.Apnea, android.R.layout.simple_spinner_dropdown_item);
        ObstructivaG.setAdapter(adapter4);

        ObstructivaG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalApnea = 1;
                        break;
                    case 2:
                        totalApnea = 4;
                        break;
                    case 3:
                        totalApnea = 5;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        covid1 = (TextView) findViewById(R.id.covid1);
        CovidG =findViewById(R.id.CovidG);
        ArrayAdapter<CharSequence> adapter5=ArrayAdapter.createFromResource(this,R.array.Covid, android.R.layout.simple_spinner_dropdown_item);
        CovidG.setAdapter(adapter5);

        CovidG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        totalCovid = 1;
                        break;
                    case 2:
                        totalCovid = 2;
                        break;
                    case 3:
                        totalCovid = 3;
                        break;
                    case 4:
                        totalCovid = 4;
                        break;
                    case 5:
                        totalCovid = 5;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        b1 = (RadioButton) findViewById(R.id.Si);
        b2 = (RadioButton) findViewById(R.id.No);

        rg = (RadioGroup) findViewById(R.id.radiogroup1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.Si:
                        //System.out.println(R.id.Si);
                        totalGripa = 5;
                        break;
                    case R.id.No:
                        //System.out.println(R.id.No);
                        totalGripa = 1;
                        break;
                }
            }
        });


        siguiente = (Button) findViewById(R.id.siguiente1);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int edad = Integer.parseInt(edad1.getText().toString());
                if (edad <= 20) {
                    totalEdad = 1;
                } else if (edad >= 21 && edad <= 40) {
                    totalEdad = 2;
                } else if (edad >= 41 && edad <= 50) {
                    totalEdad = 3;
                } else if (edad >= 51 && edad <= 65) {
                    totalEdad = 4;
                } else {
                    totalEdad = 5;
                }

                System.out.println("Total Pulmonar ="+totalPulmonar);
                System.out.println("Total cardiaca ="+totalCardiaca);
                System.out.println("Total covid ="+totalCovid);
                System.out.println("Total diabetes ="+totalDiabetes);
                System.out.println("Total inmuno ="+totalImuno);
                System.out.println("Total edad ="+totalEdad);
                System.out.println("Total gripa ="+totalGripa);
                System.out.println("Total Apnea ="+totalApnea);

                nombre1 = findViewById(R.id.nombre);
                String nombre = nombre1.getText().toString();

                TotalCalculado = totalPulmonar+totalCovid+totalCardiaca+totalDiabetes+totalImuno+totalEdad+totalApnea+totalGripa;
                System.out.println("Total Calculado ="+TotalCalculado);
                Intent paso1 = new Intent(getApplicationContext(), DatosEnfermedad.class);
                paso1.putExtra("SubtotalDatosPaciente",TotalCalculado);
                paso1.putExtra("NombrePaciente", nombre);
                System.out.println("nombre="+nombre);
                startActivity(paso1);
            }
        });
    }
}