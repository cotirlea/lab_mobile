package com.example.lab_ma;

import android.widget.EditText;

import java.util.Vector;

public class Validator {

    private Vector<String> erori;

    public Validator(){
        this.erori = new Vector<String>();
    }

    void add(String error){this.erori.add(error);}

    Vector<String> getErori(){return erori;}

    boolean nullText(EditText t){
        if(t.getText().toString().length() == 0)
            return false;
        return true;
    }

    boolean nullGen(Vector<String> genuri){
        if(genuri.size() == 0)
            return false;
        return true;
    }

    boolean shortSentence(EditText t){
        if(t.getText().length() < 4)
            return false;
        return true;
    }

    boolean samePassword(EditText password,EditText confirm_password){
        if(!password.getText().toString().equals(confirm_password.getText().toString()))
            return false;
        return true;
    }

    boolean correctNumber(EditText t,int min,int max){
        int p = Integer.parseInt(t.getText().toString());
        if(p<min || p >max)
            return false;
        return true;
    }

    boolean correctInterval(EditText min,EditText max){
        int mn = Integer.parseInt(min.getText().toString());
        int mx = Integer.parseInt(max.getText().toString());
        if(mn >= mx)
            return false;
        return true;
    }

    Vector<String> validate(EditText username,EditText password,EditText confirm_password,EditText scor,EditText an_min,EditText an_max,Vector<String> genuri){
        if(!nullText(username))
            this.erori.add("username empty");
        else{
            if(!shortSentence(username))
                this.erori.add("username to short");
        }

        if(!nullText(password))
            this.erori.add("password empty");
        else{
            if(!shortSentence(password))
                this.erori.add("password to short");
        }
        if(!nullText(confirm_password))
            this.erori.add("confirm password empty");
        if(!nullText(scor))
            this.erori.add("score empty");
        else{
            if(!correctNumber(scor,0,100))
                this.erori.add("invalid score");
        }
        if(!nullText(an_min))
            this.erori.add("minim year empty");
        else{
            if(!correctNumber(an_min,1888,2021))
                this.erori.add("invalid minim year");
        }
        if(!nullText(an_max))
            this.erori.add("maxim year empty");
        else{
            if(!correctNumber(an_max,1888,2021))
                this.erori.add("invalid maxims year");
        }
        if(!nullGen(genuri))
            this.erori.add("no genre selected");


        if(nullText(password) && nullText(confirm_password)){
            if(!samePassword(password,confirm_password))
                erori.add("password does not match confirm password");
        }

        if(nullText(an_min) && nullText(an_max)){
            if(!correctInterval(an_min,an_max))
                erori.add("invalid interval");
        }


        return this.erori;
    }
}
