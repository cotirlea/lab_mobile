package com.example.lab_ma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Vector;

public class Update extends AppCompatActivity {

    EditText username,password,confirm_password,scor,an_minim,an_maxim;
    CheckBox action,comedy,drama,horror;
    User user;


    boolean isChecked(String k){
        for(String x : user.getGenuri()){
            if(x.equals(k))
                return true;
        }
        return false;
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

    void initializare(){
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("User");

        username = (EditText) findViewById(R.id.username_update); username.setText(user.getUsername());
        password = (EditText) findViewById(R.id.password_update); password.setText(user.getPassword());
        confirm_password = (EditText) findViewById(R.id.confirm_update);confirm_password.setText(user.getPassword());
        scor = (EditText) findViewById(R.id.scor_minim_update);scor.setText(String.valueOf(user.getScor_minim()));
        an_minim = (EditText) findViewById(R.id.an_minim_update);an_minim.setText(String.valueOf(user.getAn_minim()));
        an_maxim = (EditText) findViewById(R.id.an_maxim_update);an_maxim.setText(String.valueOf(user.getAn_maxim()));
        action = (CheckBox) findViewById(R.id.action_update); if(isChecked("action")) {action.setChecked(true);}
        comedy = (CheckBox) findViewById(R.id.comedy_update); if(isChecked("comedy")) {comedy.setChecked(true);}
        drama = (CheckBox) findViewById(R.id.drama_update); if(isChecked("drama")) {drama.setChecked(true);}
        horror = (CheckBox) findViewById(R.id.horror_update); if(isChecked("horror")) {horror.setChecked(true);}

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initializare();
    }

    public void confirm_update(View view) {
        Vector<String> genuri = getGenuri();
        Validator valid = new Validator();
        Vector<String> erori = valid.validate(username,password,confirm_password,scor,an_minim,an_maxim,genuri);
        if(erori.size() == 0){
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            user.setGenuri(genuri);
            user.setScor_minim(Integer.parseInt(scor.getText().toString()));
            user.setAn_minim(Integer.parseInt(an_minim.getText().toString()));
            user.setAn_maxim(Integer.parseInt(an_maxim.getText().toString()));
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("User", user);
            startActivity(i);
        }
        else{
            for(String k : erori){
                Toast.makeText(Update.this,k,Toast.LENGTH_SHORT).show();
            }
        }
    }
}