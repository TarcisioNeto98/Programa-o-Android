package br.com.empresa.bdapp.banco_de_dados;

import android.content.Context;

import androidx.room.Room;

public class ClientDatabase {//Classe utilizada para criar um banco de dados, a classe AppDatabase é banco de dados em si;
    //Tudo no Java é feito através de objetos, até os bancos de dados.
    private static AppDatabase db;

    public static AppDatabase pegarInstancia(Context context){//Método que retorna uma instancia do banco de dados(Ou seja um objeto banco de dados que no qual é possivel gerencia-lo).
    //O context é o contexto da aplicação, ou seja a activity no qual eu estou requisitando a instancia do banco de dados.
        if(db == null) db = Room.databaseBuilder(context, AppDatabase.class, "primeiro_bd").allowMainThreadQueries().build();//Método da classe ROOM que retorna a instancia do meu banco de dados,
        //nele é passado o contexto da aplicação (Ou seja a classe da activity), a classe que é o banco de dados(No caso a AppBatabase), e o nome do banco que está sendo criado.
        //Os métodos allowMainThreadQueries() e build() são da classe AppDatabase que estende a RoomDatabase(Ou seja esses 2 métodos têm origem na RoomDatabase).
        return db;
    }

}
