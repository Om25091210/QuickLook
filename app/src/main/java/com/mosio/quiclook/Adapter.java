package com.mosio.quiclook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<String> list;
    Context context;

    public Adapter(Context choose_identity, ArrayList<String> list) {
        this.context=choose_identity;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_location,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.location.setText(list.get(position));
        holder.location.setOnClickListener(v->{
            if(list.size()==1){
                list.clear();
                notifyItemRemoved(position);
            }
            if(position<list.size()) {
                list.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{

        TextView location;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            location=itemView.findViewById(R.id.loc);
        }
    }
}
