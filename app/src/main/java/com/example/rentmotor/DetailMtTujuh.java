package com.example.rentmotor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailMtTujuh extends AppCompatActivity {
    Button btnMT07;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailmt07);

        btnMT07 = findViewById(R.id.buttonmt07);

        btnMT07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailMtTujuh.this,formpemesanan.class);
                startActivity(intent);
            }
        });
    }
}
