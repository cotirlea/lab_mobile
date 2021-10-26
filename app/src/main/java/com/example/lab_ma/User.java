package com.example.lab_ma;

import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable {
    private String username;
    private String password;
    private RepoMovie watchlist;
    private Vector<String> genuri;
    private int scor_minim;
    private int an_minim;
    private int an_maxim;
    private RepoMovie watched;

    public User(String _username,String _password, Vector<String> _genuri, int _scor_minim,int _an_minim,int _an_maxim){
        this.username = _username;
        this.password = _password;
        this.watchlist = new RepoMovie();
        this.genuri = _genuri;
        this.scor_minim = _scor_minim;
        this.an_minim = _an_minim;
        this.an_maxim = _an_maxim;
        this.watched = new RepoMovie();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public RepoMovie getWatchlist() { return watchlist; }
    public Vector<String> getGenuri() { return genuri; }
    public int getScor_minim() { return scor_minim; }
    public int getAn_minim() { return an_minim; }
    public int getAn_maxim() { return an_maxim; }
    public RepoMovie getWatched() { return watched; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setWatchlist(RepoMovie watchlist) { this.watchlist = watchlist; }
    public void setGenuri(Vector<String> genuri) { this.genuri = genuri; }
    public void setScor_minim(int scor_minim) { this.scor_minim = scor_minim; }
    public void setAn_minim(int an_minim) { this.an_minim = an_minim; }
    public void setAn_maxim(int an_maxim) { this.an_maxim = an_maxim; }
    public void setWatched(RepoMovie watched) { this.watched = watched; }



}
