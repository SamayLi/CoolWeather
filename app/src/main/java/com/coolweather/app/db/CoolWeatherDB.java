package com.coolweather.app.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dysis on 2015/5/5.
 */
public class CoolWeatherDB {
    public static final String DB_NAME="cool_weather";

    public static final int VERSION=1;

    private static CoolWeatherDB coolWeatherDB;

    private SQLiteDatabase db;

    public CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper coolWeatherOpenHelper=new CoolWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db=coolWeatherOpenHelper.getWritableDatabase();
    }

    public  synchronized static CoolWeatherDB getInstance(Context context){
        if(coolWeatherDB==null){
            coolWeatherDB=new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    public void saveProvince(Province province){
        if(province!=null){
            ContentValues contentValues=new ContentValues();
            contentValues.put("province_name",province.getProvinceName());
            contentValues.put("province_code",province.getProvinceCode());
            db.insert("Province",null,contentValues);
        }
    }

    public List<Province> loadProvinces(){
        List<Province> list=new ArrayList<Province>();
        Cursor cursor=db.query("Province",null,null,null,null,null,null);
        if(cursor.moveToNext()){
            do {
                Province province = new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                list.add(province);
            }while (cursor.moveToNext());
        }
        if(cursor!=null){
            cursor.close();
        }
        return list;
    }


    public void saveCity(City city){
        if(city!=null){
            ContentValues contentValues=new ContentValues();
            contentValues.put("city_name",city.getCityName());
            contentValues.put("city_code",city.getCityCode());
            db.insert("City",null,contentValues);
        }
    }

    public List<City> loadCity(){
        List<City> list=new ArrayList<City>();
        Cursor cursor=db.query("City",null,null,null,null,null,null);
        if(cursor.moveToNext()){
            do {
                City city = new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                list.add(city);
            }while (cursor.moveToNext());
        }
        if(cursor!=null){
            cursor.close();
        }
        return list;
    }


    public void saveCounty(County county){
        if(county!=null){
            ContentValues contentValues=new ContentValues();
            contentValues.put("county_name",county.getCountyName());
            contentValues.put("county_code",county.getCountyCode());
            db.insert("County",null,contentValues);
        }
    }

    public List<County> loadCounty(){
        List<County> list=new ArrayList<County>();
        Cursor cursor=db.query("County",null,null,null,null,null,null);
        if(cursor.moveToNext()){
            do {
                County county = new County();
                county.setId(cursor.getInt(cursor.getColumnIndex("id")));
                county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
                county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
                list.add(county);
            }while (cursor.moveToNext());
        }
        if(cursor!=null){
            cursor.close();
        }
        return list;
    }
}
