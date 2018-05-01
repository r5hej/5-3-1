package sejtsoftware.workout531.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.github.rubensousa.floatingtoolbar.FloatingToolbar;

import java.util.ArrayList;

import sejtsoftware.workout531.R;
import sejtsoftware.workout531.adapters.CycleAssistanceExerciseAdapter;
import sejtsoftware.workout531.adapters.CycleCoreExerciseAdapter;
import sejtsoftware.workout531.models.AssistanceExercise;
import sejtsoftware.workout531.models.CoreExercise;

public class CycleFragment extends Fragment {
    private FloatingActionButton mFab;
    private FloatingToolbar mToolbar;
    private RecyclerView mAssistanceRC, mCoreRC;

    private ArrayList<AssistanceExercise> mAssistanceData;
    private CycleAssistanceExerciseAdapter mAssistanceAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cycle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        CoreExercise coreExercise = new CoreExercise("squat", 3, 3);

        mCoreRC = getView().findViewById(R.id.cycle_core_recyclerview);
        CycleCoreExerciseAdapter coreAdapter = new CycleCoreExerciseAdapter(coreExercise);
        mCoreRC.setAdapter(coreAdapter);
        mCoreRC.setLayoutManager(new LinearLayoutManager(getContext()));

        // Populate assistance recyclerview
        mAssistanceData = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            mAssistanceData.add(new AssistanceExercise("Squat", 42, 5));
//        }

        mAssistanceRC = getView().findViewById(R.id.cycle_assistance_recyclewview);
        mAssistanceAdapter = new CycleAssistanceExerciseAdapter(mAssistanceData);
        mAssistanceRC.setAdapter(mAssistanceAdapter);
        mAssistanceRC.setLayoutManager(new LinearLayoutManager(getContext()));


        initToolbar(view);
    }

    private void initToolbar(View view) {
        mFab = view.findViewById(R.id.cycle_fab_toolbar_fab);
        mToolbar = view.findViewById(R.id.cycle_fab_toolbar_toolbar);

        // Attach fab to toolbar
        mToolbar.attachFab(mFab);

        // Attach listeners to menu items
        mToolbar.setClickListener(new FloatingToolbar.ItemClickListener() {
            @Override
            public void onItemClick(MenuItem item) {
                switch (item.getTitle().toString()) {
                    case "prev":
                        break;
                    case "add":
                        addAssistanceExercise();
                        break;
                    case "next":
                        break;
                }
            }

            @Override
            public void onItemLongClick(MenuItem item) {

            }
        });

    }

    private void addAssistanceExercise() {
        EditText name, weight, reps;

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        // Set title
        builder.setTitle("New assistance exercise");
        View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_cycle_add_assistance, null);

        // Get fields
        name = v.findViewById(R.id.dialog_cycle_add_name);
        weight = v.findViewById(R.id.dialog_cycle_add_weight);
        reps = v.findViewById(R.id.dialog_cycle_add_reps);

        // Set view
        builder.setView(v);

        // Set listeners
        builder.setPositiveButton("Add", (dialogInterface, i) -> {
            mAssistanceData.add(new AssistanceExercise(
                    name.getText().toString(),
                    Integer.parseInt(weight.getText().toString()),
                    Integer.parseInt(reps.getText().toString())

            ));

            mAssistanceAdapter.notifyItemInserted(mAssistanceData.size() - 1);
        });
        builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

        });

        builder.show();
    }
}
