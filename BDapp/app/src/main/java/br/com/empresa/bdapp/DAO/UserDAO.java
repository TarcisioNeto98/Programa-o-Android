package br.com.empresa.bdapp.DAO;


import androidx.room.Dao;
import androidx.room.Query;

import br.com.empresa.bdapp.Model.User;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM usuario")
    <List>User selecionar_todos();


}
