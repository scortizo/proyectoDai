package com.example.corti.medicapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {
    private TextView tvNombre;
    private EditText paciente1;
    private String Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvNombre=(TextView)findViewById(R.id.tvNombre);
        paciente1=(EditText)findViewById(R.id.paciente);
        Bundle bundle=this.getIntent().getExtras();
        Nombre=bundle.get("email").toString();
        tvNombre.setText("Hola: "+Nombre);
    }
    //este metodo hace redirect a la pagina para agregar o modificar notas
    public void notas(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "MedicApp",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //recueperas la clave unica
        String nombre = paciente1.getText().toString();
        //select clave

        Cursor fila = bd.rawQuery("select cu from pacientes where nombre ='" + nombre+"'",null);
        //mostramos los resultados en los mismos campos
        if(fila.moveToFirst()){
            String cu=fila.getString(0);
            Intent intent1=new Intent(Main2Activity.this,Main5Activity.class);
            Bundle b1= new Bundle();
            b1.putString("email",Nombre);
            b1.putString("paciente",cu);
            intent1.putExtras(b1);
            startActivity(intent1);
        }
        else
            Toast.makeText(this, "no existe la persona en la base con esa nombre",Toast.LENGTH_LONG).show();
        bd.close();

    }
// este metodo te lleva a la pagina para agregar un paciente
    public void agregar(View v){
        Intent intent2=new Intent(Main2Activity.this,Main3Activity.class);
        Bundle b1= new Bundle();
        b1.putString("Nombre",Nombre);
        intent2.putExtras(b1);
        startActivity(intent2);
    }
//este metodo te lleva a la pagina donde hay medicinas para quepueda consultarlo el doctor
    public void medicinas(View v){
        String url="https://www.drugs.com/";
        WebView wbView=(WebView)findViewById(R.id.wbView);
        wbView.getSettings().setJavaScriptEnabled(true);
        wbView.loadUrl(url);
    }
}

