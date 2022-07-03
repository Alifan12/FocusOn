package com.example.focuson;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focuson.database.Reward;

import java.util.ArrayList;
import java.util.List;

public class RewardListAdapter extends RecyclerView.Adapter<RewardListAdapter.RewardListViewHolder> {

    private ArrayList<Reward> dataList;

    public RewardListAdapter(ArrayList<Reward> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RewardListAdapter.RewardListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_reward, parent, false);
        return new RewardListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardListAdapter.RewardListViewHolder holder, int position) {
        holder.pictReward.setImageResource(dataList.get(position).getImage());
        holder.nameReward.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }


    public class RewardListViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictReward;
        private TextView nameReward;

        public RewardListViewHolder(@NonNull View itemView) {
            super(itemView);

            pictReward = itemView.findViewById(R.id.photo_reward);
            nameReward = itemView.findViewById(R.id.nama_reward);
        }
    }
}

