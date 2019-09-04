package com.tarcisio.appspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Resources resources;//Classe utilizada para gerenciar os recursos, como strings, cores, layouts.
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] s;
        spinner = findViewById(R.id.spinner);
        resources = getResources();
        s = resources.getStringArray(R.array.nomes);//O metodo retorna um array de string que está na strings.xml
        ArrayAdapter adaptador = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_single_choice, android.R.id.text1, s);
                                                    /*Layouts possiveis do spinner com explicações*/
        //1) android.R.layout.simple_list_item_multiple_choice exibe um spinner com opcoes checkbox em cada item.
        //2) android.R.layout.list_content não funciona no spinner.
        //3) android.R.layout.select_dialog_item exibe um spinner com fonte grande.
        //4) android.R.layout.preference_category não funciona.
        //5) android.R.layout.test_list_item exibe um spinner com fonte pequena e cinza.
        //6) android.R.layout.two_line_list_item semenhante ao anterior, exibe um spinner com espacamento maior entre eles e com fonte maior e cinza escura.
        //7) android.R.layout.activity_list_item semenhante ao 5), mas possui um espacamento a esquerda do item.
        //8) android.R.layout.browser_link_context_header não funciona.
        //9) android.R.layout.simple_spinner_dropdown_item espacamento nos padding dos itens, fonte grande.
        //10)android.R.layout.simple_selectable_list_item semenhante ao 9), mas com fonte maior.
        //11)android.R.layout.simple_spinner_item o mais simples, sem espacamento e fonte pequena.
        //12)android.R.layout.expandable_list_content não funciona, não no listview.
        //13)android.R.layout.select_dialog_multichoice semenhante ao 1), porém com fonte maior.
        //14)android.R.layout.select_dialog_singlechoice cada item é customizado como um radiobutton(Bolinha no item).
        //15)android.R.layout.simple_dropdown_item_1line fonte pequena mas com espacamentos padding top e bottom nos itens.
        //16)android.R.layout.simple_expandable_list_item_1 semenhante ao 15), porém com espacamento padding rigth e left(Mais centralizado).
        //17)android.R.layout.simple_expandable_list_item_2 tem espacamento padding rigth, bottom, mas sem top.
        //18)android.R.layout.simple_gallery_item semenhante ao 11), mas com fonte um pouco maior.
        //19)android.R.layout.simple_list_item_1 spinner com fonte pequena e espacamento padding top, left(não muito) e bottom.
        //20)android.R.layout.simple_list_item_2 spinner com fonte pequena, espacamento padding top(pequeno), left(pequeno) e bottom(grande).
        //21)android.R.layout.simple_list_item_activated_1 semenhante ao 20), porém quando selecionado o item ganha uma cor vermelha.
        //22)android.R.layout.simple_list_item_activated_2 semenhante ao 21), espacamento um pouco maior.
        //23)android.R.layout.simple_list_item_checked semenhante ao 1), porém no lugar do checkbox, há um sinal de ok(checado).
        //24)android.R.layout.simple_list_item_single_choice semenhante ao 14), talvez tenham espacamentos diferentes.


        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast mensagem;
                mensagem = Toast.makeText(getApplicationContext(), s[position], Toast.LENGTH_SHORT);
                mensagem.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast mensagem;
                mensagem = Toast.makeText(getApplicationContext(), "Clique em algo", Toast.LENGTH_SHORT);
                mensagem.show();
            }
        });

    }
}
