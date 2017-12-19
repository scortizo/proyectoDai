package com.example.corti.medicapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    private EditText nombre, emailD, contraseñaD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        emailD=(EditText) findViewById(R.id.etemail);
        contraseñaD=(EditText) findViewById(R.id.etcontraseña);
        nombre= (EditText)findViewById(R.id.etNombre);
    }
    public void limpiar(View v){
        nombre.setText("");
        emailD.setText("");
        contraseñaD.setText("");
    }
    //hacemos el alta de un paciente
    public void alta(View view){
        String nombre1,email1,contraseña1;
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"MedicApp",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        //asignamos cada edit text a un elemento del paciente
        email1=this.emailD.getText().toString();
        contraseña1=this.contraseñaD.getText().toString();
        nombre1=this.nombre.getText().toString();
        ContentValues registro= new ContentValues();


        registro.put("email",email1);
        registro.put("contrasena",contraseña1);
        registro.put("nombre",nombre1);
        long i= bd.insert("doctor",null,registro);
        if(i>0){
            limpiar(view);
            Toast.makeText(this, "se han cargado los datos del paciente", Toast.LENGTH_LONG).show();}
        else
            Toast.makeText(this, "nooooo  se han cargado los datos del paciente", Toast.LENGTH_LONG).show();

    }

}
