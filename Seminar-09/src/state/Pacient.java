package state;

public class Pacient {
    private final String nume;
    private StarePacient starePacient;

    public Pacient(String nume) {
        this.nume = nume;
        this.starePacient = new Internat();
        System.out.println("Pacientul " + this.nume + " este acum internat.");
    }

    public String getNume() {
        return this.nume;
    }

    public void setStarePacient(StarePacient starePacient) {
        this.starePacient = starePacient;
    }

    public void interneaza() {
        this.starePacient.interneaza(this);
    }

    public void treceSubObservatie() {
        this.starePacient.treceSubObservatie(this);
    }

    public void externeaza() {
        this.starePacient.externeaza(this);
    }
}