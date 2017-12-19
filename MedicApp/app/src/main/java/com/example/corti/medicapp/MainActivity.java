package com.example.corti.medicapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



    public class MainActivity extends AppCompatActivity {

        private EditText nombre,contraseña;
        private Button boton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            nombre= (EditText)findViewById(R.id.etNombre);
            contraseña=(EditText)findViewById(R.id.etContraseña);
            boton=(Button)findViewById(R.id.btAceptar);

        }
    //este metodo verifica que la contraseña este bien al igual que el nombre de usuario del doctor
        public void aceptar(View v){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "MedicApp",null,1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String contr,email;
            email=nombre.getText().toString();
            contr=contraseña.getText().toString();
            Cursor fila = bd.rawQuery("select nombre from doctor where email ='" + email+"' and contrasena='"+contr+"'",null);
            //mostramos los resultados en los mismos campos
            if(fila.moveToFirst()) {
                Intent intent = new Intent(com.example.corti.medicapp.MainActivity.this, Main2Activity.class);
                Bundle b = new Bundle();
                b.putString("email", nombre.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Ponga datos correctos",Toast.LENGTH_LONG).show();

            }
        }
    //este metodo hace redirect a la pagina para registrar doctores
        public void registrar(View v){
            Intent intent=new Intent(com.example.corti.medicapp.MainActivity.this,Main4Activity.class);
            startActivity(intent);
        }
    }


