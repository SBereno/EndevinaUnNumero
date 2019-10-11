package com.example.endevinaunnumero;

public class Jugador {

    String nomJugador;
    int contadorIntents;

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


    public Jugador(String nomJugador, int contadorIntents) {
        this.nomJugador = nomJugador;
        this.contadorIntents = contadorIntents;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nomJugador='" + nomJugador + '\'' +
                ", contadorIntents=" + contadorIntents +
                '}';
    }
}
