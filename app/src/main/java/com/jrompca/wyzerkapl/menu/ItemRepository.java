package com.jrompca.wyzerkapl.menu;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.jrompca.wyzerkapl.AppDatabase;

import java.util.List;

public class ItemRepository {

    private AppDatabase appDb;

    public ItemRepository(Context context) {
        appDb = AppDatabase.buildDatabase(context);
    }

    public List<Item> getItems() {
        return appDb.itemDao().loadAllItems();
    }

    public void insertItems(Item[] items) {
        appDb.itemDao().insertAll(items);
    }
}
