package com.example.aluno.conversormoeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerInicial);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.moedas_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Spinner spinner1 = (Spinner) findViewById(R.id.spinnerFinal);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.moedas_array,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

    }

    public void converterMoeda(View view)
    {
        Spinner spinnerIni = (Spinner) findViewById(R.id.spinnerInicial);
        Spinner spínnerFin = (Spinner) findViewById(R.id.spinnerFinal);
        EditText quant = (EditText)findViewById(R.id.quantidade);

        String valorInic = spinnerIni.getSelectedItem().toString();
        String valorFin = spínnerFin.getSelectedItem().toString();
        String quantidade = !quant.getText().toString().trim().isEmpty() ? quant.getText().toString() : "0.0";

        //Double.parseDouble(quant.getText().toString());

        Log.i("MainActivity",quantidade.toString());
        Double valor1 = 0.0;
        Double valor2 = 0.0;
        Double resultado = 0.0;

        //TextUtils.isEmpty(userName.getText()
        if (TextUtils.isEmpty(quantidade.toString())) {
            quant.setError("Informe o Nome do Anunciante");
            quant.requestFocus();
            return;

        }

        else if(valorInic.equals(valorFin))
        {
            Toast.makeText(this,"Escolha uma outra moeda para converter",Toast.LENGTH_SHORT).show();
        }

        else if (valorInic.equals("Real")){
            valor1 = 1.0;
            if(valorFin.equals("Dolar")){
                valor2 = 0.3;
            }else if(valorFin.equals("Iene")){
                valor2 = 32.0;
            }else if(valorFin.equals("Euro")){
                valor2 = 0.24;
            }
        }

        else if(valorInic.equals("Dolar")){
            valor1 = 1.0;
            if(valorFin.equals("Real")){
                valor2 = 3.31;
            }else if(valorFin.equals("Iene")){
                valor2 = 106.25;
            }else if(valorFin.equals("Euro")){
                valor2 = 0.81;
            }
        }

        else if(valorInic.equals("Iene")){
            valor1 = 1.0;
            if(valorFin.equals("Real")){
                valor2 = 0.03123;
            }else if(valorFin.equals("Dolar")){
                valor2 = 0.00941;
            }else if(valorFin.equals("Euro")){
                valor2 = 0.00766;
            }
        }

        else if(valorInic.equals("Euro")){
            valor1 = 1.0;
            if(valorFin.equals("Real")){
                valor2 = 4.0;
            }else if(valorFin.equals("Iene")){
                valor2 = 130.58;
            }else if(valorFin.equals("Dolar")){
                valor2 = 1.22;
            }
        }



        //Toast.makeText(this,valor1.toString(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,valor2.toString(),Toast.LENGTH_SHORT).show();

        resultado = (parseDouble(quantidade)*valor1)*valor2;

        Toast.makeText(this,resultado.toString(),Toast.LENGTH_SHORT).show();





    }

}
