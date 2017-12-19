package com.example.corti.medicapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by corti on 18/12/2017.
 */

public class InterfazBD {

    AdminSQLiteOpenHelper con;
    SQLiteDatabase db;

    public InterfazBD(Context context) {
        con = new AdminSQLiteOpenHelper(context, "MedicApp", null, 1);
    }

    public void open() throws SQLiteException {
        db = con.getWritableDatabase();
    }

    public void close() throws SQLiteException {
        con.close();
    }

    public long insertarDatos(String dato,String clave,String cuPaciente) {
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("claveNotas",clave);
        valores.put("nota", dato);
        valores.put("cu",cuPaciente);
        long clave1 = db.insert("Nota", null, valores);
        close();
        return clave1;
    }

    /*public void insertarDatosPrueba() {
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("datos", "hola");
        db.insert("tablaprueba", null, valores);
        valores.put("datos", "como");
        db.insert("tablaprueba", null, valores);
        valores.put("datos", "estas");
        db.insert("tablaprueba", null, valores);
    }*/

    /*public String traerDato(long clave) {
        open();
        String claveString = Long.toString(clave);
        String query = "select * from notas where claveNotas=" + claveString + ";";
        Cursor c = db.rawQuery(query, null);
        c.moveToNext();
        String res = c.getString(1);
        c.close();
        close();
        return res;
    }*/

    public Cursor traerDatos() {
        Cursor res = null;
        open();
        String query = "select * from notas";
        res = db.rawQuery(query, null);

        return res;
    }
}

