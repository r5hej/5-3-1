package sejtsoftware.workout531.helpers;


public class Calculations {
    public static double calculateOneRM(int weight, int reps) {
        return weight * reps * 0.33 + weight;
    }
}
