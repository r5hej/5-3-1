package sejtsoftware.workout531.models;

public class Exercise {
    private static double ONE_RM_CONSTANT = 0.0333;

    private String mName;
    private int mReps;
    private int mWeight;
    private double mOneRm;
    private int mCycle, mWeek;

    public Exercise(String name) {
        this(name, 0, 0, 0, 0);
    }

    public Exercise(String name, int reps, int weight) {
        this(name, reps, weight, 0, 0);
    }

    public Exercise(String name, int reps, int weight, int cycle, int week) {
        this.mName = name;
        this.mReps = reps;
        this.mWeight = weight;
        this.mCycle = cycle;
        mWeek = week;
        this.mOneRm = calculatedOneRm();
    }

    public String toString() {
        return String.format("%s: %s - %s", mName, mReps, mWeight);
    }

    public double calculatedOneRm() {
        return mReps * mWeight * ONE_RM_CONSTANT + mWeight;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getWeight() {
        return mWeight;
    }

    public int getReps() {
        return mReps;
    }

    public int getWeek() {
        return mWeek;
    }
}
