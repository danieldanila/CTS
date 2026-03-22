package prototype._02mutabletypes;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RetetaMedicament implements RetetaCloneable {
    private String nume;
    private List<Solutie> solutii;

    public RetetaMedicament(String nume, List<Solutie> solutii) {
        this.nume = nume;
        this.solutii = new ArrayList<>(solutii);
    }

    public RetetaMedicament(RetetaMedicament altaRetetaMedicament) {
        this.nume = altaRetetaMedicament.nume;

        // shallow copy
        this.solutii = new ArrayList<>(altaRetetaMedicament.solutii);

        // deep copy
        List<Solutie> solutiiCopiate = new ArrayList<>();
        for (Solutie solutie : altaRetetaMedicament.solutii) {
            solutiiCopiate.add((solutie.clone()));
        }
        this.solutii = solutiiCopiate;
    }

    public List<Solutie> getSolutii() {
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