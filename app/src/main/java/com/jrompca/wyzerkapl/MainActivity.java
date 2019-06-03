package com.jrompca.wyzerkapl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jrompca.wyzerkapl.menu.Item;
import com.jrompca.wyzerkapl.menu.ItemAdapter;
import com.jrompca.wyzerkapl.menu.ItemRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDb();

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        ItemRepository itemRep = new ItemRepository(getApplicationContext());
        List<Item> items = itemRep.getItems();

        mAdapter = new ItemAdapter(getApplicationContext(), items);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    private void initDb() {
        ItemRepository itemRep = new ItemRepository(getApplicationContext());
        List<Item> items = itemRep.getItems();
        if (items.size() == 0) {
            itemRep.insertItems(Item.populateData());
        }
    }

}
