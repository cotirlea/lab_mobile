package com.example.lab_ma;


import java.io.Serializable;
import java.util.Collections;
import java.util.Vector;

public class RepoMovie implements Serializable {
    Vector<Movie> list;


    public RepoMovie(){
        this.list = new Vector<Movie>();
    }

    public int getSize(){return this.list.size();}

    void add(Movie m){this.list.add(m);}
    Movie find(String nume){
        for(Movie m : this.list){
            if(m.getNume().equals(nume))
                return m;
        }
        return null;
    }

    Vector<Movie> createBatch(User u){
        Vector<Movie> batch = new Vector<Movie>();
        for(Movie m  : this.list){
            if(m.rigthGenre(u.getGenuri()) && u.getWatched().find(m.getNume()) == null && u.getScor_minim() <= m.getNota()  && u.getAn_minim() <= m.getAn() && u.getAn_maxim() >= m.getAn())
                batch.add(m);
        }
        Collections.shuffle(batch);
        return batch;
    }
    Movie get(int index){
        if(index<0 || index > this.list.size())
            return null;
        return this.list.get(index);
    }

    Vector<Movie> getFilme(){return this.list;}

    void remove(String m){
        Movie k = this.find(m);
        this.list.removeElement(k);
    }


}
