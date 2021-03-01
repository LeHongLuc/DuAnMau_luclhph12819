package com.example.duanmau_luclhph12819;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.duanmau_luclhph12819.adapter.CartAdapter;
import com.example.duanmau_luclhph12819.dao.HoaDonChiTietDao;
import com.example.duanmau_luclhph12819.model.HoaDonChiTiet;

import java.util.ArrayList;
import java.util.List;

public class List_HDCT_Activity extends AppCompatActivity {
    public List<HoaDonChiTiet> dsHDCT = new ArrayList<>();
    ListView lvCart;
    CartAdapter adapter = null;
    HoaDonChiTietDao hoaDonChiTietDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__h_d_c_t_);
        setTitle("HOÁ ĐƠN CHI TIẾT");
        lvCart = (ListView) findViewById(R.id.lvHoaDonChiTiet);
        hoaDonChiTietDAO = new HoaDonChiTietDao(List_HDCT_Activity.this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            dsHDCT =
                    hoaDonChiTietDAO.getAllHoaDonChiTietByID(b.getString("MAHOADON"));
        }
        adapter = new CartAdapter(this, dsHDCT);
        lvCart.setAdapter(adapter);
    }
}