package sejtsoftware.workout531.helpers.database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "CycleArchive")
public class Cycle {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "CycleNumber")
    private int cycleNo;

    @ColumnInfo(name = "SquatRM")
    private double squatRM;

    @ColumnInfo(name = "BenchRM")
    private double benchRM;

    @ColumnInfo(name = "DeadliftRM")
    private double deadliftRM;

    @ColumnInfo(name = "OhRM")
    private double ohRM;

    //region getters and setters
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCycleNo() {
        return cycleNo;
    }

    public void setCycleNo(int cycleNo) {
        this.cycleNo = cycleNo;
    }

    public double getSquatRM() {
        return squatRM;
    }

    public void setSquatRM(double squatRM) {
        this.squatRM = squatRM;
    }

    public double getBenchRM() {
        return benchRM;
    }

    public void setBenchRM(double benchRM) {
        this.benchRM = benchRM;
    }

    public double getDeadliftRM() {
        return deadliftRM;
    }

    public void setDeadliftRM(double deadliftRM) {
        this.deadliftRM = deadliftRM;
    }

    public double getOhRM() {
        return ohRM;
    }

    public void setOhRM(double ohRM) {
        this.ohRM = ohRM;
    }

    //endregion
}
