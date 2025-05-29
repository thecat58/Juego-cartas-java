package carticas;

class NodoCola {
    String jugador;
    NodoCola siguiente;

    public NodoCola(String jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }
}

public class ColaTurnos {
    private NodoCola frente, fin;

    public void agregarJugador(String nombre) {
        NodoCola nuevo = new NodoCola(nombre);
        if (fin != null) {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        if (frente == null) {
            frente = fin;
        }
    }

    public String siguienteTurno() {
        if (frente == null) return null;
        String jugador = frente.jugador;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return jugador;
    }
}

