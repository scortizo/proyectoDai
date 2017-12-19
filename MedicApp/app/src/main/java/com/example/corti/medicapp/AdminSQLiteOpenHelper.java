package com.example.corti.medicapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by corti on 18/12/2017.
 */
// esto crea la base de datos con los metodos de onCreate y on Upgrade
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table doctor(email text primary key ,contrasena text ,nombre text )");
        sqLiteDatabase.execSQL("create table pacientes(cu integer primary key,nombre text, emailP text, fechaNacimiento text, sexo text, tipoSangre text,telefono text, domicilio text,email references doctor)");
        sqLiteDatabase.execSQL("create table notas(claveNotas text primary key, nota text, cu text references pacientes)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists pacientes");
        sqLiteDatabase.execSQL("create table pacientes(cu integer primary key,nombre text, emailP text, fechaNacimiento text, sexo text, tipoSangre text,telefono text, domicilio text)");
        sqLiteDatabase.execSQL("drop table if exists doctor");
        sqLiteDatabase.execSQL("create table doctor(email text primary key ,contrasena text,nombre text)");
        sqLiteDatabase.execSQL("drop table if exists notas");
        sqLiteDatabase.execSQL("create table notas (cu text primary key, nota text, cu text references pacientes,email text references doctor)");
    }


  /* public void onCreate(SQLiteDatabase sqLiteDatabase) {
       /* sqLiteDatabase.execSQL("drop table if exists pacientes");
        sqLiteDatabase.execSQL("create table pacientes(cu integer primary key,nombre text, email text, fechaNacimiento text, sexo text, tipoSangre text,telefono text, domicilio text)");
        sqLiteDatabase.execSQL("drop table if exists doctor");
        sqLiteDatabase.execSQL("create table doctor(email text primary key ,contrasena text,nombre text)");
        sqLiteDatabase.execSQL("drop table if exists notas");
        sqLiteDatabase.execSQL("create table notas (cu text primary key, nota text, cu text references pacientes,email text references doctor)");
       /* sqLiteDatabase.execSQL("create table doctor(email text primary key ,contrasena text ,nombre text )");
        sqLiteDatabase.execSQL("create table pacientes(cu integer primary key,nombre text, email text, fechaNacimiento text, sexo text, tipoSangre text,telefono text, domicilio text)");
        sqLiteDatabase.execSQL("create table notas(cu text primary key, nota text, cu text references pacientes, email text references doctor)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       /* sqLiteDatabase.execSQL("drop table if exists pacientes");
        sqLiteDatabase.execSQL("create table pacientes(cu integer primary key,nombre text, email text, fechaNacimiento text, sexo text, tipoSangre text,telefono text, domicilio text)");
        sqLiteDatabase.execSQL("drop table if exists doctor");
        sqLiteDatabase.execSQL("create table doctor(email text primary key ,contrasena text,nombre text)");
        sqLiteDatabase.execSQL("drop table if exists notas");
        sqLiteDatabase.execSQL("create table notas (cu text primary key, nota text, cu text references pacientes,email text references doctor)");


    }*/
}

