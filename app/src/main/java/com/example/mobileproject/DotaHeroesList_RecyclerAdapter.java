package com.example.mobileproject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DotaHeroesList_RecyclerAdapter extends RecyclerView.Adapter<DotaHeroesList_RecyclerAdapter.ViewHolder> {
    private List<DotaHeroes> values;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView icon;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            icon = (ImageView) v.findViewById(R.id.icon);
        }
    }

    public void add(int position, DotaHeroes item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public DotaHeroesList_RecyclerAdapter(List<DotaHeroes> myDataset) {
        values = myDataset;
    }

    @Override
    public DotaHeroesList_RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.heroeslist_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);

        vh.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DotaHeroes hero = values.get(vh.getAdapterPosition());

            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        DotaHeroes hero = values.get(position);
        holder.txtHeader.setText(hero.getLocalized_name());
        holder.txtFooter.setText(hero.getName());

        new DownloadBitmap(holder.icon, this::setIconHeight).execute("https://api.opendota.com" + hero.getIcon());
    }

    public void setIconHeight(ImageView view) {
        view.getLayoutParams().width = view.getHeight();
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

}