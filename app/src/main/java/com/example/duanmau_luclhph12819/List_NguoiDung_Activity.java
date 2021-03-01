package com.example.duanmau_luclhph12819;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.duanmau_luclhph12819.adapter.NguoiDung_Adapter;
import com.example.duanmau_luclhph12819.dao.NguoiDungDao;
import com.example.duanmau_luclhph12819.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class List_NguoiDung_Activity extends AppCompatActivity {
    public static List<NguoiDung> dsNguoiDung = new ArrayList<>();
    ListView lvNguoiDung;
    NguoiDung_Adapter adapter = null;
    NguoiDungDao nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("NGƯỜI DÙNG");
        setContentView(R.layout.activity_list__nguoi_dung_);
        lvNguoiDung = (ListView) findViewById(R.id.lvNguoiDung);
        nguoiDungDAO = new NguoiDungDao(List_NguoiDung_Activity.this);
        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();
        adapter = new NguoiDung_Adapter(this, dsNguoiDung);
        lvNguoiDung.setAdapter(adapter);
        lvNguoiDung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new
                        Intent(List_NguoiDung_Activity.this, NguoiDungDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("USERNAME", dsNguoiDung.get(position).getUserName());
                b.putString("PHONE", dsNguoiDung.get(position).getPhone());
                b.putString("FULLNAME", dsNguoiDung.get(position).getHoTen());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        lvNguoiDung.setOnItemLongClickListener(new
                                                       AdapterView.OnItemLongClickListener() {
                                                           @Override
                                                           public boolean onItemLongClick(AdapterView<?> parent, View view, int
                                                                   position, long id) {
                                                               return false;
                                                           }
                                                       });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dsNguoiDung.clear();
        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();
        adapter.changeDataset(nguoiDungDAO.getAllNguoiDung());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.themNguoiDung:
                intent = new
                        Intent(List_NguoiDung_Activity.this, NguoiDungActivity.class);
                startActivity(intent);
                return (true);
            case R.id.ChangePass:
                intent = new
                        Intent(List_NguoiDung_Activity.this, doiMatKhau_Activity.class);
                startActivity(intent);
                return (true);
            case R.id.dangxuat:
                SharedPreferences pref =
                        getSharedPreferences("USER_FILE", MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                //xoa tinh trang luu tru truoc do
                edit.clear();
                edit.commit();
                intent = new Intent(List_NguoiDung_Activity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}