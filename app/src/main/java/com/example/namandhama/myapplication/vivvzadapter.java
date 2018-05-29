package com.example.namandhama.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;


import java.util.List;

public class vivvzadapter extends RecyclerView.Adapter<vivvzadapter.MyViewHolder> {
List<Note> data;


    public vivvzadapter(List<Note> data) {
        this.data = data;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;


    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note current=data.get(position);
        holder.tv.setText(current.subject);
       //holder.tv2.setText(""+current.id);
        holder.tv3.setText(current.text);


    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iv;
        TextView tv,tv2,tv3;


        public MyViewHolder(View itemView) {
            super(itemView);
            iv=(ImageView)itemView.findViewById(R.id.iv);
            tv=(TextView)itemView.findViewById(R.id.tv);
            tv2=(TextView)itemView.findViewById(R.id.tv2);
            tv3=(TextView)itemView.findViewById(R.id.tv3);
        }
    }
}
