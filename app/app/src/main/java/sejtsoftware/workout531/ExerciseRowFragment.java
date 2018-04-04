package sejtsoftware.workout531;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Implement onPause()

public class ExerciseRowFragment extends Fragment {
    public ExerciseRowFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // return a view
        return inflater.inflate(R.layout.fragment_exercise_row, container, false);

    }
}
