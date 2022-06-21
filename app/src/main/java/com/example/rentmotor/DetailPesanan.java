package com.example.rentmotor;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.rentmotor.database.databasepenyewa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailPesanan extends AppCompatActivity {

    TextView txNama, txJidentitas, txJpem,txAlamat, txNotelp, txTglP, txJK,txid;
    //protected Cursor cursor;
    String snm, snjidentitas, sjpem, salamat, snt, stglp, sjk,sid;
    databasepenyewa dbpenyewa = new databasepenyewa(this);
    private ImageView kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan);

        txid = findViewById(R.id.tvnoreff);
        txNama = findViewById(R.id.tvNama);
        txJidentitas = findViewById(R.id.tvJidentitas);
        txJpem = findViewById(R.id.tvJpesan);
        txAlamat = findViewById(R.id.tvAlamat);
        txNotelp = findViewById(R.id.tvnotelp);
        txTglP = findViewById(R.id.tvTglpesan);
        txJK = findViewById(R.id.tvJk);

        sid = getIntent().getStringExtra("id");
        snm = getIntent().getStringExtra("Nama");
        snjidentitas = getIntent().getStringExtra("Jidentitas");
        sjpem = getIntent().getStringExtra("Jpem");
        salamat = getIntent().getStringExtra("Alamat");
        snt = getIntent().getStringExtra("Notelp");
        stglp = getIntent().getStringExtra("TglPesan");
        sjk = getIntent().getStringExtra("Jk");

        setTitle("Detail Pemesanan");
        txid.setText(sid);
        txNama.setText(snm);
        txJidentitas.setText(snjidentitas);
        txJpem.setText(sjpem);
        txAlamat.setText(salamat);
        txNotelp.setText(snt);
        txTglP.setText(stglp);
        txJK.setText(sjk);

        kembali = (ImageView) findViewById(R.id.dpback);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailPesanan.this,DaftarPenyewa.class);
                startActivity(intent);
            }
        });

    }

}