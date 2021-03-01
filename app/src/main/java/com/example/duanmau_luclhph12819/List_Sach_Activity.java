package com.example.duanmau_luclhph12819;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.duanmau_luclhph12819.adapter.BookAdapter;
import com.example.duanmau_luclhph12819.dao.SachDao;
import com.example.duanmau_luclhph12819.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class List_Sach_Activity extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    ListView lvBook;
    BookAdapter adapter = null;
    SachDao sachDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__sach_);
        setTitle("QUẢN LÝ SÁCH");
        lvBook = (ListView) findViewById(R.id.lvBook);
        sachDAO = new SachDao(List_Sach_Activity.this);
        dsSach = sachDAO.getAllSach();
        adapter = new BookAdapter(this, dsSach);
        lvBook.setAdapter(adapter);
        lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sach sach = (Sach) parent.getItemAtPosition(position);
                Intent intent = new
                        Intent(List_Sach_Activity.this,ThemSachActivity.class);
                Bundle b = new Bundle();
                b.putString("MASACH", sach.getMaSach());
                b.putString("MATHELOAI", sach.getMaTheLoai());
                b.putString("TENSACH", sach.getTenSach());
                b.putString("TACGIA", sach.getTacGia());
                b.putString("NXB", sach.getNXB());
                b.putString("GIABIA", String.valueOf(sach.getGiaBia()));
                b.putString("SOLUONG", String.valueOf(sach.getSoLuong()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        // TextFilter
        lvBook.setTextFilterEnabled(true);
        EditText edSeach = (EditText) findViewById(R.id.edSearchBook);
        edSeach.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
                System.out.println("Text [" + s + "] - Start [" + start + "] - Before [" + before + "] - Count [" + count + "]");
                if (count < before) {
                    adapter.resetData();
                }
                adapter.getFilter().filter(s.toString());
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.themSach:
                Intent intent = new
                        Intent(List_Sach_Activity.this,ThemSachActivity.class);
                startActivity(intent);
                return(true);
        }
        return super.onOptionsItemSelected(item);
    }
}