package com.example.rentmotor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailBMWS extends AppCompatActivity {
    Button btnBMWS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailbmws1000rr);

        btnBMWS = findViewById(R.id.buttonbmws);

        btnBMWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailBMWS.this,formpemesanan.class);
                startActivity(intent);
            }
        });
    }
}
