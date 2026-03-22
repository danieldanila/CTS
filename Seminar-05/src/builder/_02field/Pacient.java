package builder._02field;

import java.util.StringJoiner;

public class Pacient {
    private final String nume;
    private final boolean arePatRabatabil;
    private final boolean areMicDejunInclus;
    private final boolean arePapuciDeCamera;
    private final boolean areHalatPentruInterior;

    protected Pacient(String nume, boolean arePatRabatabil, boolean areMicDejunInclus, boolean arePapuciDeCamera, boolean areHalatPentruInterior) {
        this.nume = nume;
        this.arePatRabatabil = arePatRabatabil;
        this.areMicDejunInclus = areMicDejunInclus;
        this.arePapuciDeCamera = arePapuciDeCamera;
        this.areHalatPentruInterior = areHalatPentruInterior;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pacient.class.getSimpleName() + "[", "]")
                .add("nume='" + this.nume + "'")
                .add("arePatRabatabil=" + this.arePatRabatabil)
                .add("areMicDejunInclus=" + this.areMicDejunInclus)
                .add("arePapuciDeCamera=" + this.arePapuciDeCamera)
                .add("areHalatPentruInterior=" + this.areHalatPentruInterior)
                .toString();
    }
}