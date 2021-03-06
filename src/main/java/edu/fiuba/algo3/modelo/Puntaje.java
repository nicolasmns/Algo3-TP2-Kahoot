package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.modificadoresDePuntaje.Modificador;
import edu.fiuba.algo3.modelo.modificadoresDePuntaje.ModificadorStandard;

public class Puntaje {

    private int puntaje;
    private Modificador modificador;

    public Puntaje() {
        this.puntaje = 0;
        this.modificador = new ModificadorStandard();
    }

    public void modificarPuntaje(int puntos) {
        this.puntaje = modificador.modificarPuntos(puntos, this.puntaje);
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setModificador(Modificador modificador) {
        this.modificador = modificador;
    }

}