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
    private boolean isDeload = false;
    private int mDataSize;


    public CycleListAdapter(ArrayList<Exercise> data) {
        mData = data;
        mDataSize = mData.size();
        if (mData.get(0).getWeek() == 4)
            isDeload = true;
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

        if (isDeload && position == mDataSize - 1)
            holder.repsAchived.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mDataSize;
    }
}
