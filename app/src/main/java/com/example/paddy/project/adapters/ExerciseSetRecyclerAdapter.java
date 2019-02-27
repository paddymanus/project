package com.example.paddy.project.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paddy.project.R;
import com.example.paddy.project.models.ExerciseSet;

import java.util.ArrayList;

public class ExerciseSetRecyclerAdapter extends RecyclerView.Adapter<ExerciseSetRecyclerAdapter.ViewHolder> {

    private ArrayList<ExerciseSet> mSets = new ArrayList<>();

    public ExerciseSetRecyclerAdapter(ArrayList<ExerciseSet> mSets) {
        this.mSets = mSets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_exerciseset, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.exerciseTitle.setText(mSets.get(i).getName());
        viewHolder.sets.setText(String.valueOf(mSets.get(i).getNumber()));
        viewHolder.weights.setText(String.valueOf(mSets.get(i).getWeight()));
        viewHolder.reps.setText(String.valueOf(mSets.get(i).getReps()));

    }

    @Override
    public int getItemCount() {
        return mSets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView exerciseTitle, sets, weights, reps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseTitle = itemView.findViewById(R.id.title_exercise_name);
            sets = itemView.findViewById(R.id.title_sets);
            weights = itemView.findViewById(R.id.title_weight);
            reps = itemView.findViewById(R.id.title_reps);
        }
    }
}
