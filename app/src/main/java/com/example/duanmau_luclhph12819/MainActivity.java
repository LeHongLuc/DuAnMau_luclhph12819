package com.example.duanmau_luclhph12819;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void viewNguoiDung(View view) {
        intent = new Intent(MainActivity.this,List_NguoiDung_Activity.class);
        startActivity(intent);
    }

    public void viewTheLoai(View view) {
        intent = new Intent(MainActivity.this,List_TheLoai_Activity.class);
        startActivity(intent);
    }

    public void viewSach(View view) {
        intent = new Intent(MainActivity.this,List_Sach_Activity.class);
        startActivity(intent);
    }

    public void viewHoaDon(View view) {
        intent = new Intent(MainActivity.this,List_HoaDon_Activiti.class);
        startActivity(intent);
    }

    public void viewSachBanChay(View view) {
        intent = new Intent(MainActivity.this,Sachbanchay_Activity.class);
        startActivity(intent);
    }

    public void viewThongKe(View view) {
        intent = new Intent(MainActivity.this,ThongKeDoanhThuActivity.class);
        startActivity(intent);
    }
}