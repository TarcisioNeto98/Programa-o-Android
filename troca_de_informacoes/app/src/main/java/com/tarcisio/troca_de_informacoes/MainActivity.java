package com.tarcisio.troca_de_informacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    EditText etNome, etSobrenome;
    Button bSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNome = findViewById(R.id.etNome);
        etSobrenome = findViewById(R.id.etSobrenome);
        bSend = findViewById(R.id.bSend);

        etNome.setText("");
        etSobrenome.setText("");
        bSend.setText("Send");

        bSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.setAction(intent.ACTION_SEND);
                intent.putExtra("Nome", etNome.getText().toString());
                intent.putExtra("Sobrenome", etSobrenome.getText().toString());
                startActivity(intent);
            }
        });

    }
}
