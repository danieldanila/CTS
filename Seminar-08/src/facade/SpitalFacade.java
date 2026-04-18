package facade;

public class SpitalFacade {
    private final Medic medic;
    private final Salon salon;

    public SpitalFacade(Medic medic, Salon salon) {
        this.medic = new Medic(medic);
        this.salon = new Salon(salon);
    }

    public void interneazaPacient(int numarPacient) {
        Pacient pacient = this.medic.getPacienti().get(numarPacient);
        System.out.println("Se proceseaza cererea de internare a pacientului: " + pacient);

        if (!this.medic.decideInternare(pacient.getNumar())) {
            System.out.println("\tMedicul " + this.medic.getNume() + " a decis că starea de sănătate a pacientului nu necesită internare.");
            return;
        }

        System.out.println("\tMedicul " + this.medic.getNume() + " a decis internarea pacientului.");

        if (!this.salon.arePaturiLibere()) {
            System.out.println("\tSalonul are toate paturile ocupate. Internare refuzată.");
            return;
        }

        int numarPatOcupat = this.salon.ocupaPrimulPatLiber();

        System.out.println("\tPatul cu numărul " + (numarPatOcupat + 1) + " a fost ocupat.");
        System.out.println("\tPacientul a fost internat cu succes.");
    }
}