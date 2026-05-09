package command;

public class Medic {
    private final String nume;

    public Medic(String nume) {
        this.nume = nume;
    }

    public void interneazaPacient(String numePacient) {
        System.out.println("Medicul " + this.nume + " internează pacientul " + numePacient);
    }

    public void anuleazaInternarea(String numePacient) {
        System.out.println("Medicul " + this.nume + " a anulat internarea pacientului " + numePacient);
    }

    public void reinterneazaPacient(String numePacient) {
        System.out.println("Medicul " + this.nume + " reinternează pacientul " + numePacient);
    }

    public void trateazaImediatPacient(String numePacient) {
        System.out.println("Medicul " + this.nume + " tratează imediat pacientul " + numePacient);
    }

    public void anuleazaTratareaImediata(String numePacient) {
        System.out.println("Medicul " + this.nume + " a anulat tratarea imediată a pacientului " + numePacient);
    }

    public void retrateazaImediatPacient(String numePacient) {
        System.out.println("Medicul " + this.nume + " retratează imediat pacientul " + numePacient);
    }
}