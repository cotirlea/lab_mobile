package com.example.lab_ma;

import java.io.Serializable;
import java.util.Vector;

public class Movie implements Serializable {
    private String nume;
    private String gen;
    private int nota;
    private int an;
    private String url;

    public Movie(String _nume,String _gen,int _nota,int _an,String _url){
        this.nume = _nume;
        this.gen = _gen;
        this.nota = _nota;
        this.an = _an;
        this.url = _url;
    }

    public String getNume() { return nume; }
    public String getGen() { return gen; }
    public int getNota() { return nota; }
    public int getAn() {return an;}
    public String getUrl() { return url; }

    public void setNume(String nume) { this.nume = nume; }
    public void setGen(String gen) { this.gen = gen; }
    public void setNota(int nota) { this.nota = nota; }
    public void setAn(int an) { this.an = an; }
    public void setUrl(String url) { this.url = url; }

    public boolean rigthGenre(Vector<String> genuri){
        for(String k : genuri){
            if(k.equals(this.getGen()))
                return true;
        }
        return false;
    }
}
