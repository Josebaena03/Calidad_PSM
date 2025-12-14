package Controlador;

import Modelo.Jugador;
import Modelo.Partida;

public class ControladorAhorcado {

    private Jugador jugador1;
    private Jugador jugador2;

    public ControladorAhorcado() {
        this.jugador1 = new Jugador(1);
        this.jugador2 = new Jugador(2);
    }

    public void iniciarTorneo() {
        System.out.println("==========================================");
        System.out.println("   TORNEO DE AHORCADO: AL MEJOR DE 5");
        System.out.println("   (El primero en llegar a 3 victorias gana)");
        System.out.println("==========================================");
        
        int ronda = 1;

        while (jugador1.getVictorias() < 3 && jugador2.getVictorias() < 3) {
            
            Jugador retador = (ronda % 2 != 0) ? jugador1 : jugador2;
            Jugador adivinador = (ronda % 2 != 0) ? jugador2 : jugador1;

            System.out.println("\n################################");
            System.out.println("RONDA " + ronda + " | MARCADOR: J1 (" + jugador1.getVictorias() + ") - J2 (" + jugador2.getVictorias() + ")");
            System.out.println("################################");
            
            String palabra = retador.definirPalabraSecreta();
            
            Partida partidaActual = new Partida(palabra);
            
            jugarRonda(partidaActual, adivinador);

            if (partidaActual.haGanado()) {
                System.out.println("\n>>> ¡CORRECTO! El JUGADOR " + adivinador.getId() + " ha adivinado la palabra.");
                adivinador.sumarVictoria();
            } else {
                System.out.println("\n>>> ¡AHORCADO! El JUGADOR " + adivinador.getId() + " ha muerto.");
                System.out.println("La palabra era: " + partidaActual.getPalabraSecreta());
                System.out.println("Punto para el JUGADOR " + retador.getId());
                retador.sumarVictoria();
            }
            
            ronda++;
        }

        mostrarGanadorFinal();
    }

    private void jugarRonda(Partida partida, Jugador adivinador) {
        while (!partida.haGanado() && !partida.haPerdido()) {
            System.out.println("\nPalabra: " + partida.getProgresoVisual());
            System.out.println("Vidas restantes: " + partida.getVidas());
            
            char letra = adivinador.pedirLetra();
            
            if (partida.comprobarLetra(letra)) {
                System.out.println("-> ¡Bien! La letra está.");
            } else {
                System.out.println("-> ¡Mal! Pierdes una vida.");
            }
        }
    }

    private void mostrarGanadorFinal() {
        System.out.println("\n==========================================");
        System.out.println("          FIN DEL TORNEO");
        System.out.println("==========================================");
        if (jugador1.getVictorias() == 3) {
            System.out.println("¡FELICIDADES JUGADOR 1! ERES EL CAMPEÓN.");
        } else {
            System.out.println("¡FELICIDADES JUGADOR 2! ERES EL CAMPEÓN.");
        }
    }
}
