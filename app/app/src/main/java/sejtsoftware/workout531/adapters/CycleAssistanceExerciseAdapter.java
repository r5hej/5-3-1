package sejtsoftware.workout531.adapters;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import sejtsoftware.workout531.R;
import sejtsoftware.workout531.models.AssistanceExercise;

public class CycleAssistanceExerciseAdapter extends RecyclerView.Adapter<CycleAssistanceExerciseAdapter.ViewHolder> {
    private ArrayList<AssistanceExercise> mData;

    public CycleAssistanceExerciseAdapter(ArrayList<AssistanceExercise> data) {
        mData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, weight, reps;
        public View divider;

        ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.cycle_assistance_row_name);
            weight = v.findViewById(R.id.cycle_assistance_row_weight);
            reps = v.findViewById(R.id.cycle_assistance_row_reps);
            divider = v.findViewById(R.id.cycle_assistance_row_divider);
        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cycle_assistance_exercise_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getName());
        holder.reps.setText(String.valueOf(mData.get(position).getReps()));
        holder.weight.setText(String.valueOf(mData.get(position).getWeight()));

        if (position == mData.size() - 1) holder.divider.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
