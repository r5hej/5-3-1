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
import sejtsoftware.workout531.adapters.CycleAssistanceExerciseAdapter;
import sejtsoftware.workout531.adapters.CycleCoreExerciseAdapter;
import sejtsoftware.workout531.models.AssistanceExercise;
import sejtsoftware.workout531.models.CoreExercise;

public class CycleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cycle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Populate core recyclerview
        ArrayList<CoreExercise> coreData = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
//            data.add(new CoreExercise("Squat", 5, 42, 0,3));
        }

        RecyclerView rcCore = getView().findViewById(R.id.cycle_core_recyclerview);
        CycleCoreExerciseAdapter coreAdapter = new CycleCoreExerciseAdapter(coreData);
        rcCore.setAdapter(coreAdapter);
        rcCore.setLayoutManager(new LinearLayoutManager(getContext()));

        // Populate assistance recyclerview
        ArrayList<AssistanceExercise> assistanceData = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            assistanceData.add(new AssistanceExercise("Squat", 42, 5));
        }

        RecyclerView rcAssistance = getView().findViewById(R.id.cycle_assistance_recyclewview);
        CycleAssistanceExerciseAdapter assistanceAdapter = new CycleAssistanceExerciseAdapter(assistanceData);
        rcAssistance.setAdapter(assistanceAdapter);
        rcAssistance.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
