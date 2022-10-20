package com.example.asm_mob201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.asm_mob201.dao.TaiKhoanDAO;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnDK;
    TextInputEditText inputEmail, inputPassword;
    TaiKhoanDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnDK = findViewById(R.id.btnDK);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        dao = new TaiKhoanDAO(getBaseContext());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                String pass = inputPassword.getText().toString();

                if(email.equalsIgnoreCase("") || pass.equalsIgnoreCase("")){
                    Toast.makeText(LoginActivity.this, "Chưa nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }else{
                    if(email.equalsIgnoreCase("namntph28279") && pass.equalsIgnoreCase("28012003")){
                        Intent i = new Intent(getBaseContext(), DanhSachTKActivity.class);
                        startActivity(i);
                    }else if(email.equalsIgnoreCase("thanhnamnguyennb@gmail.com") && pass.equalsIgnoreCase("28012003")){
                        Intent i = new Intent(getBaseContext(), DanhSachTKActivity.class);
                        startActivity(i);
                    }else if(dao.checkLogin(email, pass)>0){
                        Intent i = new Intent(LoginActivity.this, DanhSachTKActivity.class);
                        i.putExtra("user", email);
                        i.putExtra("pass", pass);
                        startActivity(i);
                    }
                }
            }
        });

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), DangKyActivity.class);
                startActivity(i);
            }
        });
    }
}