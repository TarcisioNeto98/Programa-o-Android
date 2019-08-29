package com.tarcisio.listaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter listaAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.familia, android.R.layout.simple_spinner_item);//ArrayAdapter<String>(getApplicationContext(), android.R.layout.activity_list_item, android.R.id.text1);
        lista = (ListView) findViewById(R.id.lvLista);
        lista.setAdapter(listaAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {//A interface esta aninhada na classe AdapterView, o listview extende a AdapterView
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {//O 3° argumento é a posição do item selecionado(0 à n).
                Toast t;
                ListAdapter adapterRecuperado = lista.getAdapter();//Esse metodo retorna um ListAdapter, o arrayadapter extend a ListAdapter
                //se colocarmos o ArrayList para receber o getAdapter() dará erro, pois, uma classe filha não pode receber uma instancia de uma classe pai.
                int id = (int)adapterRecuperado.getItemId(position);//Esse metodo retorna a posição do item(como long) no adapter mas tem que
                //ser passado o id(Position) do item no ListView.
                String nome = (String) adapterRecuperado.getItem(id);//Esse metodo recebe o id no ArrayAdapter e retorna o item(String) mas como Object, logo,
                //é preciso converte de Object para a String.
                t = Toast.makeText(getApplicationContext(),"Posição no ListView: " + position + "\nPosição no ArrayAdapter: " + id + "\n" + nome,Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}
