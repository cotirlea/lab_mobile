package com.example.lab_ma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    RepoMovie repo_movies;
    User user;
    Vector<Movie> batch;

    TextView nume,an,gen,scor;

    void initializare(){
        repo_movies = new RepoMovie();
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("User");

        Movie m1 = new Movie("john wick","action",68,2014,"url");repo_movies.add(m1);
        Movie m2 = new Movie("the raid 2","action",71,2014,"url");repo_movies.add(m2);
        Movie m3 = new Movie("mad mex: fury road","action",90,2015,"url");repo_movies.add(m3);
        Movie m4 = new Movie("kill bill:vol 1","action",69,2002,"url");repo_movies.add(m4);
        Movie m5 = new Movie("hardcore henry","action",51,2016,"url");repo_movies.add(m5);

        Movie m6 = new Movie("pulp fiction","drama",94,1994,"url");repo_movies.add(m6);
        Movie m7 = new Movie("shame","drama",72,2011,"url");repo_movies.add(m7);
        Movie m8 = new Movie("under the skin","drama",80,2014,"url");repo_movies.add(m8);
        Movie m9 = new Movie("mommy","drama",71,2015,"url");repo_movies.add(m9);
        Movie m10 = new Movie("birdman","drama",87,2014,"url");repo_movies.add(m10);

        Movie m11 = new Movie("suspiria","horror",64,2018,"url");repo_movies.add(m11);
        Movie m12 = new Movie("the witch","horror",81,2016,"url");repo_movies.add(m12);
        Movie m13 = new Movie("the lighthouse","horror",83,2019,"url");repo_movies.add(m13);
        Movie m14 = new Movie("midsummer","horror",67,2018,"url");repo_movies.add(m14);
        Movie m15 = new Movie("hereditary","horror",87,2018,"url");repo_movies.add(m15);

        Movie m16 = new Movie("the lobster","comedy",82,2016,"url");repo_movies.add(m16);
        Movie m17 = new Movie("the favorite","comedy",91,2018,"url");repo_movies.add(m17);
        Movie m18 = new Movie("snatch","comedy",55,2001,"url");repo_movies.add(m18);
        Movie m19 = new Movie("Monty Python and the Holy Grail","comedy",91,1975,"url");repo_movies.add(m19);
        Movie m20 = new Movie("Borat","comedy",89,2006,"url");repo_movies.add(m20);
        batch = repo_movies.createBatch(user);

        nume = (TextView) findViewById(R.id.nume);
        an  = (TextView) findViewById(R.id.an);
        gen = (TextView) findViewById(R.id.gen);
        scor = (TextView) findViewById(R.id.scor);

        if(batch.size() > 0) {
            nume.setText(batch.get(0).getNume());
            an.setText(String.valueOf(batch.get(0).getAn()));
            gen.setText(batch.get(0).getGen());
            scor.setText(String.valueOf(batch.get(0).getNota()));
        }
        else{
            nume.setText("Empty");
            an.setText("Empty");
            gen.setText("Empty");
            scor.setText("Empty");
        }
    }



    void refresh(){
        if(batch.size() > 0){
            batch.removeElementAt(0);
            if(batch.size() > 0) {
                nume.setText(batch.get(0).getNume());
                an.setText(String.valueOf(batch.get(0).getAn()));
                gen.setText(batch.get(0).getGen());
                scor.setText(String.valueOf(batch.get(0).getNota()));
            }
            else{
                nume.setText("Empty");
                an.setText("Empty");
                gen.setText("Empty");
                scor.setText("Empty");
                Toast.makeText(this,String.valueOf(user.getWatchlist().getSize()),Toast.LENGTH_SHORT).show();
            }
        }
        else{
            nume.setText("Empty");
            an.setText("Empty");
            gen.setText("Empty");
            scor.setText("Empty");
            Toast.makeText(this,String.valueOf(user.getWatchlist().getSize()),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializare();
    }

    public void settings(View view) {
        Intent i = new Intent(this, Update.class);
        i.putExtra("User", user);
        startActivity(i);
    }

    public void watchlist(View view) {
        Intent i = new Intent(this, WatchList.class);
        i.putExtra("User", user);
        startActivity(i);
    }

    public void add(View view) {
        if(batch.size() > 0) {
            user.getWatched().add(batch.get(0));
            user.getWatchlist().add(batch.get(0));
        }
        refresh();
    }

    public void remove(View view) {
        if(batch.size() > 0) {
            user.getWatched().add(batch.get(0));
        }
        refresh();
    }
}