package com.example.socialmedia;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Holder> {
    private final ArrayList<ContactData> list;

    public ContactAdapter(ArrayList<ContactData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ContactData categoryData = list.get(position);
        holder.img.setImageResource(categoryData.getImg());
        holder.name.setText(categoryData.getName());
        holder.layout.setOnClickListener(v -> moveData(v,holder.getAdapterPosition()));
    }

    private void moveData(View v, int adapterPosition) {
        Intent i = new Intent(v.getContext(), ChattingActivity.class);
        v.getContext().startActivity(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        private final ImageView img;
        private final  TextView name;
        LinearLayout layout;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            layout=itemView.findViewById(R.id.layout);

        }

    }

}
