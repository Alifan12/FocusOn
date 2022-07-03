package com.example.focuson;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focuson.database.Tugas;

import java.util.List;

public class AdapterEditTugas  extends RecyclerView.Adapter<AdapterEditTugas.HolderData>{
    List<Tugas> listData;
    LayoutInflater layoutInflater;
    Context context;

    public AdapterEditTugas(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_edit_tugas, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.namaTugasView.setText(listData.get(position).getNama());
        holder.durasiTugas.setText(listData.get(position).getDuration().toString());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (listData != null)
            return listData.size();
        else return 0;
    }

    void setTugas(List<Tugas> words) {
        listData = words;
        notifyDataSetChanged();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView namaTugasView;
        TextView durasiTugas;
        Button btn;


        public HolderData(@NonNull View itemView) {
            super(itemView);

            namaTugasView = itemView.findViewById(R.id.namaTugas);
            durasiTugas = itemView.findViewById(R.id.durasiTugas);
            btn = itemView.findViewById(R.id.tombolTugas);
        }
    }
}
