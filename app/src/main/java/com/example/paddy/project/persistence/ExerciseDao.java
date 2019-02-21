package com.example.paddy.project.persistence;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.paddy.project.models.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Insert
    long[] insertExercises(Exercise... exercises);

    @Query("SELECT * FROM exercises")
    LiveData<List<Exercise>> getExercises();

    @Query("SELECT * FROM exercises WHERE name LIKE :name")
    List<Exercise> getExerciseNameWithCustomQuery(String name);

    @Query("SELECT * FROM exercises WHERE name LIKE :category")
    List<Exercise> getExerciseCategoryWithCustomQuery(String category);


    @Delete
    int delete(Exercise... exercises);

    @Update
    int update(Exercise... exercises);

}
