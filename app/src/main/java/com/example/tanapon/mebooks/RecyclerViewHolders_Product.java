package com.example.tanapon.mebooks;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewHolders_Product extends RecyclerView.ViewHolder {


    public TextView txtDescription;


    public RecyclerViewHolders_Product(View itemView, final Context mContext, final ArrayList<String> myArrList) {
        super(itemView);
        txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }


}
