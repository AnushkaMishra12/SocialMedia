package com.example.socialmedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.Holder> {
    private final ArrayList<ProfileData> list;

    public ProfileAdapter(ArrayList<ProfileData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ProfileData categoryData = list.get(position);
        holder.cat_image.setImageResource(categoryData.getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        private final ImageView cat_image;

        public Holder(@NonNull View itemView) {
            super(itemView);
            cat_image = itemView.findViewById(R.id.img);

        }

    }

}
