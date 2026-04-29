package state;

public class Externat implements StarePacient {
    @Override
    public void interneaza(Pacient pacient) {
        pacient.setStarePacient(new Internat());
        System.out.println("Pacientul " + pacient.getNume() + " este acum reinternat.");
    }

    @Override
    public void treceSubObservatie(Pacient pacient) {
        System.out.println("Pacientul " + pacient.getNume() + " este externat și nu poate trece sub observație.");
    }

    @Override
    public void externeaza(Pacient pacient) {
        System.out.println("Pacientul " + pacient.getNume() + " este deja externat.");
    }
}