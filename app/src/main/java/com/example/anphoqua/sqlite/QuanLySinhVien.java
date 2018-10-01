package com.example.anphoqua.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuanLySinhVien extends SQLiteOpenHelper {

    public QuanLySinhVien(Context context){
        super(context, "quanlysinhvien", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
        create table sinhvien
        (
        _id integer primary key autoincrement,
        tensv text,
        tuoisv integer

        )
         */

        String chuoi = "create table sinhvien " +
                "( " +
                "_id integer primary key autoincrement, " +
                "tensv text, " +
                "tuoisv integer " +
                ")";
        sqLiteDatabase.execSQL(chuoi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists sinhvien");
        onCreate(sqLiteDatabase);
    }

    public void themSinhVien(String tensv, int tuoisv)
    {
        SQLiteDatabase database = getWritableDatabase();

        //insert into sinhvien(ten,tuoi) value ('an', 5);

        ContentValues values = new ContentValues();
        values.put("tensv", tensv);
        values.put("tuoisv",tuoisv);
        database.insert("sinhvien", null, values);
    }

    public String xemSinhVien()
    {
        String chuoi = "";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from sinhvien", null);

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String tensv = cursor.getString(1);
                int tuoi = cursor.getInt(2);
                chuoi += id + " " +tensv+ " " +tuoi+ "\n";
            } while (cursor.moveToNext());
        }
        return chuoi;
    }
}
