package com.example.lab_ma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class WatchList extends  AppCompatActivity {

    ArrayList<String> data;
    ArrayAdapter<String> adapter;
    User user;
    ListView list;

    void initializare() {
        data = new ArrayList<String>();
        list = (ListView) findViewById(R.id.list);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("User");
        if (user.getWatchlist().getFilme().size() > 0) {
            for (Movie movie : user.getWatchlist().getFilme()) {
                data.add(movie.getNume());
            }
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_list);
        initializare();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(WatchList.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + data.get(position));
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        user.getWatchlist().remove(data.get(positionToRemove));
                        data.remove(positionToRemove);
                        adapter.notifyDataSetChanged();

                    }
                });
                adb.show();
            }
        });
    }


    public void close(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("User", user);
        startActivity(i);
    }
}