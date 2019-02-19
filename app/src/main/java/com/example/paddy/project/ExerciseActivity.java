package com.example.paddy.project;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.paddy.project.models.Exercise;

public class ExerciseActivity extends AppCompatActivity {

    private static final String TAG = "ExerciseActivity";
    private LinearLayout activityExerciseParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        activityExerciseParent = (LinearLayout) findViewById(R.id.activity_exercise_parent);

        if(getIntent().hasExtra("selected_exercise")){
            Exercise exercise = getIntent().getParcelableExtra("selected_exercise");
            Log.d(TAG, "onCreate: " + exercise.toString());
        }

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
}
