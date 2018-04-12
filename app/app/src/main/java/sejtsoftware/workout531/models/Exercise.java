package sejtsoftware.workout531.models;


public class Exercise {
    private int mReps;
    private int mWeight;

    public Exercise(int reps, int weight) {
        this.mReps = reps;
        this.mWeight = weight;
    }

    public String toString() {
        return String.format("%s - %s", mReps, mWeight);
    }
}
