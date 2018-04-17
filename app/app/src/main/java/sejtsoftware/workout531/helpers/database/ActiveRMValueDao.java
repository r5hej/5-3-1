package sejtsoftware.workout531.helpers.database;


import android.arch.persistence.room.Query;

@android.arch.persistence.room.Dao
public interface ActiveRMValueDao {
    @Query("SELECT rm FROM ActiveRMValues WHERE exerciseName == (:exercise)")
    double getRM(String exercise);
}
