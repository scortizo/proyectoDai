package com.example.corti.medicapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    private EditText clave, nota;
    private String paciente,email;
    @Override
    //Aqui recogemos el paciente del intent por que lo necesitamos para crear la nota
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Bundle bundle=this.getIntent().getExtras();
        email=bundle.get("email").toString();
        paciente=bundle.get("paciente").toString();
        clave=(EditText)findViewById(R.id.etclave) ;
        nota=(EditText)findViewById(R.id.etnota);
        //conseguimos la clave unica del paciente para ver sus notas


        /*
       FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment f1 = new FragmentoLista();
        ft.add(R.id.actividadPrincipal, f1);
        ft.commit();

       /* Fragment F2 = new BlankFragment(paciente);
        ft = fm.beginTransaction();
        ft.add(R.id.fragmento_agregar, F2);
        ft.commit();*/


    }
    //este metodo limpia los edittext
    public void limpiar(View v){
        clave.setText("");
        nota.setText("");

    }
    //este metodo da de alta la nota
    public  void alta(View v){
        String clave1,nota1,paciente1;
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this,"MedicApp",null,1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        //asignamos cada edit text a un elemento de la nota
        clave1=this.clave.getText().toString();
        nota1=this.nota.getText().toString();
        paciente1=paciente;


        ContentValues registro= new ContentValues();

        registro.put("ClaveNotas",clave1);
        registro.put("nota",nota1);
        registro.put("cu",paciente1);

        long i= bd.insert("notas",null,registro);
        if(i>0){
            limpiar(v);
            Toast.makeText(this, "se han cargado los datos de la nota", Toast.LENGTH_LONG).show();}
        else
            Toast.makeText(this, "Noooooo  se han cargado los datos del paciente", Toast.LENGTH_LONG).show();
    }
    //con este metodo se puede ver la nota con la clave unica que se proporcione
    public void ver(View v){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "MedicApp",null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            //recueperas la clave unica
            String cu1 = clave.getText().toString();
            //select clave
            Cursor fila = bd.rawQuery("select * from notas where claveNotas =" + cu1,null);
            //mostramos los resultados en los mismos campos
            if(fila.moveToFirst()){
                clave.setText(fila.getString(0));
                nota.setText(fila.getString(1));
            }
            else
                Toast.makeText(this, "no existe la nota en la base con esa clave unica",Toast.LENGTH_LONG).show();
            bd.close();
        }

    }

