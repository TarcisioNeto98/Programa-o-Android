package br.com.empresa.bdapp.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.empresa.bdapp.Model.User;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM usuario")
    List<User> selecionarTodos();

    @Query("SELECT * FROM Usuario WHERE Usuario.first_name LIKE :firstName AND Usuario.last_name LIKE :lastName")
    public User usuarioPorNome(String firstName, String lastName);//A busca é feita internamente, somente com os nomes e os comandos SQL, a biblioteca ROOM
                                                                  //já retorna um objeto já armaezando anteriormante, que atenda a busca com o SQL.
    @Query("SELECT * FROM Usuario WHERE Usuario.id = :idUser")
    public User usuarioPorId(int idUser);

    @Insert
    public void addAllUser(User user, User user2, User user3);

    @Insert
    public void addUser(User user);

    @Update
    public void updateUser(User user);

    @Delete
    public void deleteUser(User user);

}
