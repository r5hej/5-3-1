package sejtsoftware.workout531.helpers.database.dao;


import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import sejtsoftware.workout531.helpers.database.entities.ActiveRMValue;

@android.arch.persistence.room.Dao
public interface ActiveRMValueDao {
    @Query("SELECT rm FROM ActiveRMValue WHERE exerciseName == :exercise")
    double getRM(String exercise);

    @Query("SELECT * FROM ActiveRMValue")
    List<ActiveRMValue> getAll();

    @Query("SELECT COUNT(rm) FROM ActiveRMValue")
    int getRowCount();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRM(ActiveRMValue rm);
}
