package com.example.usuario.misfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DatosPersonaFragment extends Fragment {


    private EditText nombre;
    private EditText apellido;
    public DatosPersonaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_datos_persona, container, false);

        nombre = view.findViewById(R.id.editText);
        apellido = view.findViewById(R.id.editText2);

        // Inflate the layout for this fragment
        return view;
    }
    public void renderData(Persona persona){
        nombre.setText(persona.getNombre());
        apellido.setText(persona.getApellido());
    }
}
