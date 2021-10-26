package com.example.lab_ma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class LogIn extends AppCompatActivity {

    EditText username,password;
    RepoUser repo;

    void initializare(){
        Vector<String> gen1 = new Vector<String>();gen1.add("comedy");gen1.add("drama");
        Vector<String> gen2 = new Vector<String>();gen2.add("action");gen2.add("horror");
        Vector<String> gen3 = new Vector<String>();gen3.add("comedy");gen3.add("drama");gen3.add("action");gen3.add("horror");
        repo = new RepoUser();
        username = (EditText) findViewById(R.id.username_log);
        password = (EditText) findViewById(R.id.password_log);
        User u1 = new User("user1","pass1",gen1,20,1900,2021);repo.add(u1);
        User u2 = new User("user2","pass2",gen2,20,1900,2021);repo.add(u2);
        User u3 = new User("user3","pass3",gen3,20,1900,2021);repo.add(u3);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        initializare();
    }

    public void confirm_log(View view) {
        Validator valid = new Validator();
        if(!valid.nullText(username))
            valid.add("username empty");
        if(!valid.nullText(password))
            valid.add("password empty");
        if( valid.nullText(username) && valid.nullText(password) ){
            if(repo.find(username.getText().toString(),password.getText().toString()) == null)
                valid.add("invalid input");
        }
        Vector<String> erori = valid.getErori();
        if(erori.size() != 0){
            for(String k : erori)
                Toast.makeText(this,k,Toast.LENGTH_SHORT).show();
        }
        else{
            User u = repo.find(username.getText().toString(),password.getText().toString());
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("User", u);
            startActivity(i);
        }
    }
}