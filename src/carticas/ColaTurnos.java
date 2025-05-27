package carticas;

import java.util.LinkedList;
import java.util.Queue;

public class ColaTurnos {
    Queue<String> cola = new LinkedList<>();

    public void agregarJugador(String nombre) {
        cola.add(nombre);
    }

    public String siguienteTurno() {
        String actual = cola.poll();
        cola.add(actual);
        return actual;
    }
}

