package com.example.rentmotor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Mainmenu extends AppCompatActivity {
    ImageView ikh2,ikmt07,ikbmws,iktmax,imgfldr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        ikh2 = findViewById(R.id.ich2);
        ikmt07 = findViewById(R.id.icmt07);
        ikbmws = findViewById(R.id.icbmws);
        iktmax = findViewById(R.id.ictmax);
        imgfldr = findViewById(R.id.imgfolder);

        ikh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainmenu.this, DetailHDua.class);
                startActivity(intent);
            }
        });

        ikmt07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainmenu.this, DetailMtTujuh.class);
                startActivity(intent);
            }
        });

        ikbmws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainmenu.this, DetailBMWS.class);
                startActivity(intent);
            }
        });

        iktmax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainmenu.this, DetailTMax.class);
                startActivity(intent);
            }
        });

        imgfldr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainmenu.this,DaftarPenyewa.class);
                startActivity(intent);
            }
        });
    }
}