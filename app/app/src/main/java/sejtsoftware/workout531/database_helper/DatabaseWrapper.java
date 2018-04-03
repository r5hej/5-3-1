package sejtsoftware.workout531.database_helper;


import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseWrapper {
    private static Database obj = null;

    public static Database instance(Context context) {
        if (obj == null) {
            obj = Room.databaseBuilder(context, Database.class, "5-3-1").build();
        }
        return obj;
    }
}
