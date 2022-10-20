package com.example.asm_mob201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.asm_mob201.adapter.DataAdapter;
import com.example.asm_mob201.dao.TaiKhoanDAO;
import com.example.asm_mob201.dto.TaiKhoan;

import java.util.ArrayList;

public class DanhSachTKActivity extends AppCompatActivity {
    ListView lv_tk;
    TaiKhoanDAO dao;
    ArrayList<TaiKhoan> ds=new ArrayList<TaiKhoan>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_tkactivity);
        lv_tk = findViewById(R.id.lv_tk);

        Intent intent = this.getIntent();
        String user= intent.getStringExtra("user");
        String pass= intent.getStringExtra("pass");

        dao = new TaiKhoanDAO(getBaseContext());
        ds = dao.getALL();
        DataAdapter adapter = new DataAdapter(this, ds);
        lv_tk.setAdapter(adapter);


//        ArrayList<String> list = new ArrayList<String>();
//        ArrayList<String> list_user = new ArrayList<String>();
//        ArrayList<String> list_pass = new ArrayList<String>();
//        list_user = dao.getName();

//        list.add(user+"\n"+pass);
//        list.add("namntph28279\n28012003");
//        list.add("thanhnamnguyennb@gmail.com\n28012003");

//        ArrayAdapter adapter = new ArrayAdapter(DanhSachTKActivity.this, android.R.layout.simple_list_item_1, list_user);
//        lv_tk.setAdapter(adapter);
    }
}