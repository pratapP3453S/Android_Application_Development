package com.example.contactapp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class runMachine extends RecyclerView.Adapter<runMachine.ViewHolder> {
    ArrayList<imageStructure> arrayList;
    Context context;
    public int lastAnimation = -1;
    public runMachine(Context context, ArrayList<imageStructure> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_container, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(arrayList.get(position).image);
        holder.contact.setText(arrayList.get(position).contact);
        holder.number.setText(arrayList.get(position).number);

        animationMethod(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView contact, number;
        public ViewHolder(View itemView){
            super(itemView);

            image = itemView.findViewById(R.id.profileImage);
            contact = itemView.findViewById(R.id.contact);
            number = itemView.findViewById(R.id.number);
        }
    }
    public void animationMethod(View view, int position){
        if(position>lastAnimation){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(animation);
            lastAnimation = position;
        }

    }

}
