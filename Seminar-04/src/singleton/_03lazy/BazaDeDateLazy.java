package singleton._03lazy;

import java.util.StringJoiner;

public class BazaDeDateLazy {
    private String denumire;
    private int numarCampuri;

    private static BazaDeDateLazy instanta = null;

    public static BazaDeDateLazy getInstanta(String denumire, int numarCampuri) {
        if (BazaDeDateLazy.instanta == null) {
            BazaDeDateLazy.instanta = new BazaDeDateLazy(denumire, numarCampuri);
        }
        return BazaDeDateLazy.instanta;
    }

    private BazaDeDateLazy(String denumire, int numarCampuri) {
        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateLazy.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}