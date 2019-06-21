package com.example.tione;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Fengzhuang> list;
    private OnItemclickListener onItemclickListener;

    public void setOnItemclickListener(OnItemclickListener onItemclickListener) {
        this.onItemclickListener = onItemclickListener;
    }

    public Myadapter(Context context, List<Fengzhuang> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new Oneviewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Fengzhuang fengzhuang = list.get(i);
        Oneviewholder oneviewholder= (Oneviewholder) viewHolder;
        oneviewholder.name.setText(fengzhuang.getName());
        oneviewholder.price.setText(fengzhuang.getPrice());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemclickListener!=null){
                    onItemclickListener.Onitemclick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Oneviewholder extends RecyclerView.ViewHolder{

       TextView name;
       TextView price;

        public Oneviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
    public interface OnItemclickListener{
        void Onitemclick(int position);
    }
}
