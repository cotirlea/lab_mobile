package com.example.lab_ma;

import java.util.Vector;

public class RepoUser {
    Vector<User> list;

    public RepoUser(){
        this.list = new Vector<User>();
    }

    void add(User u){this.list.add(u);}
    User find(String username,String password){
        for(User u : this.list){
            if(u.getUsername().equals(username) && u.getPassword().equals(password))
                return u;
        }
        return null;
    }
    User get(int index){
        if(index<0 || index > this.list.size())
            return null;
        return this.list.get(index);
    }

    Vector<User> getUsers(){return this.list;}

    void remove(User u){
        this.list.remove(u);
    }
}
