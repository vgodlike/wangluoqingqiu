package com.example.wangluoqingqiu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Page0Adapter extends RecyclerView.Adapter<Page0Adapter.ViewHolder> {
    private List<Page0> mjsonList;
    public Context con;
    public LayoutInflater inflater;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView icon;
        TextView id;
        TextView link;
        TextView name;
        TextView order;
        TextView visible;

        public ViewHolder(View view) {
            super(view);
            icon = view.findViewById(R.id.icon);
            id = view.findViewById(R.id.id_0);
            link = view.findViewById(R.id.link_0);
            name = view.findViewById(R.id.name_0);
            order = view.findViewById(R.id.order_0);
            visible = view.findViewById(R.id.visible_0);
        }
    }

    public Page0Adapter(List<Page0> page0List, Context con) {
        this.con=con;
        mjsonList = page0List;
        inflater=LayoutInflater.from(con);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.page0_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Page0 page0 = mjsonList.get(position);
        holder.icon.setText(page0.getIcon());
        holder.id.setText(""+ page0.getId());
        holder.link.setText(page0.getLink());
        holder.name.setText(page0.getName());
        holder.order.setText(""+ page0.getOrder());
        holder.visible.setText(""+ page0.getVisible());
    }

    @Override
    public int getItemCount() {
        return mjsonList.size();
    }
}
