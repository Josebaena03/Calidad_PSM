package Modelo;

import java.util.Arrays;

public class Partida {

    private String palabraSecreta;
    private char[] progreso;
    private int vidas;
    
    public Partida(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.vidas = 6;
        
        this.progreso = new char[palabraSecreta.length()];
        Arrays.fill(this.progreso, '_');
    }

    public boolean comprobarLetra(char letra) {
        boolean acierto = false;
        
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progreso[i] = letra;
                acierto = true;
            }
        }
        
        if (!acierto) {
            vidas--; 
        }
        
        return acierto;
    }

    public boolean haGanado() {
        for (char c : progreso) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public boolean haPerdido() {
        return vidas <= 0;
    }

    public String getProgresoVisual() {
        StringBuilder resultado = new StringBuilder();
        for (char c : progreso) {
            resultado.append(c).append(" ");
        }
        return resultado.toString();
    }

    public int getVidas() {
        return vidas;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}
