package com.example.recyclerviewexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerContactAdapter extends RecyclerView.Adapter<recyclerContactAdapter.ViewHolder> {
    ArrayList<contact_model> arrayList;
    Context context;
    public recyclerContactAdapter(Context context, ArrayList<contact_model> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.controller_activity, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).img);
        holder.contact.setText(arrayList.get(position).contact);
        holder.number.setText(arrayList.get(position).number);

        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.crud_operation_ui);

                EditText editName = dialog.findViewById(R.id.editName);
                editName.setText(arrayList.get(position).contact);
                EditText editNumber = dialog.findViewById(R.id.editNumber);
                editNumber.setText(arrayList.get(position).number);
                Button operationButton = dialog.findViewById(R.id.operationButton);
                operationButton.setText("Update");
                TextView operationName = dialog.findViewById(R.id.operationName);
                operationName.setText("Update Contact");

                operationButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", number = "";

                        if(editName.getText().toString().equals("")){
                            Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            name = editName.getText().toString();
                        }

                        if(editName.getText().toString().equals("")){
                            Toast.makeText(context, "Please enter number", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            number = editNumber.getText().toString();
                        }

                        arrayList.set(position ,new contact_model(R.drawable.contact, name, number));

                        notifyItemInserted(position);

                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });

        holder.row.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Confirm Delete ? ")
                        .setMessage("Are You Sure Want This Contact ? ")
                        .setIcon(R.drawable.baseline_auto_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(position);
                                notifyItemRemoved(position);
                            }
                        }
                        )
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView contact, number;
        LinearLayout row;
        public ViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.profileImage);
            contact = itemView.findViewById(R.id.contact);
            number = itemView.findViewById(R.id.number);
            row = itemView.findViewById(R.id.row);
        }

    }

}
