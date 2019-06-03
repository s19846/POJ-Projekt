package com.jrompca.wyzerkapl;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import com.jrompca.wyzerkapl.menu.Item;
import com.jrompca.wyzerkapl.menu.ItemDao;

import java.util.concurrent.Executors;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract ItemDao itemDao();

    public static final String DB_NAME = "wyzerka";

    public synchronized static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    public static AppDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                DB_NAME
        ).allowMainThreadQueries().build();
    }
}
