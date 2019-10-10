package com.example.endevinaunnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    static ArrayList<Jugador> jugadors = new ArrayList<Jugador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mostrarDatos();

    }

    public void mostrarDatos() {
        for(Jugador jugador : jugadors) {
            System.out.println(jugador.toString());
        }
        ArrayAdapter<Jugador> itemsAdapter = new ArrayAdapter<Jugador>(this, android.R.layout.simple_list_item_1, jugadors);
        ListView hallOfFame = (ListView) findViewById(R.id.HallOfFame);
        hallOfFame.setAdapter(itemsAdapter);
    }
}
