package com.kunai.flueeapp.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kunai.flueeapp.R;
import com.kunai.flueeapp.model.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
    List<Album> arrayList;

    public RecyclerViewAdapter(List arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_layout,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.textAlbumName.setText(arrayList.get(position).getStrAlbum());
        holder.textAlbumYear.setText(arrayList.get(position).getIntYearReleased());
       // Picasso.with(holder.imageAlbumPhoto.getContext()).load().into(holder.imageAlbumPhoto);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textAlbumName,textAlbumYear;
        ImageView imageAlbumPhoto;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textAlbumName = itemView.findViewById(R.id.textAlbumName);
            textAlbumYear = itemView.findViewById(R.id.textAlbumYear);
            imageAlbumPhoto = itemView.findViewById(R.id.imageAlbum);
        }
    }
}
