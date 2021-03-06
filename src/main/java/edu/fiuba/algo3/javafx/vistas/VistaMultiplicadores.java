package edu.fiuba.algo3.javafx.vistas;
import edu.fiuba.algo3.javafx.controladores.AccionNinguno;
import edu.fiuba.algo3.javafx.controladores.AccionMultiplicador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadoresDePuntaje.ModificadorMultiplicador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundFill;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VistaMultiplicadores {
    private Stage window;

    public VistaMultiplicadores(Stage stage){
        this.window = stage;
    }

    public void desplegar(Pregunta pregunta, Jugador jugador, VistaPregunta vistaPregunta){

        ArrayList<Button> botonesMultiplicador = new ArrayList<>();
        Label nombreJugadorLabel = new Label(jugador.verNombre() + " elige un multiplicador para esta pregunta");
        nombreJugadorLabel.setFont(new Font("Arial", 16));
        Efectos efectoBoton = new Efectos();
        Button ninguno = new Button("Ninguno");
        efectoBoton.agregarEfecto(ninguno);
        ninguno.setOnAction(new AccionNinguno(pregunta, vistaPregunta));


        int indiceMultiplicador = 2;
        ArrayList<ModificadorMultiplicador> multiplicadores = jugador.getMultiplicadores();
        for(ModificadorMultiplicador multiplicador: multiplicadores){
            Button botonMultiplicador = new Button("Activar multiplicador x" + indiceMultiplicador);
            efectoBoton.agregarEfecto(botonMultiplicador);
            botonMultiplicador.setOnAction(new AccionMultiplicador(pregunta, jugador, vistaPregunta, multiplicador));
            botonesMultiplicador.add(botonMultiplicador);
            indiceMultiplicador++;
            if(multiplicador.seUtilizo()){
                botonMultiplicador.setDisable(true);
            }
        }
        Label puntosActuales = new Label("Puntaje actual:"+ jugador.puntaje().getPuntaje());

        for(ModificadorMultiplicador multiplicador:jugador.getMultiplicadores()){
            if(multiplicador.seUtilizo()){

            }
        }

        VBox layoutMultiplicador = new VBox();
        layoutMultiplicador.setBackground(new Background(new BackgroundFill(Color.INDIANRED, CornerRadii.EMPTY, Insets.EMPTY)));
        layoutMultiplicador.getChildren().add(nombreJugadorLabel);
        layoutMultiplicador.getChildren().add(puntosActuales);
        for(Button boton: botonesMultiplicador){
            layoutMultiplicador.getChildren().add(boton);
        }
        layoutMultiplicador.getChildren().add(ninguno);

        layoutMultiplicador.setAlignment(Pos.CENTER);
        layoutMultiplicador.setSpacing(10);

        window.getScene().setRoot(layoutMultiplicador);
        window.sizeToScene();
        window.show();
    }

}