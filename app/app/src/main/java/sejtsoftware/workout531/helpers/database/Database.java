package sejtsoftware.workout531.helpers.database;


import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {Cycle.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract CycleDao cycleDao();
}
