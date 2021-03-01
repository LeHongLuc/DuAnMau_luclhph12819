package com.example.duanmau_luclhph12819;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau_luclhph12819.dao.NguoiDungDao;
import com.example.duanmau_luclhph12819.dao.TheLoaiDao;
import com.example.duanmau_luclhph12819.model.NguoiDung;
import com.example.duanmau_luclhph12819.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {
     TheLoaiDao theLoaiDao;
    EditText edMaTheLoai,edTentheloai,edViTri,edMota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        edMaTheLoai=findViewById(R.id.edMaTheLoai);
        edTentheloai=findViewById(R.id.edTentheloai);
        edViTri=findViewById(R.id.edViTri);
        edMota=findViewById(R.id.edMota);
    }
    public void showUsers(View view) {
        finish();
    }
    public void addTheLoai(View view) {
        theLoaiDao = new TheLoaiDao(TheLoaiActivity.this);
        TheLoai theloai1 = new TheLoai(edMaTheLoai.getText().toString(),
                edTentheloai.getText().toString(),edMota.getText().toString(),Integer.parseInt(edViTri.getText().toString()));
        try {

                if (theLoaiDao.updateTheLoai(theloai1) > 0) {
                    Toast.makeText(getApplicationContext(), "Thêm thành công",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại",
                            Toast.LENGTH_SHORT).show();
                }

        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }


}