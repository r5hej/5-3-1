package sejtsoftware.workout531.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Hashtable;
import java.util.Objects;

import sejtsoftware.workout531.R;
import sejtsoftware.workout531.helpers.Calculations;

public class CalculatorFragment extends Fragment {
    private Hashtable<String, Hashtable<String, Integer>> mExerciseData =
            new Hashtable<>();
    private Hashtable<String, TextView> mTextViews = new Hashtable<>();
    private boolean mEditableState = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ConstraintLayout layout = getView().findViewById(R.id.calculator_layout);
        final FloatingActionButton editBtn = getView().findViewById(R.id.calculator_edit_save_button);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditableState = !mEditableState;
                if (mEditableState) {
                    for (int i = 0; i < layout.getChildCount(); i++) {
                        View child = layout.getChildAt(i);
                        if (child instanceof EditText) {
                            child.setFocusable(true);
                            child.setFocusableInTouchMode(true);
                            child.setClickable(true);
                            ((EditText) child).setCursorVisible(true);
                        }
                    }

                    editBtn.setImageResource(R.drawable.ic_save_black_24dp);
                    return;
                }

                for (int i = 0; i < layout.getChildCount(); i++) {
                    View child = layout.getChildAt(i);
                    if (child instanceof EditText) {
                        child.setFocusable(false);
                        child.setFocusableInTouchMode(false);
                        child.setClickable(false);
                        ((EditText) child).setCursorVisible(false);
                    }
                }

                editBtn.setImageResource(R.drawable.ic_edit_black_24dp);
            }
        });

        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);

            if (child instanceof FloatingActionButton) continue;

            if (child instanceof EditText) {
                // tags[0] = exercise, tags[1] = weight | reps
                String[] tags = child.getTag().toString().split(",");

                if (!mExerciseData.containsKey(tags[0])) {
                    mExerciseData.put(tags[0], new Hashtable<String, Integer>());
                }

                int value = Integer.parseInt(((EditText) child).getText().toString());
                mExerciseData.get(tags[0]).put(
                        Objects.equals(tags[1], "weight") ? "weight" : "reps",
                        value
                );

                ((EditText) child).addTextChangedListener(new RMWatcher(child));
                continue;
            }

            mTextViews.put(child.getTag().toString(), (TextView) child);
        }
    }

    public class RMWatcher implements TextWatcher {
        private EditText mField;

        public RMWatcher(View view) {
            mField = (EditText) view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            try {
                String[] tags = mField.getTag().toString().split(",");

                mExerciseData.get(tags[0]).put(tags[1], Integer.parseInt(mField.getText().toString()));

                TextView view = mTextViews.get(tags[0]);
                view.setText(String.valueOf(
                        Calculations.calculateOneRM(
                                mExerciseData.get(tags[0]).get("weight"),
                                mExerciseData.get(tags[0]).get("reps")
                        ))
                );

            } catch (Exception e) {
                return;
            }
        }
    }
}