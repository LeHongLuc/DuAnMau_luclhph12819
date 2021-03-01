package com.example.duanmau_luclhph12819.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.duanmau_luclhph12819.dao.HoaDonChiTietDao;
import com.example.duanmau_luclhph12819.dao.HoaDonDao;
import com.example.duanmau_luclhph12819.dao.NguoiDungDao;
import com.example.duanmau_luclhph12819.dao.SachDao;
import com.example.duanmau_luclhph12819.dao.TheLoaiDao;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoiDungDao.SQL_NGUOI_DUNG);
        db.execSQL(TheLoaiDao.SQL_THE_LOAI);
        db.execSQL(SachDao.SQL_SACH);
        db.execSQL(HoaDonDao.SQL_HOA_DON);
        db.execSQL(HoaDonChiTietDao.SQL_HOA_DON_CHI_TIET);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+NguoiDungDao.TABLE_NAME);
        db.execSQL("Drop table if exists "+TheLoaiDao.TABLE_NAME);
        db.execSQL("Drop table if exists "+SachDao.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoaDonDao.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoaDonChiTietDao.TABLE_NAME);
        onCreate(db);
    }
}
