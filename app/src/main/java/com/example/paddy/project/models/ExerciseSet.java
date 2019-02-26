package com.example.paddy.project.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "exerciseSets")
public class ExerciseSet {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "exerciseName")
    private String setExerciseName;

    @ColumnInfo(name = "setNo")
    private int setNumber;

    @ColumnInfo(name = "weight")
    private int setWeight;

    @ColumnInfo(name = "reps")
    private int setReps;

 //   private ArrayList<ExerciseSet> mExerciseSets = new ArrayList<>();


    public ExerciseSet(String setExerciseName, int setNumber, int setWeight, int setReps) {
        this.setExerciseName = setExerciseName;
        this.setNumber = setNumber;
        this.setWeight = setWeight;
        this.setReps = setReps;
    }

    @Ignore
    public ExerciseSet() {
    }

//    public void setExerciseSets(ArrayList<ExerciseSet> exerciseSets) {
//        mExerciseSets = exerciseSets;
//    }

    public String getSetExerciseName() {
        return setExerciseName;
    }

    public void setSetExerciseName(String setExerciseName) {
        this.setExerciseName = setExerciseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public int getSetWeight() {
        return setWeight;
    }

    public void setSetWeight(int setWeight) {
        this.setWeight = setWeight;
    }

    public int getSetReps() {
        return setReps;
    }

    public void setSetReps(int setReps) {
        this.setReps = setReps;
    }


    @Override
    public String toString() {
        return "ExerciseSet{" +
                "id=" + id +
                ", setExerciseName='" + setExerciseName + '\'' +
                ", setNumber=" + setNumber +
                ", setWeight=" + setWeight +
                ", setReps=" + setReps +
                '}';
    }
}
