package com.example.lab_ma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class SignIn extends AppCompatActivity {

    EditText username,password,confirm_password,scor,an_minim,an_maxim;
    CheckBox action,comedy,drama,horror;

    public void initializare(){
        username = (EditText) findViewById(R.id.username_sign);
        password = (EditText) findViewById(R.id.password_sign);
        confirm_password = (EditText) findViewById(R.id.confirm_sign);
        scor = (EditText) findViewById(R.id.scor_minim);
        an_minim = (EditText) findViewById(R.id.an_minim);
        an_maxim = (EditText) findViewById(R.id.an_maxim);
        action = (CheckBox) findViewById(R.id.action);
        comedy = (CheckBox) findViewById(R.id.comedy);
        drama = (CheckBox) findViewById(R.id.drama);
        horror = (CheckBox) findViewById(R.id.horror);
    }

    Vector<String> getGenuri(){
        Vector<String> genuri = new Vector<String>();
        if(action.isChecked())
            genuri.add("action");
        if(comedy.isChecked())
            genuri.add("comedy");
        if(drama.isChecked())
            genuri.add("drama");
        if(horror.isChecked())
            genuri.add("horror");
        return genuri;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initializare();
    }

    public void confirm_sign(View view) {
        Vector<String> genuri = getGenuri();
        Validator valid = new Validator();
        Vector<String> erori = valid.validate(username,password,confirm_password,scor,an_minim,an_maxim,genuri);
        if(erori.size() == 0){
            User u = new User(username.getText().toString(),password.getText().toString(),genuri,Integer.parseInt(scor.getText().toString()),Integer.parseInt(an_minim.getText().toString()),Integer.parseInt(an_maxim.getText().toString()));
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("User", u);
            startActivity(i);
        }
        else{
            for(String k : erori){
                Toast.makeText(SignIn.this,k,Toast.LENGTH_SHORT).show();
            }
        }
    }
}