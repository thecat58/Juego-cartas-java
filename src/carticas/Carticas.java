/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carticas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author KIKE
 */
public class Carticas {

    /**
     * @param args the command line arguments
     */

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Baraja baraja = new Baraja();
        Historial historial = new Historial();
        ColaTurnos turnos = new ColaTurnos();
        HashMap<String, Jugador> jugadores = new HashMap<>();

        // creemos un trree para desiscione 
        Arbol.NodoDecision raiz = new Arbol.NodoDecision(17, "Plantarse");
        raiz.izquierda = new Arbol.NodoDecision(17, "dar");
        raiz.derecha = new Arbol.NodoDecision(17, "Plantarse");

        // crea la baraja del juego par ael casino 
        String[] palos = {"Corazones", "Diamantes", "Picas", "Tréboles"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        List<Carta> cartas = new ArrayList<>();
        for (String palo : palos)
            for (String valor : valores)
                cartas.add(new Carta(valor, palo));

        Collections.shuffle(cartas);
        for (Carta c : cartas) baraja.agregarCarta(c);

        // crut de jugador jeje
        System.out.println("Bienvenido a Blackjack versión consola");
        System.out.print("Ingrese su nombre: ");
        String nombreJugador = sc.nextLine();

        Jugador jugador = new Jugador(nombreJugador);
        Jugador dealer = new Jugador("Dealer");

        jugadores.put(nombreJugador, jugador);
        jugadores.put("Dealer", dealer);

        turnos.agregarJugador(nombreJugador);
        turnos.agregarJugador("Dealer");

        // repartir cartas de momento
        for (int i = 0; i < 2; i++) {
            jugador.recibirCarta(baraja.saltoCarta());
            dealer.recibirCarta(baraja.saltoCarta());
        }

        // juegador jugando 
        System.out.println("\nTurno de: " + nombreJugador);
        jugador.mostrarMano();
        for (Carta c : jugador.mano) historial.registrarJugada(c);

        while (true) {
            System.out.print("¿Desea otra carta? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                Carta nueva = baraja.saltoCarta();
                jugador.recibirCarta(nueva);
                historial.registrarJugada(nueva);
                jugador.mostrarMano();
                if (jugador.puntos > 21) break;
            } else break;
        }

        // turnos del repariwore
        System.out.println("\nTurno de: Dealer");
        dealer.mostrarMano();
        for (Carta c : dealer.mano) historial.registrarJugada(c);

        while (raiz.decidir(dealer.puntos).equals("dar")) {
            System.out.println("el repartidor a cogido una carta...:)");
            Carta nueva = baraja.saltoCarta();
            dealer.recibirCarta(nueva);
            historial.registrarJugada(nueva);
        }
        System.out.println("el repartidor se ha quedado con sus cartas malas o buenas");
        dealer.mostrarMano();

        // re
        System.out.println("\n Result");
        System.out.println(nombreJugador + " tiene:");
        jugador.mostrarMano();

        System.out.println("\repartidor tiene:");
        dealer.mostrarMano();

        if (jugador.puntos > 21 || (dealer.puntos <= 21 && dealer.puntos > jugador.puntos)) {
            System.out.println("\repartidor gana.");
        } else if (jugador.puntos == dealer.puntos) {
            System.out.println("\nnadie se a llavado dinero .");
        } else {
            System.out.println("\n" + nombreJugador + " has ganado sabes contar cartas?");
        }

        sc.close();
    }
    
}
