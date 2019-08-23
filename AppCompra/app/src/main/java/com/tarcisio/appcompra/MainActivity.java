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
    String texto;

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
                if(!isNumeric(texto1.getText().toString()) || !isNumeric(texto2.getText().toString()) || !isNumeric(texto3.getText().toString())){
                    toast = Toast.makeText(MainActivity.this, "Erro"+ "\n"+ "digite um valor numerico.", Toast.LENGTH_SHORT);
                    //toast.setText("Erro"); Muda o conteudo Toast, mas somente se o makeText tiver sido invocado.
                    toast.show();
                }
                else{
                    double total = 0;
                    if(opcao1.isChecked()){
                        texto = opcao1.getText().toString();
                        total = converteDouble(texto.replace(" R$", "")) * converteDouble(texto1.getText().toString());
                    }
                    if(opcao2.isChecked()){
                        total += converteDouble(opcao2.getText().toString().replace(" R$", "")) * converteDouble(texto2.getText().toString());
                    }
                    if(opcao3.isChecked()) total += converteDouble(opcao3.getText().toString().replace(" R$", "")) * converteDouble(texto3.getText().toString());
                    toast = Toast.makeText(getApplicationContext(), "Total: " + total, Toast.LENGTH_LONG);
                    toast.show();
                }
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