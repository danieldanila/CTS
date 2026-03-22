package prototype._01immutabletypes;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class RetetaMedicament implements RetetaCloneable {
    private String nume;
    private Map<String, Double> solutii;

    public RetetaMedicament(String nume, Map<String, Double> solutii) {
        this.nume = nume;
        this.solutii = new HashMap<>(solutii);
    }

    public RetetaMedicament(RetetaMedicament altaRetetaMedicament) {
        this.nume = altaRetetaMedicament.nume;
        this.solutii = new HashMap<>(altaRetetaMedicament.solutii);
    }

    public Map<String, Double> getSolutii() {
        return this.solutii;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RetetaMedicament.class.getSimpleName() + "[", "]")
                .add("nume='" + this.nume + "'")
                .add("solutii=" + this.solutii)
                .toString();
    }

    @Override
    public RetetaCloneable cloneaza() {
        return new RetetaMedicament(this);
    }
}