package com.example.mobileproject;

import android.graphics.Color;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobileproject.model.DotaHeroMatch;

import java.util.List;


public class DotaHeroMatchesList_RecyclerAdapter extends RecyclerView.Adapter<DotaHeroMatchesList_RecyclerAdapter.ViewHolder> {
    private List<DotaHeroMatch> values;
    private HeroStatActivity activity;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public TextView txtName;
        public TextView txtStat;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtTitle = v.findViewById(R.id.matcheslist_win);
            txtName = v.findViewById(R.id.matcheslist_name);
            txtStat = v.findViewById(R.id.matcheslist_stats);
        }
    }

    public void add(int position, DotaHeroMatch item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public DotaHeroMatchesList_RecyclerAdapter(List<DotaHeroMatch> myDataset, HeroStatActivity activity) {
        values = myDataset;
        this.activity = activity;
    }

    @Override
    public DotaHeroMatchesList_RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.matcheslist_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        DotaHeroMatch match = values.get(position);
        holder.txtName.setText(match.getLeague_name());
        holder.txtStat.setText("K/D/A: " + match.getKills() + "/" + match.getDeaths() + "/" + match.getAssists());

        if ((match.isRadiant() && match.isRadiant_win()) || (!match.isRadiant() && !match.isRadiant_win())) {
            if (match.isRadiant()) {
                holder.txtTitle.setText("Victoire du Radiant");
            } else {
                holder.txtTitle.setText("Victoire du Dire");
            }
            holder.txtTitle.setTextColor(Color.GREEN);
        }
        else {
            if (match.isRadiant()) {
                holder.txtTitle.setText("Défaite du Radiant");
            } else {
                holder.txtTitle.setText("Défaite du Dire");
            }
            holder.txtTitle.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

}