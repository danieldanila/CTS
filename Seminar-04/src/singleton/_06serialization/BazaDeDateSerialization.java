package singleton._06serialization;

import java.io.Serial;
import java.io.Serializable;
import java.util.StringJoiner;

public class BazaDeDateSerialization implements Serializable {
    private String denumire;
    private int numarCampuri;

    private static BazaDeDateSerialization instanta = null;

    public static synchronized BazaDeDateSerialization getInstanta(String denumire, int numarCampuri) {
        if (BazaDeDateSerialization.instanta == null) {
            BazaDeDateSerialization.instanta = new BazaDeDateSerialization(denumire, numarCampuri);
        }
        return BazaDeDateSerialization.instanta;
    }

    @Serial
    private Object readResolve() {
        return BazaDeDateSerialization.instanta;
    }

    private BazaDeDateSerialization(String denumire, int numarCampuri) {
        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateSerialization.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}