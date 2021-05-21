package com.example.Dietapp.login;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    //llamamos al constructor
    public AdminSQLiteOpenHelper(Context context, String nombre, CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    //creamos la tabla
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(login text primary key, nombre text, apellido text, apellido2 text, contra text, email text unique, retoagua text)");
        db.execSQL("create table recetas(nombreReceta text primary key, calorias numeric)");
    }

    //borrar la tabla y crear la nueva tabla
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists usuarios");
        db.execSQL("drop table if exists recetas");
        db.execSQL("create table recetas(nombreReceta text primary key, calorias numeric)");
        db.execSQL("create table usuarios(login text primary key, nombre text, apellido text, apellido2 text, contra text, email text unique, retoagua text)");
    }
}