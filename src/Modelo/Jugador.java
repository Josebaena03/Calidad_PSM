package Modelo;

import java.util.Scanner;

public class Jugador {
    private int id;
    private int victorias;
    private Scanner scanner;

    public Jugador(int id) {
        this.id = id;
        this.victorias = 0;
        this.scanner = new Scanner(System.in);
    }

    public int getId() {
        return id;
    }

    public int getVictorias() {
        return victorias;
    }

    public void sumarVictoria() {
        this.victorias++;
    }

    public String definirPalabraSecreta() {
        System.out.println("------------------------------------------------");
        System.out.println("TURNO DEL JUGADOR " + id + " (Retador)");
        System.out.print("Escribe la palabra secreta (sin espacios): ");
        
        String palabra = scanner.next().toUpperCase();
        
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        
        return palabra;
    }

    public char pedirLetra() {
        System.out.print("JUGADOR " + id + " (Adivinador) - Introduce una letra: ");
        return scanner.next().toUpperCase().charAt(0);
    }
}
