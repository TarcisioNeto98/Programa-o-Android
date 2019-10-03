package br.com.empresa.bdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.empresa.bdapp.DAO.UserDAO;
import br.com.empresa.bdapp.Model.User;
import br.com.empresa.bdapp.banco_de_dados.ClientDatabase;

public class MainActivity extends AppCompatActivity{

    private UserDAO users;
    EditText firstName, lastName, id;
    Button buttonAdd, buttonDelete, buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.etFirstName);
        lastName = (EditText) findViewById(R.id.etLastName);
        id = (EditText) findViewById(R.id.etId);

        users = ClientDatabase.pegarInstancia(getApplicationContext()).userdao();//pegarInstancia() retorna um objeto AppDatabase o método abstrato
        //userdao, retorna o objeto UserDAO(Uma tabela) do banco de dados AppDatabase.

        users.addUser(new User("Tarcisio", "Neto"));
        users.addUser(new User("Genivaldo", "Nonato"));

        User user1 = users.usuarioPorNome("Tarcisio", "Neto");

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vazio(firstName.getText().toString(), lastName.getText().toString())){
                    Toast mensagem;
                    mensagem = Toast.makeText(getApplicationContext(), "Preencha os campos", Toast.LENGTH_SHORT);
                    mensagem.show();
                }
                else{
                    User user = new User(firstName.getText().toString(), lastName.getText().toString());
                    users.addUser(user);//Estou adicionando na minha tabela User um usuário.
                    user = users.usuarioPorNome(firstName.getText().toString(), lastName.getText().toString());
                    Toast.makeText(getApplicationContext(), user.getId()+"", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vazio(firstName.getText().toString(), lastName.getText().toString())){
                    Toast mensagem;
                    mensagem = Toast.makeText(getApplicationContext(), "Preencha os campos", Toast.LENGTH_SHORT);
                    mensagem.show();
                }

                /*else{
                    User user = users.usuarioPorNome(firstName.getText().toString(), lastName.getText().toString());
                    Toast.makeText(getApplicationContext(), user.getId()+"", Toast.LENGTH_SHORT).show();
                    users.deleteUser(user);//df neto
                }*/

                for(int i = 1; i < 11; i++){
                    User user = users.usuarioPorId(i);
                    Toast.makeText(MainActivity.this, user.getId() + " " + user.getFirstName() + " " + user.getLastName(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        /*firstName.setText(user1.getFirstName());
        lastName.setText(user1.getLastName() + " id: " + user1.getId());*/
    }

    public static boolean vazio(String first, String last){
        if(first.isEmpty() || last.isEmpty()) return true;
        return false;
    }

    /*@Override
    public void onClick(View view) {
        if((firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty()) || (view.getId() == R.id.buttonUpdate && id.getText().toString().isEmpty())){
            Toast mostrar = Toast.makeText(getApplicationContext(), "Campos vazios!", Toast.LENGTH_SHORT);
            mostrar.show();
        }
        else{
            User user;
            if(view.getId() == R.id.buttonAdd) {
                users.addUser(new User(firstName.getText().toString(), lastName.getText().toString()));
            }
            else if(view.getId() == R.id.buttonDelete){
                user = users.usuarioPorNome(firstName.getText().toString(), lastName.getText().toString());
                users.deleteUser(user);
            }
            else{
                user = users.usuarioPorId(Integer.parseInt(id.getText().toString()));
                users.updateUser(user);
            }
        }
    }*/
}
