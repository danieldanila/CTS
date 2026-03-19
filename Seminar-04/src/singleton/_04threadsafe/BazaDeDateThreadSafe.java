package singleton._04threadsafe;

import java.util.StringJoiner;

public class BazaDeDateThreadSafe {
    private String denumire;
    private int numarCampuri;

    private static BazaDeDateThreadSafe instanta = null;

    public static synchronized BazaDeDateThreadSafe getInstanta(String denumire, int numarCampuri) {
        if (BazaDeDateThreadSafe.instanta == null) {
            BazaDeDateThreadSafe.instanta = new BazaDeDateThreadSafe(denumire, numarCampuri);
        }
        return BazaDeDateThreadSafe.instanta;
    }

    private BazaDeDateThreadSafe(String denumire, int numarCampuri) {
        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateThreadSafe.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}