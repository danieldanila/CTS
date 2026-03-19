package singleton._09registry;

import java.util.HashMap;
import java.util.Map;

public class BazeDeDateRegistry {
    private static final Map<String, BazaDeDate> collection = new HashMap<>();

    private BazeDeDateRegistry() {
    }

    public static void register(String denumire, int numarCampuri) {
        if (BazeDeDateRegistry.collection.containsKey(denumire)) {
            throw new IllegalArgumentException("Cheia " + denumire + " există deja.");
        } else {
            BazeDeDateRegistry.collection.put(denumire, new BazaDeDate(denumire, numarCampuri));
        }
    }

    public static BazaDeDate getBazaDeDate(String denumire) {
        return BazeDeDateRegistry.collection.get(denumire);
    }
}