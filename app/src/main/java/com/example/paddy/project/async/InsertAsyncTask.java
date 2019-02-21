package com.example.paddy.project.async;

import android.os.AsyncTask;

import com.example.paddy.project.models.Exercise;
import com.example.paddy.project.persistence.ExerciseDao;

public class InsertAsyncTask extends AsyncTask<Exercise, Void, Void> {

    private ExerciseDao mExerciseDao;

    public InsertAsyncTask(ExerciseDao dao) {
        mExerciseDao = dao;
    }

    @Override
    protected Void doInBackground(Exercise... exercises) {
        mExerciseDao.insertExercises(exercises);
        return null;
    }
}
