package com.example.paddy.project;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.paddy.project.adapters.ExerciseSetRecyclerAdapter;
import com.example.paddy.project.models.ExerciseSet;
import com.example.paddy.project.persistence.ExerciseSetRepository;

import java.util.ArrayList;
import java.util.List;

public class ExerciseLogListActivity extends AppCompatActivity {

    // UI Components
    private RecyclerView mRecyclerView;

    // vars
    private ArrayList<ExerciseSet> mSets = new ArrayList<>();
    private ExerciseSetRecyclerAdapter mExerciseSetRecyclerAdapter;
    private ExerciseSetRepository mExerciseSetRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_log_list);
        mRecyclerView = findViewById(R.id.rvExerciseLog);
        mExerciseSetRepository = new ExerciseSetRepository(this);

        initRecyclerView();
        retrieveExerciseSets();
     //   letsTrySomething();
    }

    private void retrieveExerciseSets(){
        mExerciseSetRepository.retrieveSetTask().observe(this, new Observer<List<ExerciseSet>>() {
            @Override
            public void onChanged(@Nullable List<ExerciseSet> exerciseSets) {
                if(mSets.size() > 0){
                    mSets.clear();
                }
                if(exerciseSets != null){
                    mSets.addAll(exerciseSets);
                }
                mExerciseSetRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }

    private void letsTrySomething(){
        ExerciseSet exercise = new ExerciseSet();
        exercise.setName("Barbell Row");
        exercise.setNumber(1);
        exercise.setWeight(20);
        exercise.setReps(8);
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
