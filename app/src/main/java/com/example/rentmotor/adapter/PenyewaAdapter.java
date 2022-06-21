package com.example.rentmotor.adapter;

import  android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.rentmotor.DaftarPenyewa;
import com.example.rentmotor.MainActivity;
import com.example.rentmotor.R;
import com.example.rentmotor.database.databasepenyewa;
import com.example.rentmotor.database.datapenyewa;
import com.example.rentmotor.DetailPesanan;
import com.example.rentmotor.editPenyewa;
//import com.example.rentmotor.editform;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class PenyewaAdapter extends RecyclerView.Adapter<PenyewaAdapter.PenyewaViewHolder>{
    private ArrayList<datapenyewa> listData;
    private Context control;

    public PenyewaAdapter(ArrayList<datapenyewa> listData) {
        this.listData = listData;
    }

    @Override
    public PenyewaAdapter.PenyewaViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_penyewa,parent,false);
        control = parent.getContext();
        return new PenyewaViewHolder(view);
    }

    @Override
    public void onBindViewHolder( PenyewaAdapter.PenyewaViewHolder holder, int position) {
        String nm,jiden,jpem,alamat,nt, tglp, jk, id;


        id = listData.get(position).getId();
        nm = listData.get(position).getNama();
        jiden = listData.get(position).getJidentitas();
        jpem = listData.get(position).getJpem();
        alamat = listData.get(position).getAlamat();
        nt = listData.get(position).getNotelp();
        tglp = listData.get(position).getTglPesan();
        jk = listData.get(position).getJk();
        databasepenyewa db = new databasepenyewa(control);


        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setTextSize(30);
        holder.namaTxt.setText(nm);
        holder.jidenTxt.setText(jiden);
        holder.jpemTxt.setText(jpem);
        holder.alamtTxt.setText(alamat);
        holder.ntTxt.setText(nt);
        holder.tglpTxt.setText(tglp);
        holder.jkTxt.setText(jk);

        holder.cardku.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(control, holder.cardku);
                popupMenu.inflate(R.menu.popupmenu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.ppdetail:
                                Intent i = new Intent (control, DetailPesanan.class);
                                i.putExtra("id",id);
                                i.putExtra("Nama",nm);
                                i.putExtra("Jidentitas",jiden);
                                i.putExtra("Jpem",jpem);
                                i.putExtra("Alamat",alamat);
                                i.putExtra("Notelp",nt);
                                i.putExtra("TglPesan",tglp);
                                i.putExtra("Jk",jk);
                                control.startActivity(i);
                                break;
                            case R.id.ppedit:
                                Intent j = new Intent (control, editPenyewa.class);
                                j.putExtra("id",id);
                                j.putExtra("Nama",nm);
                                j.putExtra("Jidentitas",jiden);
                                j.putExtra("Jpem",jpem);
                                j.putExtra("Alamat",alamat);
                                j.putExtra("Notelp",nt);
                                j.putExtra("TglPesan",tglp);
                                j.putExtra("Jk",jk);
                                control.startActivity(j);
                                break;
                            case R.id.ppHapus:
                                HashMap<String,String> values = new HashMap<>();
                                values.put("id",id);
                                db.DeleteData(values);
                                Intent h = new Intent(control, DaftarPenyewa.class);
                                control.startActivity(h);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

    public class PenyewaViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namaTxt,jidenTxt,jpemTxt,alamtTxt,ntTxt,tglpTxt,jkTxt;
        public PenyewaViewHolder(View view) {
            super(view);
            cardku = (CardView) itemView.findViewById(R.id.kartuku);
            namaTxt = (TextView) view.findViewById(R.id.textNama);
            jidenTxt = (TextView) view.findViewById(R.id.textJidentitas);
            jpemTxt = (TextView) view.findViewById(R.id.textJpem);
            alamtTxt = (TextView) view.findViewById(R.id.textAlamat);
            ntTxt = (TextView) view.findViewById(R.id.textNotelp);
            tglpTxt = (TextView) view.findViewById(R.id.textTglPesan);
            jkTxt = (TextView) view.findViewById(R.id.textJK);
        }
    }
}

