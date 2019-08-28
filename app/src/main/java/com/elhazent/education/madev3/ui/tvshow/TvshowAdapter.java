package com.elhazent.education.madev3.ui.tvshow;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.elhazent.education.madev3.BuildConfig;
import com.elhazent.education.madev3.R;
import com.elhazent.education.madev3.model.ResultsItem;
import com.elhazent.education.madev3.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TvshowAdapter extends RecyclerView.Adapter<TvshowAdapter.ViewHolder> {
    Context context;
    List<ResultsItem> data;

    public TvshowAdapter(Context context, List<ResultsItem> data) {
        this.context = context;
        this.data = data;
    }

    public void refill(ArrayList<ResultsItem> items) {
        this.data = new ArrayList<>();
        this.data.clear();
        this.data.addAll(items);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvshowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TvshowAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TvshowAdapter.ViewHolder holder, final int position) {
        holder.judul.setText(data.get(position).getOriginalName());
        holder.desc.setText(data.get(position).getOverview());
        holder.date.setText(data.get(position).getFirstAirDate());

        Glide.with(context)
                .load(BuildConfig.BASE_URL_IMAGE+data.get(position).getPosterPath())
                .override(600, 200)
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                ResultsItem datamovie = data.get(position);
                intent.putExtra(DetailActivity.EXTRA_DETAIL,datamovie);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judul, desc, date;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.tv_item_title);
            desc = itemView.findViewById(R.id.tv_item_description);
            date = itemView.findViewById(R.id.tv_item_date);
            image = itemView.findViewById(R.id.img_poster);
        }
    }
}
