package com.example.paddy.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.paddy.project.adapters.ExerciseRecyclerAdapter;
import com.example.paddy.project.models.Exercise;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ExerciseRecyclerAdapter.OnExerciseListener {

    // UI components
    private RecyclerView mRecyclerView;

    // vars
    private ArrayList<Exercise> mExercise = new ArrayList<>();
    private ExerciseRecyclerAdapter mExerciseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rvAddExercise);


        initRecyclerView();
        letsTrySomething();
        //insertFakeExercise();
    }

    private void insertFakeExercise(){
        for(int i = 0; i < 1000; i++){
            Exercise exercise = new Exercise();
            exercise.setName("name #" + i);
            exercise.setCategory("category #" + i);
            mExercise.add(exercise);
        }
        mExerciseRecyclerAdapter.notifyDataSetChanged();
    }

    private void letsTrySomething(){
        Exercise exercise = new Exercise();
        exercise.setName("Barbell Row");
        exercise.setCategory("Back");
        Exercise exercise1 = new Exercise();
        exercise1.setName("Bench Press");
        exercise1.setCategory("Chest");
        Exercise exercise2 = new Exercise();
        exercise2.setName("Squat");
        exercise2.setCategory("Legs");
        mExercise.add(exercise);
        mExercise.add(exercise1);
        mExercise.add(exercise2);

        mExerciseRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mExerciseRecyclerAdapter = new ExerciseRecyclerAdapter(mExercise, this);
        mRecyclerView.setAdapter(mExerciseRecyclerAdapter);
    }


    @Override
    public void onExerciseClick(int position) {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("selected_exercise", mExercise.get(position));
        startActivity(intent);
    }
}
