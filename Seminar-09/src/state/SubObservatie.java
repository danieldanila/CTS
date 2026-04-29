package state;

public class SubObservatie implements StarePacient {
    @Override
    public void interneaza(Pacient pacient) {
        pacient.setStarePacient(new Internat());
        System.out.println("Pacientul " + pacient.getNume() + " este acum doar internat, nemaifiind sub observație.");
    }

    @Override
    public void treceSubObservatie(Pacient pacient) {
        System.out.println("Pacientul " + pacient.getNume() + " este deja sub observație.");
    }

    @Override
    public void externeaza(Pacient pacient) {
        pacient.setStarePacient(new Externat());
        System.out.println("Pacientul " + pacient.getNume() + " este acum externat.");
    }
}