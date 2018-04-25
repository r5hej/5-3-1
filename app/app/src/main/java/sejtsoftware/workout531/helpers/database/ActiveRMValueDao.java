package sejtsoftware.workout531.helpers.database;


import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

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
