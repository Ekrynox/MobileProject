package com.example.mobileproject;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class DotaHeroesList_RecyclerAdapter extends RecyclerView.Adapter<DotaHeroesList_RecyclerAdapter.ViewHolder> {
    private List<DotaHero> values;

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

    public DotaHeroesList_RecyclerAdapter(List<DotaHero> myDataset) {
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
                DotaHero hero = values.get(vh.getAdapterPosition());

            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        DotaHero hero = values.get(position);
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