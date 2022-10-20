package com.example.asm_mob201.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.asm_mob201.database.DbHelper;
import com.example.asm_mob201.dto.TaiKhoan;

import java.util.ArrayList;

public class TaiKhoanDAO {

    Context context;
    DbHelper mSqlite;
    SQLiteDatabase msqLiteDatabase;


    public TaiKhoanDAO(Context context){
        this.context = context;
        mSqlite = new DbHelper(context);
        msqLiteDatabase = mSqlite.getWritableDatabase();
    }

    public boolean insertTK(String tk, String mk){

        ContentValues mvalues = new ContentValues();

        mvalues.put("tenDangNhap", tk);
        mvalues.put("matKhau", mk);

        long kq = msqLiteDatabase.insert("taiKhoan",null,mvalues);

        return (kq>0);
    }

    public ArrayList<TaiKhoan> getALL(){
        ArrayList<TaiKhoan> mArr = new ArrayList<>();

        Cursor c = msqLiteDatabase.query("taiKhoan",null,null,null,null,null,null);

        c.moveToFirst();
        while (c.isAfterLast()==false){

            TaiKhoan ls = new TaiKhoan();

            ls.setMaTk(c.getInt(0));
            ls.setTenDangNhap(c.getString(1));
            ls.setMatkhau(c.getString(2));

            c.moveToNext();
            mArr.add(ls);

        }

        c.close();
        return mArr;
    }


    public int checkLogin(String id ,String passsword){

        Cursor c = msqLiteDatabase.rawQuery("SELECT * FROM taiKhoan WHERE tenDangNhap='"+id+"' and matKhau= '"+passsword+"'  ",null);
        Log.d("Count",c.getCount()+"");
        c.moveToFirst();
       while ( !c.isAfterLast()){
           int  a = c.getInt(0);
           c.moveToNext();
           c.close();
           return a;
       }

        return -1;
    }
    public ArrayList<String> getId(){
        ArrayList<String> mArr = new ArrayList<>();
        Cursor c = msqLiteDatabase.rawQuery("SELECT * FROM taiKhoan",null);
        c.moveToFirst();

        while (c.isAfterLast()==false){

            TaiKhoan ls = new TaiKhoan();
            ls.setMaTk(c.getInt(0));
            int ma = ls.getMaTk();

            mArr.add(String.valueOf(ma));

            c.moveToNext();
        }

        c.close();
        return mArr;
    }
    public ArrayList<String> tenTK(){
        ArrayList<String> Arr = new ArrayList<>();
        Cursor c = msqLiteDatabase.rawQuery("SELECT * FROM taiKhoan",null);

        c.moveToFirst();
        while (c.isAfterLast()==false){
            String  x ="";
            TaiKhoan ls = new TaiKhoan();
            x = c.getString(2);
            Arr.add(x);
            c.moveToNext();
        }
        return Arr;
    }

    public ArrayList<String> getName(){
        ArrayList<String> Arr = new ArrayList<>();
        Cursor c = msqLiteDatabase.rawQuery("SELECT * FROM taiKhoan",null);

        c.moveToFirst();
        while (c.isAfterLast()==false){
            String  x ="";
            TaiKhoan ls = new TaiKhoan();
            x = c.getString(1);
            Arr.add(x);
            c.moveToNext();
        }
        return Arr;
    }

    public ArrayList<String> getMk(){
        ArrayList<String> Arr = new ArrayList<>();
        Cursor c = msqLiteDatabase.rawQuery("SELECT * FROM taiKhoan",null);

        c.moveToFirst();
        while (c.isAfterLast()==false){
            String  x ="";
            TaiKhoan ls = new TaiKhoan();
            x = c.getString(2);
            Arr.add(x);
            c.moveToNext();
        }
        return Arr;
    }

    public int delete(int id){
        int kq = msqLiteDatabase.delete("taiKhoan" ,"maTk=?",new String[]{String.valueOf(id)});
        if(kq<0){
            return -1;
        }else {
            return 1;
        }
    }


    public int update(TaiKhoan ls){
        ContentValues mValues = new ContentValues();

        mValues.put("tenDangNhap",ls.getTenDangNhap());
        mValues.put("matKhau",ls.getMatkhau());

        long kq =  msqLiteDatabase.update("taiKhoan",mValues,"maTk=?",new String[]{String.valueOf(ls.getMaTk())});
        if(kq<0){
            return -1;
        }else{
            return 1;
        }
    }

}