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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView weight;
        public TextView reps;
        public TextInputEditText repsAchived;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            weight = v.findViewById(R.id.cycle_item_weight);
            reps = v.findViewById(R.id.cycle_item_reps);
            repsAchived = v.findViewById(R.id.cycle_item_reps_achieved);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cycle_recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.weight.setText(String.valueOf(mData.get(position).getmWeight()));
        holder.reps.setText(String.valueOf(mData.get(position).getmReps()));
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }
}
