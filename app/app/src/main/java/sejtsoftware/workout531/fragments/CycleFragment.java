package sejtsoftware.workout531.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import sejtsoftware.workout531.R;
import sejtsoftware.workout531.models.Exercise;

public class CycleFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Exercise> data = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            data.add(new Exercise(5, 42));
        }

        ArrayAdapter<Exercise> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, data);
        ListView lv = getView().findViewById(R.id.cycle_listview);
        lv.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cycle, container, false);
    }
}
