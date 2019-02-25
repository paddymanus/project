package com.example.paddy.project.models;

import java.util.ArrayList;

public class ExerciseSet {

    private String setExerciseName;
    private int setNumber;
    private int setWeight;
    private int setReps;
    private ArrayList<ExerciseSet> mExerciseSets = new ArrayList<>();


    public ExerciseSet(String setExerciseName, int setNumber, int setWeight, int setReps) {
        this.setExerciseName = setExerciseName;
        this.setNumber = setNumber;
        this.setWeight = setWeight;
        this.setReps = setReps;
    }

    public ExerciseSet() {
    }

    public void setExerciseSets(ArrayList<ExerciseSet> exerciseSets) {
        mExerciseSets = exerciseSets;
    }

    public String getSetExerciseName() {
        return setExerciseName;
    }

    public void setSetExerciseName(String setExerciseName) {
        this.setExerciseName = setExerciseName;
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
                "setExerciseName='" + setExerciseName + '\'' +
                ", setNumber=" + setNumber +
                ", setWeight=" + setWeight +
                ", setReps=" + setReps +
                '}';
    }
}
