package com.example.endevinaunnumero;

public class Jugador {

    String nomJugador = new String();
    int contadorIntents = 0;

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


    @Override
    public String toString() {
        return "Jugador{" +
                "nomJugador='" + nomJugador + '\'' +
                ", contadorIntents=" + contadorIntents +
                '}';
    }
}
