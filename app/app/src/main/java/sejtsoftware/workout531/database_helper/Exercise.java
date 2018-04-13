package sejtsoftware.workout531.database_helper;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Exercise {
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


    //region getters and setters
    public int getUid() { return uid; }

    public void setUid(int uid) { this.uid = uid; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getCycle() { return cycle; }

    public void setCycle(int cycle) { this.cycle = cycle; }

    public int getOneRepMax() { return oneRepMax; }

    public void setOneRepMax(int oneRepMax) { this.oneRepMax = oneRepMax; }

    public int getOneRmReps() { return oneRmReps; }

    public void setOneRmReps(int oneRmReps) { this.oneRmReps = oneRmReps; }

    public int getOneRmWeight() { return oneRmWeight; }

    public void setOneRmWeight(int oneRmWeight) { this.oneRmWeight = oneRmWeight; }
    //endregion
}