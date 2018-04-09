package com.example.usuario.misfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BotoneraFragment extends Fragment {


    private Button primero;
    private Button anterior;
    private Button siguiente;
    private Button ultimo;
    private List<Persona> personas = new ArrayList<>();
    private CursorListener cursor;
    private int indice= 0;
    public BotoneraFragment() {
        // Required empty public constructor
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public List<Persona> getPersonas(){
        return personas;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            cursor = (CursorListener) context;
        }catch (Exception e){
            throw new ClassCastException("No se ha implementado la interfaz DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_botonera, container, false);
        personas.add(new Persona("pepe","mora"));
        personas.add(new Persona("antonio","mora"));
        personas.add(new Persona("juan","mora"));
        personas.add(new Persona("jose","mora"));
        personas.add(new Persona("carlos","mora"));
        personas.add(new Persona("pedro","mora"));
        primero = view.findViewById(R.id.Primero);
        anterior = view.findViewById(R.id.Anterior);
        siguiente = view.findViewById(R.id.Siguiente);
        ultimo = view.findViewById(R.id.Ultimo);

        primero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor.MoveFirst();
            }
        });
        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor.MovePrevious();
            }
        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor.MoveNext();
            }
        });
        ultimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor.MoveLast();
            }
        });
        return view;
    }

    public interface CursorListener{
        boolean MoveFirst();
        boolean MovePrevious();
        boolean MoveNext();
        boolean MoveLast();
    }
}
