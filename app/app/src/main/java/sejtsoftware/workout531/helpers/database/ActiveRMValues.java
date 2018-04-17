package sejtsoftware.workout531.helpers.database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "ActiveRMValues")
public class ActiveRMValues {
    @PrimaryKey
    private String exerciseName;

    @ColumnInfo(name = "rm")
    private double RM;

    @ColumnInfo(name = "weight")
    private int weight;

    @ColumnInfo(name = "reps")
    private int reps;
}
