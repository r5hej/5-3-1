package sejtsoftware.workout531;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import sejtsoftware.workout531.fragments.CycleFragment;
import sejtsoftware.workout531.helpers.database.Exercise;
import sejtsoftware.workout531.helpers.database.ExerciseDatabase;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private ExerciseDatabase mDb;
    private ArrayList<Exercise> mExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDb = ExerciseDatabase.getInstance(MainActivity.this);

        // Add initial fragment to base view
        CycleFragment initialFragment = new CycleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_placeholder, initialFragment).commit();

        // Initialize drawer and set event listener
        mDrawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        // close drawer when item is tapped
                        mDrawer.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
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
//        private List<Exercise> mExercises;
//
//        LoadAllExercisesTask(MainActivity context, List<Exercise> exercises) {
//            mActivityRef = new WeakReference<>(context);
//            mExercises = exercises;
//        }
//
//        @Override
//        protected List<Exercise> doInBackground(Void... voids) {
//            mExercises = mActivityRef.get().mDb.getExerciseDao().loadAllExercises();
//            return mExercises;
//        }
//
//        @Override
//        protected void onPostExecute(List<Exercise> result) {
//
//        }
//    }
}
