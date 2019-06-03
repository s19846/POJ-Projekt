package com.jrompca.wyzerkapl.menu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jrompca.wyzerkapl.MainActivity;
import com.jrompca.wyzerkapl.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context mContext;
    private List<Item> itemList;
    private ArrayAdapter<Integer> priceAdapter;

    public ItemAdapter(
            Context context,
            List<Item> itemList
    ) {
        this.mContext = context;
        this.itemList = itemList;

        priceAdapter = new ArrayAdapter<>(
                mContext,
                R.layout.support_simple_spinner_dropdown_item,
                Item.getSizes()
        );

        priceAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView label;
        TextView hotness;
        Spinner size;
        TextView price;
        ItemViewHolder(View view) {
            super(view);
            label = view.findViewById(R.id.label);
            hotness = view.findViewById(R.id.hotness);
            size = view.findViewById(R.id.size);
            price = view.findViewById(R.id.price);

            size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String item = String.valueOf(parent.getItemAtPosition(position));
                    ItemRepository itemRep = new ItemRepository(view.getContext());
                    List<Item> items = itemRep.getItems();
                    Item currItem = items.get(getAdapterPosition());

                    price.setText(String.valueOf(currItem.getPrices().get(position)));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    @Override
    @NonNull
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.label.setText(itemList.get(position).getLabel());
        holder.hotness.setText(String.valueOf(itemList.get(position).getHotness()));
        holder.size.setAdapter(priceAdapter);
        holder.price.setText(String.valueOf(itemList.get(position).getPrices().get(0)));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
