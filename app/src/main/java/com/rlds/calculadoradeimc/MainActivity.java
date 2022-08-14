package com.rlds.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.rlds.calculadoradeimc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String peso = binding.editPeso.getText().toString();
                String altura = binding.editAtura.getText().toString();

                if(peso.isEmpty()){
                    binding.editPeso.setError("Informe seu Peso!");
                }else if(altura.isEmpty()) {
                    binding.editAtura.setError("Informe sua Altura!");

                }else {
                    // calcular IMC
                    calcularImc();


                }


            }
        });
    }
    private  void calcularImc(){
        float peso = Float.parseFloat(binding.editPeso.getText().toString());
        float altura = Float.parseFloat(binding.editAtura.getText().toString());
        float imc =  peso / (altura * altura);

        if(imc < 18.5){
            binding.txtResultado.setText(" Seu IMC é de  " + imc + "\n "+"Peso Baixo");

        }else if(imc <= 24.9){
            binding.txtResultado.setText(" Seu IMC é de  " + imc + "\n "+"Peso Normal");

        }else if(imc <= 29.9){
            binding.txtResultado.setText(" Seu IMC é de  " + imc + "\n "+"Sobrepeso");

        }else if(imc <= 34.9){
            binding.txtResultado.setText(" Seu IMC é de  " + imc + "\n "+"Obsidade (grau 1)");

        }else if(imc <= 39.9){
            binding.txtResultado.setText(" Seu IMC é de  " + imc + "\n "+"Obsidade Severa (grau 2");

        }else{
            binding.txtResultado.setText(" Seu IMC é de  " + imc + "\n "+"Obsidade Mórbida (frau 3)");
        }

    }

}