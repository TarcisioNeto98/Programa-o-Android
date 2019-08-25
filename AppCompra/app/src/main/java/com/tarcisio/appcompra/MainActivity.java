package com.tarcisio.appcompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botaoMostrar;
    CheckBox opcao1, opcao2, opcao3;
    EditText texto1, texto2, texto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opcao1 = findViewById(R.id.cbPizza);
        opcao1.setText("40 R$");
        opcao2 = findViewById(R.id.cbBolo);
        opcao2.setText("30 R$");
        opcao3 = findViewById(R.id.cbSuco);
        opcao3.setText("10 R$");
        texto1 = findViewById(R.id.etPizza);
        texto2 = findViewById(R.id.etBolo);
        texto3 = findViewById(R.id.etSuco);

        botaoMostrar = (Button) findViewById(R.id.bMostrar);
        botaoMostrar.setText("Somar");
        //botaoMostrar.setAllCaps(false);//O button por padrão tem seu texto todo em miusculo, essa função se passado false exibe o texto original.
        botaoMostrar.setPadding(50, 50, 50, 50);

        botaoMostrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast toast;
                double total = 0;
                int cont = 0, contErro = 0;
                if(opcao1.isChecked()){
                    if(isNumeric(texto1.getText().toString())) total = converteDouble(opcao1.getText().toString().replace(" R$", "")) * converteDouble(texto1.getText().toString());
                    else if(!texto1.getText().toString().equals("")){
                        toast = Toast.makeText(MainActivity.this, "Erro:\nEscreva um valor numerico", Toast.LENGTH_SHORT);
                        toast.show();
                        contErro++;
                    }
                    else total = converteDouble(opcao1.getText().toString().replace(" R$", ""));
                    cont++;
                }
                if(opcao2.isChecked()){
                    if(contErro == 0){
                        if(isNumeric(texto2.getText().toString())) total += converteDouble(opcao2.getText().toString().replace(" R$", "")) * converteDouble(texto2.getText().toString());
                        else if(!texto2.getText().toString().equals("")){
                            toast = Toast.makeText(MainActivity.this, "Erro:\n1Escreva um valor numerico", Toast.LENGTH_SHORT);
                            toast.show();
                            contErro++;
                        }
                        else if(texto2.getText().toString().equals("")) total += converteDouble(opcao2.getText().toString().replace(" R$", ""));
                    }
                    cont++;
                }
                if(opcao3.isChecked()){
                    if(contErro == 0){
                        if(isNumeric(texto3.getText().toString())) total += converteDouble(opcao3.getText().toString().replace(" R$", "")) * converteDouble(texto3.getText().toString());
                        else if(!texto3.getText().toString().equals("") && contErro == 0){
                            toast = Toast.makeText(MainActivity.this, "Erro:\nEscreva um valor numerico", Toast.LENGTH_SHORT);
                            toast.show();
                            contErro++;
                        }
                        else if(texto2.getText().toString().equals("")) total += converteDouble(opcao3.getText().toString().replace(" R$", ""));
                    }
                    cont++;
                }
                if(cont == 0){
                    toast = Toast.makeText(MainActivity.this, "Marque algo", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if(cont != 0 && contErro == 0) Toast.makeText(getApplicationContext(), "Total: " + total, Toast.LENGTH_SHORT).show();
            }
        });
        /*Button b = new Button(getApplicationContext());
        b.setText("Eai");
        b.setAllCaps(true);
        b.setPadding(12, 23, 23, 14);*/
    }

    public static double converteDouble(String s){
        return Double.parseDouble(s);
    }

    public static boolean isNumeric(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}