package singleton._06serialization;

import java.io.Serializable;
import java.util.StringJoiner;

public class BazaDeDateSerializationFaraReadResolve implements Serializable {
    private String denumire;
    private int numarCampuri;

    private static BazaDeDateSerializationFaraReadResolve instanta = null;

    public static synchronized BazaDeDateSerializationFaraReadResolve getInstanta(String denumire, int numarCampuri) {
        if (BazaDeDateSerializationFaraReadResolve.instanta == null) {
            BazaDeDateSerializationFaraReadResolve.instanta = new BazaDeDateSerializationFaraReadResolve(denumire, numarCampuri);
        }
        return BazaDeDateSerializationFaraReadResolve.instanta;
    }

    private BazaDeDateSerializationFaraReadResolve(String denumire, int numarCampuri) {
        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateSerializationFaraReadResolve.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}