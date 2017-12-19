package com.example.corti.medicapp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends Activity {
    private EditText clave,nombre,email,fecha,sexo,tiposangre,tel,domicilio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        clave=(EditText)findViewById(R.id.etclave);
        nombre=(EditText)findViewById(R.id.etNombre);
        email=(EditText)findViewById(R.id.etemail);
        fecha=(EditText)findViewById(R.id.etfecha);
        sexo=(EditText)findViewById(R.id.etsexo);
        tiposangre=(EditText)findViewById(R.id.etsangre);
        tel=(EditText)findViewById(R.id.telefono);
        domicilio=(EditText)findViewById(R.id.etdomicilio);
    }
    //limpiamos todos los edit text para que el doctor pueda hacer otra actividad
    public void limpiar(View v){
        clave.setText("");
        nombre.setText("");
        email.setText("");
        fecha.setText("");
        sexo.setText("");
        tiposangre.setText("");
        tel.setText("");
        domicilio.setText("");
    }
    //hacemos el alta de un paciente
    public void alta(View view){
        String clave1,nombre1,email1,fecha1,sexo1,tiposangre1,tel1,domicilio1;
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"MedicApp",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        //asignamos cada edit text a un elemento del paciente
        clave1=this.clave.getText().toString();
        nombre1=this.nombre.getText().toString();
        email1=this.email.getText().toString();
        fecha1=this.fecha.getText().toString();
        sexo1=this.sexo.getText().toString();
        tiposangre1=this.tiposangre.getText().toString();
        tel1=this.tel.getText().toString();
        domicilio1=this.domicilio.getText().toString();
        ContentValues registro= new ContentValues();
        registro.put("cu",clave1);
        registro.put("nombre",nombre1);
        registro.put("emailP",email1);
        registro.put("fechaNacimiento",fecha1);
        registro.put("sexo",sexo1);
        registro.put("tipoSangre",tiposangre1);
        registro.put("telefono",tel1);
        registro.put("domicilio",domicilio1);
        long i= bd.insert("pacientes",null,registro);
        if(i>0){
            limpiar(view);
            Toast.makeText(this, "se han cargado los datos del paciente", Toast.LENGTH_LONG).show();}
        else
            Toast.makeText(this, "Noooooo  se han cargado los datos del paciente", Toast.LENGTH_LONG).show();

    }

//este metodo sirve para consultar la informacion importante de el paciente con su clave iunica
    public void consulta (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "MedicApp",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //recueperas la clave unica
        String cu1 = clave.getText().toString();
        //select clave

        Cursor fila = bd.rawQuery("select nombre,email,fechaNacimiento,sexo,tipoSangre,telefono,domicilio from pacientes where cu =" + cu1,null);
        //mostramos los resultados en los mismos campos
        if(fila.moveToFirst()){
            nombre.setText(fila.getString(0));
            email.setText(fila.getString(1));
            fecha.setText(fila.getString(2));
            sexo.setText(fila.getString(3));
            tiposangre.setText(fila.getString(4));
            tel.setText(fila.getString(5));
            domicilio.setText(fila.getString(6));

        }
        else
            Toast.makeText(this, "no existe la persona en la base con esa clave unica",Toast.LENGTH_LONG).show();
        bd.close();
    }
    //este metodo elimina al paciente con la clave unica
    public void baja(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"MedicApp",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        String clave=this.clave.getText().toString();
        int cant=bd.delete("pacientes","cu="+clave,null);
        bd.close();
        if(cant==1){
            Toast.makeText(this,"se borró la persona con la calve pyuestasn",Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this,"no se borró la persona, no existe",Toast.LENGTH_LONG).show();
        limpiar(v);
    }


}

