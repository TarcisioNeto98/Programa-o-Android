package com.tarcisio.appradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView salario, botao, texto;
    RadioGroup colecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salario = findViewById(R.id.etSalario);
        botao = findViewById(R.id.buttonSalario);
        colecao = findViewById(R.id.rgPorcentagem);
        texto = findViewById(R.id.textView2);


        /*List <Character>s = new ArrayList<Character>();//Lista de caracteres, onde é utilizado somente '', ao invés de "".

        s.add('a');*/

        ArrayList <RadioButton> botoes = new ArrayList<RadioButton>();

        botoes.add((RadioButton) findViewById(R.id.radioButton1));//Quando resgatado algum elemento do xml, é nescessário fazer o cast(Somente para o xml).
        botoes.add((RadioButton) findViewById(R.id.radioButton2));
        botoes.add((RadioButton) findViewById(R.id.radioButton3));
        //botoes.get(0).toggle();//Mudo o estado do radio, se estiver ligado passa para desligado, se desligado passa para ligado.
        /*colecao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//Evento que capta quando um radio é clidado(Tem que ser feito no RadioGroup).
            int s = colecao.getCheckedRadioButtonId();//Metodo que retorna o id do radioButton selecionado, mas é o id da classe R, o mesmo que é usado
             //no findViewById(), se nenhum do radiobuttons estiver selecionado o método retorna -1.
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {//o radioGroup é uma variável que possui o RadioGroup dos radiosButton
                //o i representa o id (id da classe R, o mesmo usado no método findViewById()) do radio selecionado.
                //Toast.makeText(MainActivity.this, R.string.nome,Toast.LENGTH_SHORT).show();//Nesse exemplo passo um id de uma string da strings.xml no segundo argumento.
                Toast.makeText(getApplicationContext(), colecao.getCheckedRadioButtonId() + " ", Toast.LENGTH_SHORT).show();
                System.out.println(colecao.getCheckedRadioButtonId());
            }
        });*/
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//Essa view representa o botão, ou seja posso usa-la como minha variável botao.
                //colecao.removeViews(0, 1);//Retira os radios buttons em um intervalo(Exemplo de 0 até 1 ou 2 até 3(a númeração é igual a de vetores), sendo 0 o inicio).
                if(salario.getText().toString().equals("")) Toast.makeText(getApplicationContext(), "Digite um salário", Toast.LENGTH_SHORT).show();
                else if(colecao.getCheckedRadioButtonId() == -1) Toast.makeText(getApplicationContext(), "Selecione uma opção de porcentagem", Toast.LENGTH_SHORT);
                //Toast.makeText(getApplicationContext(), colecao.getCheckedRadioButtonId()+"", Toast.LENGTH_SHORT).show();
                else{
                    Intent i = new Intent();
                    i.setClass(getApplicationContext(), MostrarSalarioActivity.class);//Método que substitui um construtor onde passo a activity atual
                    //e a activity que desejo ir, nele passo a activity atual e a activity para onde desejo ir.
                    i.setAction(Intent.ACTION_SEND);
                    i.putExtra("botaoSelecionado", colecao.getCheckedRadioButtonId()+"");
                    i.putExtra("salario", salario.getText().toString());//somente o getText não funciona pois retorna uma charsequence, logo tem que ser
                    //Convertida para uma string, pois o metodo putExtra só recebe string.
                    startActivity(i);//Método que inicia uma intent.
                }
            }
        });

    }
}
