package com.ppjun.android.meituan;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Package :com.ppjun.android.meituan
 * Description :
 * Author :Rc3
 * Created at :2017/04/05 20:55.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ShopViewHolder> {
   public  RvAdapter(){

   }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShopViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_rv_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ShopViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder {
        public ShopViewHolder(View itemView) {
            super(itemView);
        }
    }
}
