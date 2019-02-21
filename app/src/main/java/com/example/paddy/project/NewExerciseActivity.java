package com.example.paddy.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.paddy.project.models.Exercise;
import com.example.paddy.project.persistence.ExerciseRepository;

public class NewExerciseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        View.OnClickListener {

    // UI Components
    private ImageButton mBackArrow;
    private ImageButton mCheckButton;
    private TextView mViewTitle;
    private EditText mEditExercise, mEditCategory;
  //  private Spinner mEditCategory;

    // vars
    private boolean mIsNewExercise;
    private ExerciseRepository mExerciseRepository;
    private Exercise mExerciseFinal;
    private Exercise mInitialExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exercise);
        mEditExercise = findViewById(R.id.exercise_edit_text);
        mEditCategory = findViewById(R.id.exercise_category_edit_text);
    //    mEditCategory = findViewById(R.id.spinnerCategory);
        mBackArrow = findViewById(R.id.toolbar_back_arrow_exercise);
        mViewTitle = findViewById(R.id.exercise_edit_text);
        mCheckButton = findViewById(R.id.toolbar_check);


        mExerciseRepository = new ExerciseRepository(this);

        Spinner spinner = findViewById(R.id.spinnerCategory);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.muscles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        if (getIncomingIntent()) {
            setNewExerciseProperties();
        } else {
            setExerciseProperties();
        }
        setListeners();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String muscle = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void setListeners() {
        mBackArrow.setOnClickListener(this);
        mCheckButton.setOnClickListener(this);

    }

    private boolean getIncomingIntent() {
        if (getIntent().hasExtra("selected_exercise")) {
            mInitialExercise = getIntent().getParcelableExtra("selected_exercise");
            mExerciseFinal = getIntent().getParcelableExtra("selected_exercise");

            mIsNewExercise = false;
            return false;
        }
        mIsNewExercise = true;
        return true;
    }

    private void isExerciseNotNull() {
        String temp = mEditExercise.getText().toString();
        temp = temp.replace("\n", "");
        temp = temp.replace(" ", "");
        if (temp.length() > 0) {
            mExerciseFinal.setName(mEditExercise.getText().toString());
            mExerciseFinal.setCategory(mEditCategory.getText().toString());
         //   mExerciseFinal.setCategory(mEditCategory.getParent().toString());
        }

    }

        private void setExerciseProperties () {
            mViewTitle.setText(mInitialExercise.getName());
        }

        private void setNewExerciseProperties () {
            mViewTitle.setText("Exercise Title");

            mInitialExercise = new Exercise();
            mExerciseFinal = new Exercise();
            mInitialExercise.setName("Exercise Name");
            mExerciseFinal.setName("Exercise Name");
        }

        private void saveChanges () {
            if (mIsNewExercise) {
                saveNewExercise();
            } else {
                updateExercise();
            }
        }

        public void updateExercise() {
            mExerciseRepository.updateExerciseTask(mExerciseFinal);
        }

        public void saveNewExercise () {
            mExerciseRepository.insertExerciseTask(mExerciseFinal);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.toolbar_check: {
                    isExerciseNotNull();
                    saveChanges();
                    finish();
                    break;
                }
                case R.id.toolbar_back_arrow_exercise: {
                    finish();
                    break;
                }
            }
        }
    }
