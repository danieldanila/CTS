package proxy;

public class Pacient {
    private final String nume;
    private final boolean areAsigurareSanatate;

    public Pacient(String nume, boolean areAsigurareSanatate) {
        this.nume = nume;
        this.areAsigurareSanatate = areAsigurareSanatate;
    }

    public String getNume() {
        return this.nume;
    }

    public boolean areAsigurareSanatate() {
        return this.areAsigurareSanatate;
    }
}