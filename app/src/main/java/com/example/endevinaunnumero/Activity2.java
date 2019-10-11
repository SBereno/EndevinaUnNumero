package com.example.endevinaunnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Activity2 extends AppCompatActivity {

    static ArrayList<Jugador> jugadors = new ArrayList<Jugador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mostrarDatos();

    }

    public void mostrarDatos() {
        Collections.sort(jugadors, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador o1, Jugador o2) {
                return o1.getContadorIntents() - o2.getContadorIntents();
            }
        });
        ArrayAdapter<Jugador> itemsAdapter = new ArrayAdapter<Jugador>(this, android.R.layout.simple_list_item_1, jugadors);
        ListView hallOfFame = (ListView) findViewById(R.id.HallOfFame);
        hallOfFame.setAdapter(itemsAdapter);
    }
}
