package sejtsoftware.workout531;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ExerciseRowFragment fragment = new ExerciseRowFragment();
        fragmentTransaction.add(R.id.fragment_container_placeholder, fragment);
        fragmentTransaction.commit();


//        Fragment rowFrag = new ExerciseRowFragment();
//        FragmentTransaction fragTranc = getFragmentManager().beginTransaction();

    }
}
