package com.example.lanarahim.notetakers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lana Rahim on 12/20/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private ArrayList<String> rvData;
     public RecycleAdapter(ArrayList<String> inputData){
         rvData = inputData;
     }
     public class ViewHolder extends RecyclerView.ViewHolder{

         public TextView tvTitle;
         public TextView tvSubtitle;
         public LinearLayout tvButton;
         public ViewHolder(View itemView) {
             super(itemView);
             tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
             tvSubtitle = (TextView) itemView.findViewById(R.id.tv_subtitle);
             tvButton = (LinearLayout)itemView.findViewById(R.id.item_list);
         }
     }
     @Override
     public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item,parent,false);
         ViewHolder vh = new ViewHolder(view);
         return vh;
     }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name = rvData.get(position);
        holder.tvTitle.setText(rvData.get(position));
        holder.tvSubtitle.setText("Frau "+position);
        holder.tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("data ke - "+rvData.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }
}
