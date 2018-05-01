package sejtsoftware.workout531.models;


public class AssistanceExercise {
    private String mName;
    private int mWeight;
    private int mReps;

    public AssistanceExercise(String name, int weight, int reps) {
        this.mName = name;
        this.mWeight = weight;
        this.mReps = reps;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setWeight(int weight) {
        mWeight = weight;
    }

    public void setReps(int reps) {
        mReps = reps;
    }

    public int getWeight() {
        return mWeight;
    }

    public int getReps() {
        return mReps;
    }
}
