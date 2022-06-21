package com.example.rentmotor.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;


public class databasepenyewa extends SQLiteOpenHelper {
    public databasepenyewa(Context context) {
        super(context, "Databasepenyewa", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table userrent (id integer primary key, Nama text, Jidentitas text, Jpem text, Alamat text, Notelp text, TglPesan text, Jk text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists userrent");
        onCreate(db);

    }

    public void insertData(HashMap<String,String> queryValues){
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("Nama",queryValues.get("Nama"));
        nilai.put("Jidentitas",queryValues.get("Jidentitas"));
        nilai.put("Jpem",queryValues.get("Jpem"));
        nilai.put("Alamat",queryValues.get("Alamat"));
        nilai.put("Notelp",queryValues.get("Notelp"));
        nilai.put("TglPesan",queryValues.get("TglPesan"));
        nilai.put("Jk",queryValues.get("Jk"));
        basisdata.insert("userrent",null,nilai);
        basisdata.close();
    }

    public void UpdateData(HashMap<String,String> queryValues){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("Nama",queryValues.get("Nama"));
        nilai.put("Jidentitas",queryValues.get("Jidentitas"));
        nilai.put("Jpem",queryValues.get("Jpem"));
        nilai.put("Alamat",queryValues.get("Alamat"));
        nilai.put("Notelp",queryValues.get("Notelp"));
        nilai.put("TglPesan",queryValues.get("TglPesan"));
        nilai.put("Jk",queryValues.get("Jk"));
        db.update("userrent", nilai,"id=?",new String[]{queryValues.get("id")});
        db.close();
    }

    public void DeleteData(HashMap<String,String> queryValue){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("userrent","id=?",new String[]{queryValue.get("id")});
        db.close();
    }

    public ArrayList<HashMap<String,String>> getAllPenyewa(){
        ArrayList<HashMap<String,String>> daftarPenyewa;
        daftarPenyewa = new ArrayList<>();
        String selectQuery = "Select * from userrent";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("Nama", cursor.getString(1));
                map.put("Jidentitas", cursor.getString(2));
                map.put("Jpem", cursor.getString(3));
                map.put("Alamat", cursor.getString(4));
                map.put("Notelp", cursor.getString(5));
                map.put("TglPesan", cursor.getString(6));
                map.put("Jk", cursor.getString(7));
                daftarPenyewa.add(map);
            }while (cursor.moveToNext());
        }
        db.close();
        return daftarPenyewa;
    }

}
