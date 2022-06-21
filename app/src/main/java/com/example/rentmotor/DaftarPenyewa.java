package com.example.rentmotor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.rentmotor.adapter.PenyewaAdapter;
import com.example.rentmotor.database.datapenyewa;
import com.example.rentmotor.database.databasepenyewa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class DaftarPenyewa extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PenyewaAdapter adapter;
    private ArrayList<datapenyewa> PenyewaArrayList;
    databasepenyewa controller = new databasepenyewa(this);
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_penyewa);

        recyclerView = findViewById(R.id.recyclerView);
        btnBack = findViewById(R.id.dfback);
        BacaData();
        adapter = new PenyewaAdapter(PenyewaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DaftarPenyewa.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaftarPenyewa.this,Mainmenu.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData(){
        ArrayList<HashMap<String,String>> daftarPenyewa = controller.getAllPenyewa();
        PenyewaArrayList = new ArrayList<>();
        //memindah dari hasil query ke dalam DaftarPenyewa
        for (int i=0;i<daftarPenyewa.size();i++){
            datapenyewa dv = new datapenyewa();

            dv.setId(daftarPenyewa.get(i).get("id").toString());
            dv.setNama(daftarPenyewa.get(i).get("Nama").toString());
            dv.setJidentitas(daftarPenyewa.get(i).get("Jidentitas").toString());
            dv.setJpem(daftarPenyewa.get(i).get("Jpem").toString());
            dv.setAlamat(daftarPenyewa.get(i).get("Alamat").toString());
            dv.setNotelp(daftarPenyewa.get(i).get("Notelp").toString());
            dv.setTglPesan(daftarPenyewa.get(i).get("TglPesan").toString());
            dv.setJk(daftarPenyewa.get(i).get("Jk").toString());
            //pindahkan dari DataVaksin kedalam ArrayList teman di adapter
            PenyewaArrayList.add(dv);
        }
    }

}