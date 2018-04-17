package sejtsoftware.workout531.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import sejtsoftware.workout531.R;
import sejtsoftware.workout531.models.CoreExercise;

public class CycleCoreExerciseAdapter extends RecyclerView.Adapter<CycleCoreExerciseAdapter.ViewHolder> {
    private ArrayList<CoreExercise> mData;
    private boolean isDeload = false;
    private int mDataSize;


    public CycleCoreExerciseAdapter(ArrayList<CoreExercise> data) {
        mData = data;
        mDataSize = mData.size() + 1;
        if (mData.get(0).getWeek() == 4)
            isDeload = true;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView weight;
        public TextView reps;
        public EditText repsAchived;

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
        View v = inflater.inflate(R.layout.cycle_core_exercise_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0) {
            holder.weight.setText("Weight");
            holder.reps.setText("Reps");
            return;
        }
        position--;

//        holder.weight.setText(String.valueOf(mData.get(position).getWeight()));
//        holder.reps.setText(String.valueOf(mData.get(position).getReps()));

        if (!isDeload && position == mDataSize - 2)
            holder.repsAchived.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return  mDataSize;
    }
}
