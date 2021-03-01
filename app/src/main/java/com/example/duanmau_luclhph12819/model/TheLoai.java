package com.example.duanmau_luclhph12819.model;

public class TheLoai {
    private String maTheLoai;
    private String tenTheLoai;
    private String mota;
    private int viTri;

    public TheLoai() {
    }


    public TheLoai(String maTheLoai, String tenTheLoai, String mota, int viTri) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.mota = mota;
        this.viTri = viTri;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getViTri() {
        return viTri;
    }

    public void setViTri(int viTri) {
        this.viTri = viTri;
    }

    @Override
    public String toString() {
        return "TheLoai{" +
                "maTheLoai='" + maTheLoai + '\'' +
                ", tenTheLoai='" + tenTheLoai + '\'' +
                ", mota='" + mota + '\'' +
                ", viTri=" + viTri +
                '}';
    }
}
