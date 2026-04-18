package facade;

import java.util.StringJoiner;

public class Pacient {
    private final int numar;
    private final String nume;
    private final int stareGravitate;

    public Pacient(int numar, String nume, int stareGravitate) {
        this.numar = numar;
        this.nume = nume;
        this.stareGravitate = stareGravitate;
    }

    public Pacient(Pacient altPacient) {
        this.numar = altPacient.numar;
        this.nume = altPacient.nume;
        this.stareGravitate = altPacient.stareGravitate;
    }

    public int getNumar() {
        return this.numar;
    }

    public int getStareGravitate() {
        return this.stareGravitate;
    }

    public boolean areStareGrava() {
        return this.getStareGravitate() > 2;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pacient.class.getSimpleName() + "[", "]")
                .add("numar=" + this.numar)
                .add("nume='" + this.nume + "'")
                .add("stareGravitate=" + this.stareGravitate)
                .toString();
    }
}