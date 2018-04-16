package sejtsoftware.workout531.adapters;


import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import sejtsoftware.workout531.R;
import sejtsoftware.workout531.models.Exercise;

public class CycleListAdapter extends RecyclerView.Adapter<CycleListAdapter.ViewHolder> {
    private ArrayList<Exercise> mData;


    public CycleListAdapter(ArrayList<Exercise> data) {
        mData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView weight;
        public TextView reps;
        public TextInputEditText repsAchived;

        public ViewHolder(View v) {
            super(v);
            weight = v.findViewById(R.id.cycle_row_weight);
            reps = v.findViewById(R.id.cycle_row_reps);
            repsAchived = v.findViewById(R.id.cycle_row_reps_achieved);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cycle_exercise_list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.weight.setText(String.valueOf(mData.get(position).getWeight()));
        holder.reps.setText(String.valueOf(mData.get(position).getReps()));

        // TODO: must show last row with editable input as visible, but not in a deload week
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}
