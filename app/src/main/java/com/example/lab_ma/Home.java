package com.example.lab_ma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void login(View view) {
        Intent intent = new Intent(this,LogIn.class);
        startActivity(intent);

    }

    public void signin(View view) {
        Intent intent = new Intent(this,SignIn.class);
        startActivity(intent);
    }
}