package com.tarcisio.appradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MostrarSalarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_salario);

        Intent i = getIntent();//Retorna a intent enviada para essa activity.
        //Existem varios métodos que podem ser utilizados para captar os dados da minha intent, depende do tipo de dado que eu estou passando, tem um método
        //para um double, int ou Array de double ou ArrayList de String(Cada um tem o seu), é possivel saber qual método usar pois no canto inferior direito
        //nos diz o seu retorno. O comando para ver quais argumentos usar em uma chamada de função é o Ctrl-p.
        String salario = i.getExtras().getString("salario");//O método getExtras retorna o meu pacote extra utilizado no transporte de dados, o metodo getString
        //retorna minha string do meu pacote de dados extra, passando por parametro o nome do pacote.
        String porcentagem = i.getStringExtra("botaoSelecionado");//Uma outra opção(Ao invés do primeiro), o método getStringExtra retorna minha string do meu pacote
        //extra, passando o nome do pacote.

        Toast.makeText(this, salario + " " + porcentagem, Toast.LENGTH_SHORT).show();

    }
}
