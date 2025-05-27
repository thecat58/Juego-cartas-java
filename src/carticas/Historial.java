pakage juego de cartas;
/**
 *
 * @author Ana Maya
 */
import java.util.stack;

class Historial{
    Stack<Carta> pila = new Stack<>();

    public void registrarJugada(Carta carta){
        pila.push(carta);
    }
    public void mostrarUltimasjugadas(){
        Sysstem.out.println("Ultimas jugadas:");
        pila.stream()
            .limit(5).forEach(carta -> System.out.println(carta.getNombre() + " de " + carta.getPalo()));
    }
}