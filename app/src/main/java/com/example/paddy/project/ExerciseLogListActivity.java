package com.example.paddy.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.paddy.project.adapters.ExerciseSetRecyclerAdapter;
import com.example.paddy.project.models.ExerciseSet;

import java.util.ArrayList;

public class ExerciseLogListActivity extends AppCompatActivity {

    // UI Components
    private RecyclerView mRecyclerView;

    // vars
    private ArrayList<ExerciseSet> mSets = new ArrayList<>();
    private ExerciseSetRecyclerAdapter mExerciseSetRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_log_list);
        mRecyclerView = findViewById(R.id.rvExerciseLog);

        initRecyclerView();
     //   letsTrySomething();
    }

    private void letsTrySomething(){
        ExerciseSet exercise = new ExerciseSet();
        exercise.setSetExerciseName("Barbell Row");
        exercise.setSetNumber(1);
        exercise.setSetWeight(20);
        exercise.setSetReps(8);
        mSets.add(exercise);
//        Exercise exercise1 = new Exercise();
//        exercise1.setName("Bench Press");
//        exercise1.setCategory("Chest");
//        Exercise exercise2 = new Exercise();
//        exercise2.setName("Squat");
//        exercise2.setCategory("Legs");
//        mExercise.add(exercise);
//        mExercise.add(exercise1);
//        mExercise.add(exercise2);

        mExerciseSetRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mExerciseSetRecyclerAdapter = new ExerciseSetRecyclerAdapter(mSets);
        mRecyclerView.setAdapter(mExerciseSetRecyclerAdapter);
    }
}
