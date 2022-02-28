import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import smellytrivial.Game;

public class TrivialTests {

    @Test
    public void crear_Game(){
        Game trivial = new Game();
    }
    @Test
    public void si_al_principio_saco_un_1_voy_a_casilla_1(){
        //Arrange
        Game sut = new Game();
        sut.agregar("María");
        sut.agregar("Juan");
        sut.tirarDado(1);
        String expected = "La nueva posicion de María es 1";

        //Act
        String actual = sut.nuevaPosicionJudador();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void si_no_llega_a_2_jugadores(){
        Game sut = new Game();
        sut.agregar("María");
        boolean expected = false;
        boolean actual = sut.esJugable();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void si_6_jugadores(){
        Game sut = new Game();
        sut.agregar("María");
        sut.agregar("Juan");
        sut.agregar("Luis");
        sut.agregar("Sergio");
        sut.agregar("Gabi");
        sut.agregar("Fernando");
        boolean expected = true;
        boolean actual = sut.esJugable();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void salir_de_la_casilla_de_castigo(){
        Game sut = new Game();
        sut.agregar("María");
        sut.agregar("Juan");
        sut.tirarDado(1);
        sut.respuestaIncorrecta();
        sut.tirarDado(1);
        sut.fueRespuestaCorrecta();
        sut.tirarDado(1);
        String expected = "La nueva posicion de María es 2";
        String actual = sut.nuevaPosicionJudador();
        Assertions.assertEquals(expected,actual);
    }
}