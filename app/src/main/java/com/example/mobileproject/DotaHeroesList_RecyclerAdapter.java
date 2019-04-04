package com.example.mobileproject;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.mobileproject.model.DotaHero;


public class DotaHeroesList_RecyclerAdapter extends RecyclerView.Adapter<DotaHeroesList_RecyclerAdapter.ViewHolder> {
    private List<DotaHero> values;
    private HeroesListActivity activity;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView icon;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
            icon = v.findViewById(R.id.icon);
        }
    }

    public void add(int position, DotaHero item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public DotaHeroesList_RecyclerAdapter(List<DotaHero> myDataset, HeroesListActivity activity) {
        values = myDataset;
        this.activity = activity;
    }

    @Override
    public DotaHeroesList_RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.heroeslist_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);

        vh.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showHeroesStat(vh.getAdapterPosition());
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        DotaHero hero = values.get(position);
        holder.txtHeader.setText(hero.getLocalized_name());
        holder.txtFooter.setText(hero.getName());
        Glide.with(holder.icon.getRootView()).load(hero.getIcon()).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new RequestListener<Drawable>() {
            public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource source, boolean isFirstResource) {
                holder.icon.getLayoutParams().width = holder.icon.getHeight();
                return false;
            }
        }).into(holder.icon);
    }


    @Override
    public int getItemCount() {
        return values.size();
    }

}