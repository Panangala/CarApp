package com.isuru.carapp_4662580_4662584;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context) {
        super(context, "Garage.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table car(Brand TEXT, Model TEXT, Price TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists car");

    }

    public boolean insertdata(String Brand, String Model, String Price){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Brand",Brand);
        contentValues.put("Model",Model);
        contentValues.put("Price",Price);
        long result = DB.insert("car",null,contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
            
        }
    }
}
