package com.t3h.nitefoodie.ui.main.home.store;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.nitefoodie.R;

/**
 * Created by thinhquan on 7/1/17.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private IRecipeAdapter mInterf;

    public RecipeAdapter(IRecipeAdapter interf) {
        mInterf = interf;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_item_layout, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mInterf.getCount();
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRecipe;
        TextView tvRecipeName;
        TextView tvRecipePrice;
        ImageButton ibRecipeRemove;
        ImageButton ibRecipeAdd;
        TextView tvNumberRecipe;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ivRecipe = (ImageView) itemView.findViewById(R.id.iv_recipe);
            tvRecipeName = (TextView) itemView.findViewById(R.id.tv_recipe_name);
            tvRecipePrice = (TextView) itemView.findViewById(R.id.tv_recipe_price);
            ibRecipeRemove = (ImageButton) itemView.findViewById(R.id.ib_remove_recipe);
            ibRecipeAdd = (ImageButton) itemView.findViewById(R.id.ib_add_recipe);
            tvNumberRecipe = (TextView) itemView.findViewById(R.id.tv_number_recipe);

        }
    }

    public interface IRecipeAdapter {
        int getCount();
    }
}
