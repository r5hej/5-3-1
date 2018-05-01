package sejtsoftware.workout531;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import sejtsoftware.workout531.fragments.CalculatorFragment;
import sejtsoftware.workout531.fragments.CycleFragment;
import sejtsoftware.workout531.helpers.database.entities.ActiveRMValue;
import sejtsoftware.workout531.helpers.database.Database;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database.init(this);

        int count = 0;
        try {
            count = Database.getInstance().activeRMValueDao().getRowCount();

        } catch (Exception e) {
            Log.d("dberror", e.toString());
        }
        if (count == 0) {
            String[] exercises = new String[]{"squat", "bench", "deadlift", "military"};

            for (String item : exercises) {
                ActiveRMValue rm = new ActiveRMValue();
                rm.setExerciseName(item);
                rm.setReps(0);
                rm.setWeight(0);
                rm.setRM(0);
                Database.getInstance().activeRMValueDao().insertRM(rm);
            }
        }

        // Add initial fragment to base view
        CycleFragment initialFragment = new CycleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_placeholder, initialFragment).commit();

        // Initialize drawer and set event listener
        mDrawer = findViewById(R.id.drawer_layout);
        NavigationView navViewLeft = findViewById(R.id.nav_view_left);
        navViewLeft.setNavigationItemSelectedListener(item -> {
            item.setChecked(true);

            switch (item.getTitle().toString()) {
                case "Cycle":
                    CycleFragment cycleFragment = new CycleFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_placeholder, cycleFragment).commit();
                    break;

                case "Calculator":
                    CalculatorFragment calcFragment = new CalculatorFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_placeholder, calcFragment).commit();
                    break;
            }

            mDrawer.closeDrawers();

            return true;
        });

        NavigationView navViewRight = findViewById(R.id.nav_view_right);
        navViewRight.setNavigationItemSelectedListener(
                item -> {
                    item.setChecked(true);
                    mDrawer.closeDrawers();

                    return true;
                });

        // Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        // Set drawer menu btn on toolbar
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


//    private static class LoadAllExercisesTask extends AsyncTask<Void, Void, Boolean> {
//        private WeakReference<MainActivity> mActivityRef;
//        private List<CoreExercise> mExercises;
//
//        LoadAllExercisesTask(MainActivity context, List<CoreExercise> exercises) {
//            mActivityRef = new WeakReference<>(context);
//            mExercises = exercises;
//        }
//
//        @Override
//        protected List<CoreExercise> doInBackground(Void... voids) {
//            mExercises = mActivityRef.get().mDb.getExerciseDao().loadAllExercises();
//            return mExercises;
//        }
//
//        @Override
//        protected void onPostExecute(List<CoreExercise> result) {
//
//        }
//    }
}
