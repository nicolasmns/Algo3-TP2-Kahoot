package edu.fiuba.algo3.modelo.puntaje;

import edu.fiuba.algo3.modelo.Multiplicador;

public class PuntajeConcreto implements Puntaje{

    private int puntaje;
    private Multiplicador multiplicador;

    public PuntajeConcreto() {
        this.puntaje = 0;
    }

    public void agregarPuntos(int puntos) {
            puntaje += puntos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setMultiplicador(Multiplicador multiplicador) {
        this.multiplicador = multiplicador;
    }
}
