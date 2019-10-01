package br.com.empresa.bdapp.Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Usuario")//Com isso crio uma entidade no meu banco de dados, através da biblioteca room.
public class User {
    @PrimaryKey(autoGenerate = true)//Crio uma chave primaria, em seguida, instruo ela se auto imcrementada(Ou seja ela se incrementará sozinha).
    private int id;
    @ColumnInfo(name = "first_name")//Crio um item na tabela, porém, mudo o nome com o comando name de firstName para first_name
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;

}
