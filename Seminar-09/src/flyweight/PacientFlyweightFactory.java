package flyweight;

import java.util.HashMap;
import java.util.Map;

public class PacientFlyweightFactory {
    private static final Map<String, IPacientFlyweight> pacienti = new HashMap<>();

    public static IPacientFlyweight getPacient(String nume, String numarTelefon, String adresa) {
        if (!PacientFlyweightFactory.pacienti.containsKey(numarTelefon)) {
            PacientFlyweightFactory.pacienti.put(numarTelefon, new PacientFlyweight(new Pacient(nume, numarTelefon, adresa)));
        }
        return PacientFlyweightFactory.pacienti.get(numarTelefon);
    }

    public static int getNumarPacientiUnici() {
        return PacientFlyweightFactory.pacienti.size();
    }
}