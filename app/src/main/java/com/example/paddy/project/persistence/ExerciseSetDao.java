package com.example.paddy.project.persistence;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.Update;

import com.example.paddy.project.models.ExerciseSet;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ExerciseSetDao {

    @Insert
    long[] insertExerciseSets(ExerciseSet... exerciseSets);

    @Query("SELECT * FROM exerciseSets")
    LiveData<List<ExerciseSet>> getExerciseSets();

    @Delete
    int delete(ExerciseSet... exerciseSets);

    @Update
    int update(ExerciseSet... exerciseSets);


}
