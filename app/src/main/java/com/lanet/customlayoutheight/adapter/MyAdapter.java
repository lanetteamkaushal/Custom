package com.lanet.customlayoutheight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lanet.customlayoutheight.custom.SingleImageCell;

/**
 * Created by lcom75 on 7/1/17.
 */

public class MyAdapter extends RecyclerView.Adapter {

    Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SingleImageCell singleImageCell = new SingleImageCell(context);
        BlankVH blankVH = new BlankVH(singleImageCell);
        return blankVH;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder vh, int position) {
        BlankVH viewHolder = (BlankVH) vh;
        SingleImageCell singleImageCell = (SingleImageCell) viewHolder.itemView;
        singleImageCell.setNo_of_image(position + 1);
    }

    @Override
    public int getItemCount() {
        return 13;
    }

    public class BlankVH extends RecyclerView.ViewHolder {
        public BlankVH(View itemView) {
            super(itemView);
        }
    }
}
