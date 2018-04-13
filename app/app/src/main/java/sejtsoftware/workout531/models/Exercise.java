package sejtsoftware.workout531.models;

public class Exercise {
    private static double ONE_RM_CONSTANT = 0.0333;

    private String mName;
    private int mReps;
    private int mWeight;
    private double mOneRm;
    private int mCycle;

    public Exercise(String name) {
        this(name, 0, 0, 0);
    }

    public Exercise(String name, int reps, int weight) {
        this(name, reps, weight, 0);
    }

    public Exercise(String name, int reps, int weight, int cycle) {
        this.mName = name;
        this.mReps = reps;
        this.mWeight = weight;
        this.mCycle = cycle;
        this.mOneRm = calculatedOneRm();
    }

    public String toString() {
        return String.format("%s: %s - %s", mName, mReps, mWeight);
    }

    public double calculatedOneRm() {
        return mReps * mWeight * ONE_RM_CONSTANT + mWeight;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
