package com.jrompca.wyzerkapl.menu;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Arrays;

@Entity(tableName = "items")
public class Item {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "label")
    private String label;

    @ColumnInfo(name = "hotness")
    private int hotness;

    @ColumnInfo(name = "price")
    private ArrayList<Integer> prices;

    @ColumnInfo(name = "ingredients")
    private ArrayList<String> ingredients;

    Item(
            String label,
            int hotness,
            ArrayList<Integer> prices,
            ArrayList<String> ingredients
    ) {
        this.label = label;
        this.hotness = hotness;
        this.prices = prices;
        this.ingredients = ingredients;
    }

    void setUid(int uid) {
        this.uid = uid;
    }

    int getUid() {
        return uid;
    }

    String getLabel() {
        return label;
    }

    int getHotness() {
        return hotness;
    }

    ArrayList<Integer> getPrices() {
        return prices;
    }

    static ArrayList<Integer> getSizes() {
        return new ArrayList<>(
                Arrays.asList(32, 45, 60)
        );
    }

    ArrayList<String> getIngredients() {
        return ingredients;
    }

    public static Item[] populateData() {
        return new Item[] {
                new Item(
                        "Wegetariańska",
                        0,
                        new ArrayList<Integer>(
                                Arrays.asList(20, 25, 30)
                        ),
                        new ArrayList<String>(
                                Arrays.asList("papryka", "pomidor", "ser")
                        )
                ),
                new Item(
                        "Capricciosa",
                        1,
                        new ArrayList<Integer>(
                                Arrays.asList(22, 27, 32)
                        ),
                        new ArrayList<String>(
                                Arrays.asList("pieczarki", "sos", "szynka")
                        )
                ),
                new Item(
                        "Pepperoni",
                        5,
                        new ArrayList<Integer>(
                                Arrays.asList(25, 30, 35)
                        ),
                        new ArrayList<String>(
                                Arrays.asList("salami", "papryka ostra", "cebula", "ser")
                        )
                ),
        };
    }
}
