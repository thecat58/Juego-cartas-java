public class Carta {
    String numer;
    String palo;

    public Carta(String numer, String palo) {
        this.numer = numer;
        this.palo = palo;
    }

    public int obtenernumer(){
        switch (numer){
            case "A": return 1;
             case "K":
            case "Q":
            case "J": return 10;
            default: return Integer.parseInt(numer);
        }
    }
    public String toString() {
        return numer + " de " + palo + "\n";    

    }

}
