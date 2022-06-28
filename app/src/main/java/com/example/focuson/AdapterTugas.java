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

import java.util.List;

public class AdapterTugas  extends RecyclerView.Adapter<AdapterTugas.HolderData>{
    List<String> listData;
    LayoutInflater layoutInflater;
    Context context;

    public AdapterTugas(Context context, List<String> listData) {
        this.listData = listData;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.tugas_item, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.textView.setText(listData.get(position));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TugasDetailActivity.class);
                intent.putExtra("id", 1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView textView;
        Button btn;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.namaTugas);

            btn = itemView.findViewById(R.id.tombolTugas);
        }
    }
}
