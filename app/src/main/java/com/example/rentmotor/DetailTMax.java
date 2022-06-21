package com.example.rentmotor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailTMax extends AppCompatActivity {
    Button btnTMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailtmax);

        btnTMax = findViewById(R.id.buttontmax);

        btnTMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailTMax.this,formpemesanan.class);
                startActivity(intent);
            }
        });
    }
}
