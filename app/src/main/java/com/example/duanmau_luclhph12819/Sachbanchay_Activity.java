package com.example.duanmau_luclhph12819;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.duanmau_luclhph12819.adapter.BookAdapter;
import com.example.duanmau_luclhph12819.dao.SachDao;
import com.example.duanmau_luclhph12819.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class Sachbanchay_Activity extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    ListView lvBook;
    BookAdapter adapter = null;
    SachDao sachDAO;
    EditText edThang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sachbanchay_);
        setTitle("TOP 10 SÁCH BÁN CHẠY");
        lvBook = (ListView) findViewById(R.id.lvBookTop);
        edThang = (EditText) findViewById(R.id.edThang);
    }

    public void VIEW_SACH_TOP_10(View view) {
        if (Integer.parseInt(edThang.getText().toString()) > 13 ||
                Integer.parseInt(edThang.getText().toString()) < 0) {
            Toast.makeText(getApplicationContext(), "Không đúng định dạng tháng (1- 12)", Toast.LENGTH_SHORT).show();
        } else {
            sachDAO = new SachDao(Sachbanchay_Activity.this);
            dsSach = sachDAO.getSachTop10(edThang.getText().toString());
            adapter = new BookAdapter(this, dsSach);
            lvBook.setAdapter(adapter);
        }
    }
}