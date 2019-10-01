package br.com.empresa.bdapp.banco_de_dados;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.empresa.bdapp.DAO.UserDAO;
import br.com.empresa.bdapp.Model.User;

@Database(entities = {User.class/*Posso adicionar mais classe, basta colocar uma virgula e o nome das classe. EX: User.class, Carro.class*/}, version = 1)//Aqui adiciono a lista de classes que serão as tabelas
//de meu banco de dados.
public abstract class AppDatabase extends RoomDatabase/*Classe que permite a alocação de tabelas no meu banco de dados(Possui alguns métodos importantes)*/ {
    //Essa é a classe que será o banco de dados, cada tabela nela criada, será uma classe, essa tabela é representada por um método.
    public abstract UserDAO userdao();//Método abstrato que representa a tabela Usuario no banco de dados, esse método retorna o UserDAO pois é nele que
    //é feito todos os comando de gerencia do banco de dados.
}
