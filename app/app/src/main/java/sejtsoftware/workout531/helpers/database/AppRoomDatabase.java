package sejtsoftware.workout531.helpers.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import sejtsoftware.workout531.helpers.database.dao.ActiveRMValueDao;
import sejtsoftware.workout531.helpers.database.dao.CycleDao;
import sejtsoftware.workout531.helpers.database.entities.ActiveRMValue;
import sejtsoftware.workout531.helpers.database.entities.Cycle;

@Database(entities = {Cycle.class, ActiveRMValue.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {
    public abstract CycleDao cycleDao();

    public abstract ActiveRMValueDao activeRMValueDao();
}