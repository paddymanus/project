package com.example.paddy.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    List<String> data;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<String> addExerciseNames = new ArrayList<>();
        addExerciseNames.add("Back");
        addExerciseNames.add("Biceps");
        addExerciseNames.add("Chest");
        addExerciseNames.add("Legs");
        addExerciseNames.add("Shoulders");
        addExerciseNames.add("Triceps");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAddExercise);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, addExerciseNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void onButtonClick(View view) {
        insertBackItems();
    }

    private void insertBackItems(){
        data.clear();

        ArrayList<String> backItems = new ArrayList<>();
        backItems.add("Barbell Row");
        backItems.add("Dumbell Row");
        backItems.add("Conventional Deadlift");
        backItems.add("Sumo Deadlift");
        backItems.add("Lat Pulldown");
        backItems.add("Cable Row");

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
