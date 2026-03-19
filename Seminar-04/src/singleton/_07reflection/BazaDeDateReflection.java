package singleton._07reflection;

import java.util.StringJoiner;

public class BazaDeDateReflection {
    private String denumire;
    private int numarCampuri;

    private static BazaDeDateReflection instanta = null;

    public static synchronized BazaDeDateReflection getInstanta(String denumire, int numarCampuri) {
        if (BazaDeDateReflection.instanta == null) {
            BazaDeDateReflection.instanta = new BazaDeDateReflection(denumire, numarCampuri);
        }
        return BazaDeDateReflection.instanta;
    }

    private BazaDeDateReflection(String denumire, int numarCampuri) {
        if (BazaDeDateReflection.instanta != null) {
            throw new RuntimeException("Instanța este deja definită.");
        }

        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateReflection.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}