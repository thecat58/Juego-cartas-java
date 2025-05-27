package carticas;
// clase nodo para la lista enlazada delas cartas
public class Nodo {
    Carta carta;
    Nodo siguiente;
    // constru del nodo
    public Nodo(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }
}

