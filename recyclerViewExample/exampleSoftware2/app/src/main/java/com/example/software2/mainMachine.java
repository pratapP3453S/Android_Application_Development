package com.example.software2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mainMachine extends RecyclerView.Adapter<mainMachine.ViewHolder> {
    ArrayList<structure> arrayList;
    Context context;
    public mainMachine(Context context, ArrayList<structure> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public mainMachine.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_container, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull mainMachine.ViewHolder holder, int position) {
        holder.image.setImageResource(arrayList.get(position).image);
        holder.contact.setText(arrayList.get(position).contact);
        holder.number.setText(arrayList.get(position).number);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView contact, number;
        public ViewHolder(View view){
            super(view);

            image = view.findViewById(R.id.image);
            contact = view.findViewById(R.id.contact);
            number = view.findViewById((R.id.number));
        }

    }
}
