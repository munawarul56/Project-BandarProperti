package com.bandarproperti;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.MenuViewHolder> {

    private ArrayList<MenuModel> dataList;

    public Menu_Adapter(ArrayList<MenuModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.menu_list_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.txtJudul.setText(dataList.get(position).getJudul());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        private TextView txtJudul, txtNpm, txtNoHp;

        public MenuViewHolder(View itemView) {
            super(itemView);
            txtJudul = (TextView) itemView.findViewById(R.id.judul);
        }
    }
}
