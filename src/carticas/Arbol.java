package carticas;
// clase arbolito del juego
public class Arbol {
    // se definen las variables del arbolito
    public static class NodoDecision {
        public int valorC;
        public String usar;
        public NodoDecision izquierda, derecha;
        // se realiza el constru para el nodoDecision
        public NodoDecision(int valorC, String usar) {
            this.valorC = valorC;
            this.usar = usar;
        }
        // metodo para decidir la decision dsegun el valor de los puntos
        public String decidir(int puntos) {
            if (puntos < valorC && izquierda != null) return izquierda.usar;
            if (puntos >= valorC && derecha != null) return derecha.usar;
            return usar;
        }
    }
}
