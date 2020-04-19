package com.example.wangluoqingqiu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Page1Adapter extends RecyclerView.Adapter<Page1Adapter.ViewHolder> {
    private List<Page1> mjsonList;
    public Context con;
    public LayoutInflater inflater;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView link;
        TextView name;
        TextView order;
        TextView visible;

        public ViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.id_1);
            link = view.findViewById(R.id.link_1);
            name = view.findViewById(R.id.name_1);
            order = view.findViewById(R.id.order_1);
            visible = view.findViewById(R.id.visible_1);
        }
    }

    public Page1Adapter(List<Page1> page1List, Context con) {
        this.con = con;
        mjsonList = page1List;
        inflater = LayoutInflater.from(con);
    }

    @Override
    public Page1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.page1_item, parent, false);
        Page1Adapter.ViewHolder holder = new Page1Adapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Page1Adapter.ViewHolder holder, int position) {
        Page1 page1 = mjsonList.get(position);
        holder.id.setText("" + page1.getId());
        holder.link.setText(page1.getLink());
        holder.name.setText(page1.getName());
        holder.order.setText("" + page1.getOrder());
        holder.visible.setText("" + page1.getVisible());
    }

    @Override
    public int getItemCount() {
        return mjsonList.size();
    }
}

