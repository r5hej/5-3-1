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
    private ArrayList<int[]> mData = new ArrayList<>();
    private boolean isDeload = false;
    private int mDataSize;


    public CycleCoreExerciseAdapter(CoreExercise data) {
        mData.addAll(data.getSets());

        mDataSize = mData.size();
        if (data.getWeek() == 4)
            isDeload = true;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView weight, reps;
        public EditText repsAchived;

        ViewHolder(View v) {
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
        int[] current = mData.get(position);

        holder.weight.setText(String.valueOf(current[0]));
        holder.reps.setText(String.valueOf(current[1]));

        if (!isDeload && position == mDataSize - 1)
            holder.repsAchived.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        return mDataSize;
    }
}
