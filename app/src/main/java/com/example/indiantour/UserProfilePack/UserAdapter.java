package com.example.indiantour.UserProfilePack;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indiantour.R;
import com.example.indiantour.RecyclerViewPack.Model;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.userViewHolder> {

    List<Model> modelList;
    Context context;

    public UserAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.profile_sample , parent , false);
        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        Model model = modelList.get(position);

        holder.imageView.setImageResource(model.getImages());
        holder.textView.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class userViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_image);
            textView = itemView.findViewById(R.id.text_desc);
        }
    }

}
