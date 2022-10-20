package com.example.asm_mob201.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static final  String dbName = "PNLIB";
    static final int dbVersion = 1;

    public DbHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crTK = " create table taiKhoan(" +
                "maTk integer primary key autoincrement," +
                "tenDangNhap text not null," +
                "matKhau text not null)";
        db.execSQL(crTK);

        String crMusic = " create table music(" +
                "id integer primary key autoincrement," +
                "name text not null," +
                "path text not null)";
        db.execSQL(crMusic);

        String crBookMark = " create table bookMark(" +
                "idBM integer primary key autoincrement," +
                "maTk integer REFERENCES taiKhoan(maTk) )";
        db.execSQL(crBookMark);

        String insertMusic = "INSERT INTO music VALUES ( null ,'bai hat 1','/storage/emulated/0/Download/y2mate.com' )";
        db.execSQL(insertMusic);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTK = "drop table if exists taiKhoan";
        db.execSQL(dropTK);
        String dropBM = "drop table if exists music";
        db.execSQL(dropTK);
        String dropMS = "drop table if exists bookMark";
        db.execSQL(dropTK);

    }
}
