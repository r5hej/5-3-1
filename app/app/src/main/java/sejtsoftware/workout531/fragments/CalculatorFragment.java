package sejtsoftware.workout531.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import sejtsoftware.workout531.R;

public class CalculatorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton editbtn = getView().findViewById(R.id.calculator_edit_save_button);
        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ConstraintLayout layout = getView().findViewById(R.id.calculator_layout);
        for (int i = 0; i < layout.getChildCount(); i ++) {
            View child = layout.getChildAt(i);
            if (child instanceof EditText) {
            }
        }
    }
}