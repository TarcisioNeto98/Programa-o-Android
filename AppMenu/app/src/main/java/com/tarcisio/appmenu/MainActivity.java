package com.tarcisio.appmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = new MenuInflater(MainActivity.this);
        menuInflater.inflate(R.menu.menu, menu);//Aqui eu passo o recurso xml dentro da pasta menu, chamado menu.xml, esse método converte
        //meu menu.xml para o objeto MenuInflater.
        return true;//Métodos obrigatoriamente boleanos.
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){//Método utilizado para captar quando um item de menu é clicado, o parametro é
        //o item que foi clicado, aqui eu posso pegar os ids dos meus itens e comparar com o id do item clicado.

        item.getItemId();//Método que retorna o id do item.

        if(item.getItemId() == R.id.itemBusca){
            Toast.makeText(MainActivity.this, "Menu 1", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, PadraoAppsGoogle.class);
            intent.setAction(Intent.ACTION_VIEW);
            startActivity(intent);
        }

        else if(item.getItemId() == R.id.itemAjuda){
            Toast.makeText(MainActivity.this, "Menu 2", Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(MainActivity.this, "Menu 3", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

}
