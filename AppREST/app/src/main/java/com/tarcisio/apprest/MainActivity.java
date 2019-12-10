package com.tarcisio.apprest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.tarcisio.apprest.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final UserService service = RetrofitClientInstance.getRetrofitInstance().create(UserService.class);
        Call<List<User>> callGetAll = service.getUsers();
        callGetAll.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                for(User user : response.body()) {
                    Log.i("GET ALL", user.toString());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

        Call<User> callGetOne = service.getUser(1);
        callGetOne.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.i("GET", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        Call<User> callPostOne = service.postUser(new User(11, "Anderson", "andersonalmada"));
        callPostOne.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.i("POST", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        Call<User> callPut = service.putUser(new User(null, "anderson", "andersonalmada"), 1);
        callPut.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.i("PUT", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

        Call<User> callDelete = service.deleteUser(1);
        callDelete.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.i("DELETE", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}
