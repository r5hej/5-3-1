package sejtsoftware.workout531.helpers.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Excercise {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="cycle")
    private int cycle;

    // Save the calculated 1RM: max(weight*reps*.0333 + weight)
    // Also save the weight and reps used to calculate this 1RM, for user display.
    @ColumnInfo(name="oneRm")
    private int oneRepMax;

    @ColumnInfo(name="oneRmReps")
    private int oneRmReps;

    @ColumnInfo(name="oneRmWeight")
    private int oneRmWeight;
}