package com.t3h.nitefoodie.ui.main.home.listshop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.base.IGetPosition;

/**
 * Created by thinhquan on 6/29/17.
 */

public class StoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private IStoreAdapter mInterf;

    public StoreAdapter(IStoreAdapter interf) {
        mInterf = interf;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.store_item_layout, parent, false);
        return new StoreViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mInterf.getCount();
    }

    @Override
    public void onClick(View v) {
        IGetPosition position = (IGetPosition) v.getTag();
        int pos = position.getPosition();
        mInterf.onClick(pos);
    }

    static class StoreViewHolder extends RecyclerView.ViewHolder {
        ImageView ivStore;
        TextView tvStoreName;
        ImageView ivOnlineState;
        TextView tvTag;
        TextView tvAddress;

        public StoreViewHolder(View itemView, View.OnClickListener onClickListener) {
            super(itemView);
            ivOnlineState = (ImageView) itemView.findViewById(R.id.iv_online_state);
            ivStore = (ImageView) itemView.findViewById(R.id.iv_store);
            tvAddress = (TextView) itemView.findViewById(R.id.tv_store_address);
            tvStoreName = (TextView) itemView.findViewById(R.id.tv_store_name);
            tvTag = (TextView) itemView.findViewById(R.id.tv_tag);

            itemView.setOnClickListener(onClickListener);

            IGetPosition position = new IGetPosition() {
                @Override
                public int getPosition() {
                    return getAdapterPosition();
                }
            };

            itemView.setTag(position);
        }
    }

    public interface IStoreAdapter {
        int getCount();

        void onClick(int position);

    }
}
