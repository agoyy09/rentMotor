package com.example.rentmotor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rentmotor.database.databasepenyewa;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class editPenyewa extends AppCompatActivity {
    TextInputEditText Nama, Jidentitas, Jpem, Alamat, Notelp, TglP, JK;
    Button Save;
    String nm,jidentitas,jpem,alamat,nt,tglp,jk,id;
    databasepenyewa controller = new databasepenyewa(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        Nama = findViewById(R.id.inputednama);
        Jidentitas = findViewById(R.id.inputedJaminan);
        Jpem = findViewById(R.id.inputedJampemesanan);
        Alamat = findViewById(R.id.inputedAlamat);
        Notelp = findViewById(R.id.inputednotelp);
        TglP = findViewById(R.id.inputedtanggalpemesanan);
        JK = findViewById(R.id.inputedPemilihanunit);
        Save = findViewById(R.id.buttonedit);

        id = getIntent().getStringExtra("id");
        nm = getIntent().getStringExtra("Nama");
        jidentitas = getIntent().getStringExtra("Jidentitas");
        jpem = getIntent().getStringExtra("Jpem");
        alamat = getIntent().getStringExtra("Alamat");
        nt = getIntent().getStringExtra("Notelp");
        tglp = getIntent().getStringExtra("TglPesan");
        jk = getIntent().getStringExtra("Jk");

        setTitle("Edit Data User");
        Nama.setText(nm);
        Jidentitas.setText(jidentitas);
        Jpem.setText(jpem);
        Alamat.setText(alamat);
        Notelp.setText(nt);
        TglP.setText(tglp);
        JK.setText(jk);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Nama.getText().equals("")||Jidentitas.getText().toString().equals("")||Jpem.getText().toString().equals("")||
                        Alamat.getText().toString().equals("") || Notelp.getText().toString().equals("") || TglP.getText().toString().equals("") ||
                        JK.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Mohon isi semua data terlebih dahulu!", Toast.LENGTH_SHORT).show();
                }else {
                    nm = Nama.getText().toString();
                    jidentitas = Jidentitas.getText().toString();
                    jpem = Jpem.getText().toString();
                    alamat = Alamat.getText().toString();
                    nt = Notelp.getText().toString();
                    tglp = TglP.getText().toString();
                    jk = JK.getText().toString();
                    HashMap<String,String> values = new HashMap<>();
                    values.put("id",id);
                    values.put("Nama",nm);
                    values.put("Jidentitas",jidentitas);
                    values.put("Jpem",jpem);
                    values.put("Alamat",alamat);
                    values.put("Notelp",nt);
                    values.put("TglPesan",tglp);
                    values.put("Jk",jk);
                    controller.UpdateData(values);
                    callData();
                }
            }
        });
    }

    private void callData() {
        Intent i = new Intent(editPenyewa.this,DaftarPenyewa.class);
        startActivity(i);
        finish();
    }
}
