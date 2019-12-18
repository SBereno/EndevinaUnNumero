package com.example.endevinaunnumero;

import android.net.Uri;

public class Jugador {

    String nomJugador;
    int contadorIntents;
    private Uri fotoPerfil;

    public String getNomJugador() {
        return nomJugador;
    }

    public void setNomJugador(String nomJugador) {
        this.nomJugador = nomJugador;
    }

    public int getContadorIntents() {
        return contadorIntents;
    }

    public void setContadorIntents(int contadorIntents) {
        this.contadorIntents = contadorIntents;
    }


    public Jugador(String nomJugador, int contadorIntents, Uri fotoPerfil) {
        this.nomJugador = nomJugador;
        this.contadorIntents = contadorIntents;
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {
        return "Jugador:" + nomJugador + ", Intents:" + contadorIntents;
    }

    public Uri getFotoPerfil(){
        return this.fotoPerfil;
    }
}
