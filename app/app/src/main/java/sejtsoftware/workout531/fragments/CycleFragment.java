package sejtsoftware.workout531.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sejtsoftware.workout531.R;
import sejtsoftware.workout531.adapters.CycleListAdapter;
import sejtsoftware.workout531.models.Exercise;

public class CycleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cycle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Exercise> data = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            data.add(new Exercise("Squat", 5, 42));
        }

        RecyclerView rcView = getView().findViewById(R.id.cycle_recycle_list);
        CycleListAdapter adapter = new CycleListAdapter(data);
        rcView.setAdapter(adapter);
        rcView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}
