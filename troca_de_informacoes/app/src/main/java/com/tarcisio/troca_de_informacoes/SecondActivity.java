package com.tarcisio.troca_de_informacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvOutput = findViewById(R.id.tvOutput);

        String nome = getIntent().getExtras().getString("Nome");
        String sobrenome = getIntent().getExtras().getString("Sobrenome");

        if(isNumeric(nome) && isNumeric(sobrenome)){//Se eles forem números, eu os somo.
            double soma = Double.parseDouble(nome)+Double.parseDouble(sobrenome);
            tvOutput.setText(soma+"");
        }

        else tvOutput.setText(nome+sobrenome);
    }

    public static boolean isNumeric(String s){
        try {
            Double.parseDouble(s);
            return true;//Se não ocorrer uma exceção, é retornado true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

}
