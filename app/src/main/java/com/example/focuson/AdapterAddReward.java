package com.example.focuson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focuson.database.Reward;

import java.util.ArrayList;

public class AdapterAddReward extends RecyclerView.Adapter<AdapterAddReward.AddRewardViewHolder> {

    private ArrayList<Reward> dataList;

    public AdapterAddReward(ArrayList<Reward> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AdapterAddReward.AddRewardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_reward, parent, false);
        return new AddRewardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAddReward.AddRewardViewHolder holder, int position) {

        holder.pictReward.setImageResource(dataList.get(position).getPhotoReward());
        holder.nameReward.setText(dataList.get(position).getNamaReward());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }


    public class AddRewardViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictReward;
        private TextView nameReward;

        public AddRewardViewHolder(@NonNull View itemView) {
            super(itemView);

            pictReward = itemView.findViewById(R.id.photo_reward);
            nameReward = itemView.findViewById(R.id.nama_reward);
        }
    }
}
