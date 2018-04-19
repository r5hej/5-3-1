package sejtsoftware.workout531.helpers.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Cycle.class, ActiveRMValues.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract CycleDao cycleDao();

    public abstract ActiveRMValueDao activeRMValueDao();
}