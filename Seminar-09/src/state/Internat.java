package state;

public class Internat implements StarePacient {
    @Override
    public void interneaza(Pacient pacient) {
        System.out.println("Pacientul " + pacient.getNume() + " este deja internat.");
    }

    @Override
    public void treceSubObservatie(Pacient pacient) {
        pacient.setStarePacient(new SubObservatie());
        System.out.println("Pacientul " + pacient.getNume() + " este acum sub observație.");
    }

    @Override
    public void externeaza(Pacient pacient) {
        pacient.setStarePacient(new Externat());
        System.out.println("Pacientul " + pacient.getNume() + " este acum externat.");
    }
}