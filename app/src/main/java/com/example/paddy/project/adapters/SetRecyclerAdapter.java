package com.example.paddy.project.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.paddy.project.R;
import com.example.paddy.project.models.Set;

import java.util.ArrayList;

public class SetRecyclerAdapter extends RecyclerView.Adapter<SetRecyclerAdapter.ViewHolder> {

    private ArrayList<Set> mSets = new ArrayList<>();

    public SetRecyclerAdapter(ArrayList<Set> mSets) {
        this.mSets = mSets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercise_field, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.set.setText(String.valueOf(mSets.get(i).get_setNumber()));
        viewHolder.weight.setText(String.valueOf(mSets.get(i).get_setWeight()));
        viewHolder.reps.setText(String.valueOf(mSets.get(i).get_setReps()));
    }

    @Override
    public int getItemCount() {
        return mSets.size();
    }

    public ArrayList<Set> getExerciseSets() {
        return mSets;
    }

    public void addExerciseSet(Set es) {
        mSets.add(es);
    }

    public void setExerciseSets(ArrayList<Set> exerciseSets) {
        mSets = exerciseSets;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView set;
        private EditText weight, reps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            set = itemView.findViewById(R.id.view_exercise_set_number);
            weight = itemView.findViewById(R.id.view_exercise_set_weight);
            reps = itemView.findViewById(R.id.view_exercise_set_reps);
        }
    }

    private void updateSets(ViewGroup parent) {
        for(int i = 0; i < this.getItemCount(); i++) {
            View item = parent.getChildAt(i);
            EditText setWeightET = (EditText) item.findViewById(R.id.view_exercise_set_weight);
            EditText setRepsET = (EditText) item.findViewById(R.id.view_exercise_set_reps);
            try {
                mSets.get(i).set_setWeight(Integer.valueOf(setWeightET.getText().toString()));
            } catch (Exception e) {
                mSets.get(i).set_setWeight(0);
            }
            try {
                mSets.get(i).set_setReps(Integer.valueOf(setRepsET.getText().toString()));
            } catch (Exception e) {
                mSets.get(i).set_setReps(0);
            }
        }
    }

}
