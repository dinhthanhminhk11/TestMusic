package com.example.asm_mob201.dto;

public class TaiKhoan {
    private int maTk;
    private String tenDangNhap;
    private String matkhau;

    public TaiKhoan() {
    }

    public TaiKhoan(int maTk, String tenDangNhap, String matkhau) {
        this.maTk = maTk;
        this.tenDangNhap = tenDangNhap;
        this.matkhau = matkhau;
    }

    public int getMaTk() {
        return maTk;
    }

    public void setMaTk(int maTk) {
        this.maTk = maTk;
    }


    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
