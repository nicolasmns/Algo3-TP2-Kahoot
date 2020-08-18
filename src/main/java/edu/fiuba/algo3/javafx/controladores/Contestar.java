package edu.fiuba.algo3.javafx.controladores;

import edu.fiuba.algo3.javafx.vistas.VistaJuego;
import edu.fiuba.algo3.javafx.vistas.VistaPregunta;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Contestar implements EventHandler<ActionEvent> {
    private Timeline contadorPantallaActual;
    private VistaPregunta ventana;
    public Contestar(Timeline contadorPantallaActual, VistaPregunta ventana){
        this.contadorPantallaActual = contadorPantallaActual;
        this.ventana = ventana;
    }
    @Override
    public void handle(ActionEvent e) {
        contadorPantallaActual.jumpTo(Duration.millis(30001));
    }
}
