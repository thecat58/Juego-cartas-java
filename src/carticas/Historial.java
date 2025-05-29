package carticas;

class NodoPila {
    Carta carta;
    NodoPila siguiente;

    public NodoPila(Carta carta) {
        this.carta = carta;
        this.siguiente = null;
    }
}

class Historial {
    private NodoPila cima;

    public void registrarJugada(Carta carta) {
        NodoPila nuevo = new NodoPila(carta);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public void mostrarUltimasjugadas() {
        System.out.println("Últimas jugadas:");
        NodoPila actual = cima;
        int contador = 0;
        while (actual != null && contador < 5) {
            System.out.println(actual.carta.getNombre() + " de " + actual.carta.getPalo());
            actual = actual.siguiente;
            contador++;
        }
    }
}