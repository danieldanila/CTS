import facade.Medic;
import facade.Pacient;
import facade.Salon;
import facade.SpitalFacade;

void main() {
    List<Pacient> pacienti = List.of(
            new Pacient(0, "Pacient 0", 1),
            new Pacient(1, "Pacient 1", 3),
            new Pacient(2, "Pacient 2", 5));

    Medic medic = new Medic("Medic 1", pacienti);
    Salon salon = new Salon(2);

    SpitalFacade spitalFacade = new SpitalFacade(medic, salon);
    pacienti.forEach(pacient -> spitalFacade.interneazaPacient(pacient.getNumar()));
}