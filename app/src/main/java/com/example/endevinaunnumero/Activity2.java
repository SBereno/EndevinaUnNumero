package com.example.endevinaunnumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Activity2 extends AppCompatActivity {

    static List<Jugador> jugadors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        leerArchivo();
        mostrarDatos();

    }

    public void leerArchivo() {
        jugadors = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("HallOfFame.txt")));
            String linea;
            while ((linea=br.readLine())!=null){
                String[] cadena = linea.split("-");
                jugadors.add(new Jugador(cadena[0],Integer.parseInt(cadena[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
