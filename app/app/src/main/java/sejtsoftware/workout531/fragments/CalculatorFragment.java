package sejtsoftware.workout531.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Hashtable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import sejtsoftware.workout531.R;
import sejtsoftware.workout531.helpers.Calculations;
import sejtsoftware.workout531.helpers.database.entities.ActiveRMValue;
import sejtsoftware.workout531.helpers.database.Database;

public class CalculatorFragment extends Fragment {
    private Hashtable<String, Hashtable<String, Integer>> mExerciseData =
            new Hashtable<>();
    private Hashtable<String, TextView> mTextViews = new Hashtable<>();
    private boolean mEditableState = false;
    private boolean mNoEstimatedRM = false;

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

        // edit button locks/unlocks edittext views
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditableState = !mEditableState;
                if (mEditableState) {
                    setViewsEditable(layout, true);
                    editBtn.setImageResource(R.drawable.ic_save_black_24dp);
                    return;
                }

                setViewsEditable(layout, false);
                editBtn.setImageResource(R.drawable.ic_edit_black_24dp);
                updateRmsInDB();
            }
        });

        // get rm values from DB, if they exists

        if (Database.getInstance().activeRMValueDao().getRowCount() > 0)
            getRmsFromDB();
        else
            mNoEstimatedRM = true;

        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);

            if (child instanceof FloatingActionButton) continue;

            if (child instanceof EditText) {
                ((EditText) child).addTextChangedListener(new RMWatcher(child));

                // tags[0]: exercise, tags[1]: weight | reps
                String[] tags = child.getTag().toString().split(",");

                if (!mNoEstimatedRM) {
                    ((EditText) child).setText(mExerciseData.get(tags[0]).get(tags[1]).toString());
                    continue;
                }

                ((EditText) child).setText("0");

                if (!mExerciseData.containsKey(tags[0])) {
                    mExerciseData.put(tags[0], new Hashtable<String, Integer>());
                }


                int value = Integer.parseInt(((EditText) child).getText().toString());
                mExerciseData.get(tags[0]).put(
                        Objects.equals(tags[1], "weight") ? "weight" : "reps",
                        0
                );
                continue;
            }
            mTextViews.put(child.getTag().toString(), (TextView) child);
        }
    }

    private void updateRmsInDB() {
        Set<String> keys = mTextViews.keySet();

        for (String key : keys) {
            ActiveRMValue rm = new ActiveRMValue();

            rm.setExerciseName(key);
            rm.setRM(Double.parseDouble(mTextViews.get(key).getText().toString()));
            rm.setWeight(mExerciseData.get(key).get("weight"));
            rm.setReps(mExerciseData.get(key).get("reps"));

            Database.getInstance().activeRMValueDao().insertRM(rm);
        }
    }

    private void getRmsFromDB() {
        List<ActiveRMValue> data = Database.getInstance().activeRMValueDao().getAll();

        for (ActiveRMValue row : data) {
            mExerciseData.put(row.getExerciseName(), new Hashtable<String, Integer>());
            mExerciseData.get(row.getExerciseName()).put("weight", row.getWeight());
            mExerciseData.get(row.getExerciseName()).put("reps", row.getReps());
        }
    }

    private void setViewsEditable(ConstraintLayout layout, boolean isEditable) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof EditText) {
                child.setFocusable(isEditable);
                child.setFocusableInTouchMode(isEditable);
                child.setClickable(isEditable);
                ((EditText) child).setCursorVisible(isEditable);
            }
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