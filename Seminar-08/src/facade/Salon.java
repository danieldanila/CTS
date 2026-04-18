package facade;

import java.util.ArrayList;
import java.util.List;

public class Salon {
    private final List<Boolean> paturi;

    public Salon(int numarPaturi) {
        this.paturi = new ArrayList<>();

        for (int i = 0; i < numarPaturi; i++) {
            this.paturi.add(i % 2 == 0);
        }
    }

    public Salon(Salon altSalon) {
        this.paturi = new ArrayList<>(altSalon.paturi);
    }

    public boolean arePaturiLibere() {
        for (Boolean esteLiber : this.paturi) {
            if (esteLiber) return true;
        }
        return false;
    }

    public int ocupaPrimulPatLiber() {
        for (int i = 0; i < this.paturi.size(); i++) {
            if (this.paturi.get(i)) {
                this.paturi.set(i, false);
                return i;
            }
        }
        return -1;
    }
}