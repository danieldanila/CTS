package singleton._01eager;

import java.util.StringJoiner;

public class BazaDeDateEager {
    private String denumire;
    private int numarCampuri;

    private static final BazaDeDateEager instanta = new BazaDeDateEager("Baza-Eager-01", 2);

    public static BazaDeDateEager getInstanta() {
        return BazaDeDateEager.instanta;
    }

    private BazaDeDateEager(String denumire, int numarCampuri) {
        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateEager.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}