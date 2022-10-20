package com.example.asm_mob201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm_mob201.dao.TaiKhoanDAO;
import com.example.asm_mob201.dto.TaiKhoan;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class DangKyActivity extends AppCompatActivity {
    Button btn_DK;
    TextInputEditText inputEmail_dk, inputPass_dk, inputPassNew;
    String user, pass, passNew;
    TaiKhoanDAO dao;
    TaiKhoan tk;
    ArrayList<TaiKhoan> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        btn_DK = findViewById(R.id.btn_DK);
        inputEmail_dk = findViewById(R.id.inputEmail_dk);
        inputPass_dk = findViewById(R.id.inputPassword_dk);
        inputPassNew = findViewById(R.id.inputPassworNew);
        dao = new TaiKhoanDAO(getBaseContext());

        btn_DK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = inputEmail_dk.getText().toString();
                pass = inputPass_dk.getText().toString();
                passNew = inputPassNew.getText().toString();

                if (user.equalsIgnoreCase("") || passNew.equalsIgnoreCase("") || pass.equalsIgnoreCase("")){
                    Toast.makeText(DangKyActivity.this, "Chua nhap du lieu", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equalsIgnoreCase(passNew)){
                        if(dao.insertTK(user, pass)){
                            Toast.makeText(DangKyActivity.this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(DangKyActivity.this, "Đăng Ký That Bai", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(DangKyActivity.this, "Mật Khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                    }




                }

            }
        });
    }
}