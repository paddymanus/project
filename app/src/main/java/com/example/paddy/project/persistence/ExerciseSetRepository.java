package com.example.paddy.project.persistence;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.paddy.project.async.InsertAsyncTask;
import com.example.paddy.project.async.InsertSetAsyncTask;
import com.example.paddy.project.models.ExerciseSet;

import java.util.List;

public class ExerciseSetRepository {

    private ExerciseSetDatabase mExerciseSetDatabase;

    public ExerciseSetRepository(Context context) {
        mExerciseSetDatabase = ExerciseSetDatabase.getInstance(context);
    }

    public void insertSetTask(ExerciseSet exerciseSet){
        new InsertSetAsyncTask(mExerciseSetDatabase.getExerciseSetDao()).execute(exerciseSet);
    }

    public void updateSet(ExerciseSet exerciseSet){

    }

    public LiveData<List<ExerciseSet>> retrieveSetTask(){

        return mExerciseSetDatabase.getExerciseSetDao().getExerciseSets();
    }

    public void deleteSet(ExerciseSet exerciseSet){

    }
}
