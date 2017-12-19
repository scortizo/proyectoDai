package com.example.corti.medicapp;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends android.app.Fragment {
    /*String d;
    EditText dato,claveNota;
    InterfazBD iBD;
    FragmentManager fm;
    public BlankFragment() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public BlankFragment(String e) {
        d=e;
     //traemos la clave del paciente para hacer la nota
    }


    Button agregar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_blank, container, false);
        agregar = (Button) v.findViewById(R.id.botonAgregar);
        dato= (EditText) v.findViewById(R.id.Nota);
        claveNota=(EditText) v.findViewById(R.id.claveNota);
        fm = this.getActivity().getFragmentManager();

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= dato.getText().toString();
                String e=claveNota.getText().toString();
                iBD = new InterfazBD(v.getContext());
                //insertar dato en la bd
                long clave= iBD.insertarDatos(s,e,d);
                //mostrar la llave primaria del dato agregado
                Toast.makeText(v.getContext(),"llave es:"+clave, Toast.LENGTH_SHORT).show();
                FragmentTransaction ft= fm.beginTransaction();
                Fragment f1 = new FragmentoLista();

                ft.replace(R.id.actividadPrincipal,f1);
                ft.commit();


            }
        });





        return v;
    }*/

}
