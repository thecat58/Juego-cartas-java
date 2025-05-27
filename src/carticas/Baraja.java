package carticas;
// clase baraja encarhgada del manejo de cartas
public class Baraja {
    Nodo cab;
    // metodo para agregar carta a la baraja al fdinal
    public void agregarCarta(Carta carta) {
        Nodo nuev = new Nodo(carta);
        if (cab == null) {
            cab = nuev;
        } else {
            Nodo actual = cab;
            while (actual.siguiente != null)
                actual = actual.siguiente;
            actual.siguiente = nuev;
        }
    }
    // baraja la carta quitandola la primera y devolviendolam, yn si esta vacioa la baraja
    // retorna niullo
    public Carta saltoCarta() {
        if (cab == null) return null;
        Carta carta = cab.carta;
        cab = cab.siguiente;
        return carta;
    }
}
