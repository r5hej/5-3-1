package sejtsoftware.workout531.models;

import android.os.AsyncTask;

import java.util.ArrayList;

import sejtsoftware.workout531.helpers.database.Database;

public class CoreExercise {
    private static double ONE_RM_CONSTANT = 0.0333;

    private String mName;
    private ArrayList<int[]> mSets = new ArrayList<>();
    private double mOneRm, mEstimatedOneRm;
    private int mCycle, mWeek;

//    public CoreExercise(String name) {
//        this(name, 0, 0, 0, 0);
//    }

//    public CoreExercise(String name, int reps, int weight) {
//        this(name, reps, weight, 0, 0);
//    }

    public CoreExercise(String name, int cycle, int week) {
        mName = name;
        mCycle = cycle;
        mWeek = week;
        mEstimatedOneRm = Database.getInstance().activeRMValueDao().getRM(mName.toLowerCase());
        mOneRm = mEstimatedOneRm * 0.9;
        generateSets();
    }

    /**
     * Generate sets for exercise
     */
    private void generateSets() {
        mSets.add(new int[]{round(0.4), 5});

        switch (mWeek) {
            case 1:
                mSets.add(new int[]{round(0.47), 5});
                mSets.add(new int[]{round(0.55), 3});
                mSets.add(new int[]{round(0.65), 5});
                mSets.add(new int[]{round(0.75), 5});
                mSets.add(new int[]{round(0.85), 5});
                break;
            case 2:
                mSets.add(new int[]{round(0.5), 5});
                mSets.add(new int[]{round(0.6), 3});
                mSets.add(new int[]{round(0.7), 3});
                mSets.add(new int[]{round(0.8), 3});
                mSets.add(new int[]{round(0.9), 3});
                break;
            case 3:
                mSets.add(new int[]{round(0.5), 5});
                mSets.add(new int[]{round(0.6), 3});
                mSets.add(new int[]{round(0.75), 5});
                mSets.add(new int[]{round(0.85), 3});
                mSets.add(new int[]{round(0.95), 1});
                break;
            case 4:
                mSets.add(new int[]{round(0.5), 5});
                mSets.add(new int[]{round(0.6), 5});
                break;
        }
    }

    private int round(double multiplier) {
        return (int) Math.round(mOneRm * multiplier);
    }

    //    region getter and setters
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getWeek() {
        return mWeek;
    }

    public ArrayList<int[]> getSets() {
        return mSets;
    }
//    endregion
}
