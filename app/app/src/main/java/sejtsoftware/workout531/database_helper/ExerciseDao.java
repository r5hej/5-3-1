package sejtsoftware.workout531.database_helper;


import android.arch.persistence.room.Dao;

@android.arch.persistence.room.Dao
public interface ExerciseDao {
    @Query("SELECT * FROM exercise")
    List<Exercise> getAll();

    @Query("SELECT * FROM exercise WHERE uid=(:exerciseId")
    Exercise getExerciseById(int exerciseId);

    @Query("SELECT oneRepMax FROM exercise WHERE uid=(:exerciseId)")
    Int getOneRm(int exerciseId);

    @Insert
    void insertAll(Exercise... exercises);

    @Delete
    void delete(Exercise exercise);
}
