package com.example.jordansilva.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoEtanol;
    private EditText editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoEtanol = findViewById(R.id.editPrecoEtanol);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        //recuperar valores digitados no campo
        String precoEtanol = editPrecoEtanol.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar os campos digitados
        Boolean camposValidados = this.validarCampos(precoEtanol, precoGasolina);

        if ( camposValidados ){
            this.calcularMelhorPreco(precoEtanol, precoGasolina);
        } else {
            textResultado.setText("Informe os valores!");
        }
    }

    public void calcularMelhorPreco( String pEtanol, String pGasolina ) {
        // converter String em numeros
        Double precoEtanol = Double.parseDouble(pEtanol);
        Double precoGasolina = Double.parseDouble(pGasolina);

        Double resultado = precoEtanol / precoGasolina;

        if (resultado >= 0.7 ) {
            textResultado.setText("Melhor utilizar Gasolina!");

        }else{
            
            textResultado.setText("Melhor utilizar Álcool!");

        }
    }

    //novo metodo para validação dos parametros de entrada
    public Boolean validarCampos (String pEtanol, String pGasolina){

        Boolean camposValidados = true;

            if (pEtanol == null || pEtanol.equals("") ) {
                camposValidados = false;

            } else if (pGasolina == null || pGasolina.equals("") ) {
                camposValidados = false;
            }

        return camposValidados;
    }
}
