package com.example.tanapon.mebooks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter_Product extends RecyclerView.Adapter<RecyclerViewHolders_Product> {


    private List<ItemObject_Product> itemList;
    private Context context;
    private ArrayList<String> myArrList;

    public RecyclerViewAdapter_Product(Context context, List<ItemObject_Product> itemList, ArrayList<String> myArrList) {
        this.itemList = itemList;
        this.context = context;
        this.myArrList = myArrList;

    }


    @Override
    public RecyclerViewHolders_Product onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_product, null);
        RecyclerViewHolders_Product rcv = new RecyclerViewHolders_Product(layoutView, context, myArrList);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders_Product holder, int position) {

        holder.txtDescription.setText(itemList.get(position).getDescription());

    }

        @Override
        public int getItemCount () {
            return this.itemList.size();
        }
    }
