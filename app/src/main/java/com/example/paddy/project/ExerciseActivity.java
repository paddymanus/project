package com.example.paddy.project;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.paddy.project.models.Exercise;

public class ExerciseActivity extends AppCompatActivity {

    private static final String TAG = "ExerciseActivity";
    private LinearLayout activityExerciseParent;

    // UI components
    private TextView mViewTitle;

    // vars
    private boolean mIsNewExercise;
    private Exercise mInitialExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        activityExerciseParent = (LinearLayout) findViewById(R.id.activity_exercise_parent);
        mViewTitle = findViewById(R.id.note_exercise_title);

        if(getIncomingIntent()){
            setNewExerciseProperties();
        }
        else {
            setExerciseProperties();
        }


//        if(getIntent().hasExtra("selected_exercise")){
//            Exercise exercise = getIntent().getParcelableExtra("selected_exercise");
//            Log.d(TAG, "onCreate: " + exercise.toString());
//        }

    }

    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.exercise_field, null);
        // Add the new row before the add field button.
        activityExerciseParent.addView(rowView, activityExerciseParent.getChildCount() - 1);
    }

    public void onDelete(View v) {
        activityExerciseParent.removeView((View) v.getParent());
    }

    private boolean getIncomingIntent(){
        if(getIntent().hasExtra("selected_exercise")){
            mInitialExercise = getIntent().getParcelableExtra("selected_exercise");
            Log.d(TAG, "getIncomingIntent: " + mInitialExercise.toString());

            mIsNewExercise = false;
            return false;
        }
        mIsNewExercise = true;
        return true;
    }

    private void setExerciseProperties(){
        mViewTitle.setText(mInitialExercise.getName());
    }

    private void setNewExerciseProperties(){
        mViewTitle.setText("Exercise Title");
    }




}
