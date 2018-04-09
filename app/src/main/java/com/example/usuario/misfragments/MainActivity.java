package com.example.usuario.misfragments;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements BotoneraFragment.CursorListener{

    private BotoneraFragment botoneraFragment;
    private DatosPersonaFragment datosPersonaFragment;
    private Persona persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botoneraFragment =(BotoneraFragment)getSupportFragmentManager().findFragmentById(R.id.botoneraFragment);
        datosPersonaFragment = (DatosPersonaFragment)getSupportFragmentManager().findFragmentById(R.id.datosPersonaFragment);

    }

    @Override
    public boolean MoveFirst() {


       persona= botoneraFragment.getPersonas().get(0);
       botoneraFragment.setIndice(0);
        datosPersonaFragment.renderData(persona);

        return true;
    }

    @Override
    public boolean MovePrevious() {
        int index = botoneraFragment.getIndice()-1;
        persona= botoneraFragment.getPersonas().get(index);
        botoneraFragment.setIndice(index);
        datosPersonaFragment.renderData(persona);
        return true;
    }

    @Override
    public boolean MoveNext() {
        int index = botoneraFragment.getIndice()+1;
        persona= botoneraFragment.getPersonas().get(index);
        botoneraFragment.setIndice(index);
        datosPersonaFragment.renderData(persona);
        return true;
    }

    @Override
    public boolean MoveLast() {
        persona= botoneraFragment.getPersonas().get(botoneraFragment.getPersonas().size()-1);
        datosPersonaFragment.renderData(persona);
        return true;
    }
}
