package com.example.rentmotor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rentmotor.database.databasepenyewa;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class formpemesanan extends AppCompatActivity {
    private TextInputEditText tNama, tJidentitas, tJPem, tAlamat, tNotelp, tTglPesan, tJK;
    private Button simpanBtn;
    String nm,jidentitas,jpem,alamat,notelp,tglpesan,jk;
    databasepenyewa controller = new databasepenyewa(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpemesanan);

        tNama = (TextInputEditText) findViewById(R.id.inputnama);
        tJidentitas = (TextInputEditText) findViewById(R.id.inputJaminan);
        tJPem = (TextInputEditText) findViewById(R.id.inputJampemesanan);
        tAlamat = (TextInputEditText) findViewById(R.id.inputAlamat);
        tNotelp = (TextInputEditText) findViewById(R.id.inputnotelp);
        tTglPesan = (TextInputEditText) findViewById(R.id.inputtanggalpemesanan);
        tJK= (TextInputEditText) findViewById(R.id.inputPemilihanunit);
        simpanBtn = (Button) findViewById(R.id.buttonsave);


        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tNama.getText().equals("")||tJidentitas.getText().toString().equals("")||tJPem.getText().toString().equals("")||
                        tAlamat.getText().toString().equals("") || tNotelp.getText().toString().equals("") || tTglPesan.getText().toString().equals("") || tJK.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Mohon isi semua data!", Toast.LENGTH_SHORT).show();
                }else {
                    nm = tNama.getText().toString();
                    jidentitas = tJidentitas.getText().toString();
                    jpem = tJPem.getText().toString();
                    alamat = tAlamat.getText().toString();
                    notelp = tNotelp.getText().toString();
                    tglpesan = tTglPesan.getText().toString();
                    jk = tJK.getText().toString();

                    HashMap<String ,String> qvalues = new HashMap<>();
                    qvalues.put("Nama",nm);
                    qvalues.put("Jidentitas",jidentitas);
                    qvalues.put("Jpem",jpem);
                    qvalues.put("Alamat",alamat);
                    qvalues.put("Notelp",notelp);
                    qvalues.put("TglPesan",tglpesan);
                    qvalues.put("Jk",jk);

                    controller.insertData(qvalues);
                    callHome();

                }
            }
        });

    }

    public void callHome(){
        Intent intent = new Intent(formpemesanan.this,DaftarPenyewa.class);
        startActivity(intent);
        finish();
    }

}