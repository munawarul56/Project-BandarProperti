package com.bandarproperti.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bandarproperti.MenuModel;
import com.bandarproperti.R;

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
//        holder.Gambar.set;
        holder.Judul.setText(dataList.get(position).getJudul());
        holder.Harga.setText(dataList.get(position).getHarga());
        holder.jmlKamarTidur.setText(dataList.get(position).getKamar_tidur());
        holder.jmlKamarMandi.setText(dataList.get(position).getKamar_mandi());
        holder.LuasArea.setText(dataList.get(position).getLuas_area());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
//        private ImageView Gambar;
        private TextView Judul, Harga, jmlKamarTidur, jmlKamarMandi,LuasArea;

        public MenuViewHolder(View itemView) {
            super(itemView);
//            Gambar = itemView.findViewById(R.id.gambar);
            Judul = itemView.findViewById(R.id.judul);
            Harga = itemView.findViewById(R.id.jml_harga);
            jmlKamarTidur = itemView.findViewById(R.id.jml_kamar_tidur);
            jmlKamarMandi = itemView.findViewById(R.id.jml_kamar_mandi);
            LuasArea = itemView.findViewById(R.id.jml_luas);

        }
    }
}
