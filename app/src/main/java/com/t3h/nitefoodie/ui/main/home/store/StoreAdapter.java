package com.t3h.nitefoodie.ui.main.home.store;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.ui.model.Store;

import java.util.List;

/**
 * Created by thinhquan on 6/29/17.
 */

public class StoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private List<Store> mItemStores;


    public StoreAdapter(List<Store> mItemStores) {
        this.mItemStores = mItemStores;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderPost(LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (null == mItemStores) {
            return;
        }
        Store store = mItemStores.get(position);
        ViewHolderPost viewHolderPost = (ViewHolderPost) holder;
//        viewHolderPost.imgAvatar
//                .setBackgroundResource(Utils.setImgAvatar((int) itemPost.getUserName().charAt(0)));
//        viewHolderPost.imgAvatar
//                .setImageURI(Utils.getLinkAvatar(itemPost.getUserID(),
//                        (int) Utils.convertDpToPixel(48) * 2,
//                        (int) Utils.convertDpToPixel(48) * 2));
        viewHolderPost.ivStore.setImageResource(R.drawable.gongcha);
        viewHolderPost.ivOnlineState.setImageResource(R.drawable.offline);
        viewHolderPost.txtUsername.setText(store.getName());
        viewHolderPost.txtAddress.setText(store.getAddress());
//        viewHolderPost.txtLocation.setText(itemPost.getLocation());
        viewHolderPost.txtPhone.setText(store.getPhone());
//        viewHolderPost.txtContent.setText(itemPost.getDes());
    }

    @Override
    public int getItemCount() {
        if (null == mItemStores) {
            return 0;
        }
        return mItemStores.size();
    }

    @Override
    public void onClick(View v) {

    }

    private class ViewHolderPost extends RecyclerView.ViewHolder {
//        private SimpleDraweeView imgAvatar;
        private ImageView ivStore;
        private TextView txtUsername;
        private ImageView ivOnlineState;
//        private TextView txtLocation;
        private TextView txtPhone;
        private TextView txtAddress;
//        private TextView txtContent;

        private ViewHolderPost(View itemView) {
            super(itemView);
//            imgAvatar = (SimpleDraweeView) itemView.findViewById(R.id.img_avatar_item);
            ivStore = (ImageView) itemView.findViewById(R.id.iv_store);
            txtUsername = (TextView) itemView.findViewById(R.id.tv_store_name);
            txtPhone = (TextView) itemView.findViewById(R.id.tv_tag);
            ivOnlineState = (ImageView) itemView.findViewById(R.id.iv_online_state);
//            txtLocation = (TextView) itemView.findViewById(R.id.txt_location);
            txtAddress = (TextView) itemView.findViewById(R.id.tv_store_address);
//            txtContent = (TextView) itemView.findViewById(R.id.content_post);


        }
    }


//    static class StoreViewHolder extends RecyclerView.ViewHolder {
//        ImageView ivStore;
//        TextView tvStoreName;
//        ImageView ivOnlineState;
//        TextView tvTag;
//        TextView tvAddress;
//
//        public StoreViewHolder(final View itemView) {
//            super(itemView);
//            ivOnlineState = (ImageView) itemView.findViewById(R.id.iv_online_state);
//            ivStore = (ImageView) itemView.findViewById(R.id.iv_store);
//            tvAddress = (TextView) itemView.findViewById(R.id.tv_store_address);
//            tvStoreName = (TextView) itemView.findViewById(R.id.tv_store_name);
//            tvTag = (TextView) itemView.findViewById(R.id.tv_tag);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Context context = itemView.getContext();
//                    Intent intent = new Intent(context, StoreDetailActivity.class);
//                    context.startActivity(intent,
//                            ActivityOptionsCompat.makeSceneTransitionAnimation
//                                    ((Activity) context, ivStore, "shareStore").toBundle());
//                }
//            });
//        }
//    }

}
