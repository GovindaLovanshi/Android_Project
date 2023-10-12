package com.example.poetryapp.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poetryapp.R;

public class PoetryAdapter extends RecyclerView.Adapter<PoetryAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView poetName,poetry,date_time;
        AppCompatButton update_Btn,delete_Btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            poetName = itemView.findViewById(R.id.poetryPoetName);

            poetry = itemView.findViewById(R.id.poetryPoetryData);

            date_time = itemView.findViewById(R.id.poetryPoetryDateAndTime);

            update_Btn = itemView.findViewById(R.id.update_Btn);

            delete_Btn = itemView.findViewById(R.id.delete_Btn);
        }
    }
}

