package com.t3h.nitefoodie.ui.main.home.store;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.nitefoodie.R;

/**
 * Created by thinhquan on 6/29/17.
 */

public class StoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private IStoreAdapter mInterf;

    public StoreAdapter(IStoreAdapter interf) {
        mInterf = interf;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.store_item_layout, parent, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mInterf.getCount();
    }

    static class StoreViewHolder extends RecyclerView.ViewHolder {
        ImageView ivStore;
        TextView tvStoreName;
        ImageView ivOnlineState;
        TextView tvTag;
        TextView tvAddress;

        public StoreViewHolder(final View itemView) {
            super(itemView);
            ivOnlineState = (ImageView) itemView.findViewById(R.id.iv_online_state);
            ivStore = (ImageView) itemView.findViewById(R.id.iv_store);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_store_address);
            tvStoreName = (TextView) itemView.findViewById(R.id.tv_store_name);
            tvTag = (TextView) itemView.findViewById(R.id.tv_tag);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, StoreDetailActivity.class);
                    context.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation
                                    ((Activity) context, ivStore, "shareStore").toBundle());
                }
            });
        }
    }

    public interface IStoreAdapter {
        int getCount();
    }
}
