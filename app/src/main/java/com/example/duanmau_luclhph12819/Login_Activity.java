package com.example.duanmau_luclhph12819;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duanmau_luclhph12819.dao.NguoiDungDao;

public class Login_Activity extends AppCompatActivity {
    EditText edUserName, edPassword;
    Button btnLogin, btnCancel;
    CheckBox chkRememberPass;
    String strUser, strPass;
    NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        setTitle("ĐĂNG NHẬP");
        edUserName = (EditText) findViewById(R.id.edUserName);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        chkRememberPass = (CheckBox) findViewById(R.id.chkRememberPass);
        nguoiDungDao = new NguoiDungDao(Login_Activity.this);
        edPassword.setText("admin");
        edUserName.setText("admin");
    }

    public void checkLogin(View v) {
        strUser = edUserName.getText().toString();
        strPass = edPassword.getText().toString();
        if (strUser.isEmpty() || strPass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không được bỏ trống",
                    Toast.LENGTH_SHORT).show();
        } else {
            if (nguoiDungDao.checkLogin(strUser, strPass) > 0) {
                Toast.makeText(getApplicationContext(), "Login thanh cong", Toast.LENGTH_SHORT).show();
                finish();
            }
            if
            (strUser.equalsIgnoreCase("admin") && strPass.equalsIgnoreCase("admin")) {
                rememberUser(strUser, strPass, chkRememberPass.isChecked());
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không đúng",
                        Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(Login_Activity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    public void rememberUser(String u, String p, boolean status) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (!status) {
            //xoa tinh trang luu tru truoc do
            edit.clear();
        } else {
            //luu du lieu
            edit.putString("USERNAME", u);
            edit.putString("PASSWORD", p);
            edit.putBoolean("REMEMBER", status);
        }
        //luu lai toan bo
        edit.commit();
    }


}