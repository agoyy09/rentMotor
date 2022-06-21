package com.example.rentmotor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edname, edpassword;
    String name, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.buttonLogin);
        edname = findViewById(R.id.editTextTextPersonName);
        edpassword = findViewById(R.id.editTextTextPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edname.getText().toString();

                password = edpassword.getText().toString();

                if (name.equals("agoy") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();

                    Bundle bundle = new Bundle();

                    bundle.putString("a",name.trim());

                    bundle.putString("b",password.trim());

                    Intent i = new Intent(getApplicationContext(), Mainmenu.class);

                    i.putExtras(bundle);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this, "Nama dan Password Salah", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}