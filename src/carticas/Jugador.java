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
        int valor = carta.obtenernumer();
        if (valor == 1 && puntos + 11 <= 21) {
            valor = 11; // El As vale 11 si no supera 21
        }
        puntos += valor;
    }

    public void mostrarMano() {
        for (Carta c : mano) {
            System.out.println("  " + c);
        }
        System.out.println("puntos: " + puntos);
    }

}
