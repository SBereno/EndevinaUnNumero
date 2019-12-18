package com.example.endevinaunnumero;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class JugadorAdapter extends ArrayAdapter<Jugador> {

    public JugadorAdapter(Context c, ArrayList<Jugador> jugadors){
        super(c, 0, jugadors);
    }

    public View getView(int position, View view, ViewGroup parent) {
        final Jugador jugador = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.lista, parent, false);
        }

        TextView nom = view.findViewById(R.id.nomRanking);
        TextView intents = view.findViewById(R.id.intentsRanking);
        ImageView fotoPerfil = view.findViewById(R.id.fotoPerfil);

        // Li fiquem text a cada posicio del listView
        fotoPerfil.setImageURI(jugador.getFotoPerfil());
        nom.setText("Nombre: " + jugador.getNomJugador());
        intents.setText("Intentos: " + String.valueOf(jugador.getContadorIntents()));
        return view;
    }
}
