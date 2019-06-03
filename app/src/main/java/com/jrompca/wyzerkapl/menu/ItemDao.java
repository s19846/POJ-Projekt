package com.jrompca.wyzerkapl.menu;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM items")
    List<Item> loadAllItems();

    @Insert
    void insertAll(Item... items);
}
