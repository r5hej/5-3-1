package sejtsoftware.workout531.helpers.database;


import android.arch.persistence.room.Room;
import android.content.Context;

public class Database {
    private static AppRoomDatabase sInstance;

    public static AppRoomDatabase getInstance() {
        return sInstance;
    }

    public static AppRoomDatabase init(Context context) {
        sInstance = Room
                .databaseBuilder(context, AppRoomDatabase.class, "5-3-1_database")
                .allowMainThreadQueries()
                .build();

        return sInstance;
    }
}
