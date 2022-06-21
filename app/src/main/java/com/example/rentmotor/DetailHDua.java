package com.example.rentmotor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailHDua extends AppCompatActivity {
    Button btnH2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailmotorh2);

        btnH2 = findViewById(R.id.buttonh2);

        btnH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailHDua.this,formpemesanan.class);
                startActivity(intent);
            }
        });
    }
}
