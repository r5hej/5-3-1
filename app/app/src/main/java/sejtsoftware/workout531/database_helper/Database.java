package sejtsoftware.workout531.database_helper;


import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {CycleEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract CycleDao cycleDao();
}
