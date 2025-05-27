package carticas;
import java.util.*;

public class Jugador {
    String nombre;
    List<Carta> mano = new ArrayList<>();
    int puntos = 0;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void recibirCarta(Carta carta) {
        mano.add(carta);
        puntos += carta.obtenerValor();
    }

    public void mostrarMano() {
        for (Carta c : mano) {
            System.out.println("  " + c);
        }
        System.out.println("puntos: " + puntos);
    }

}
