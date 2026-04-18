package facade;

import java.util.List;
import java.util.stream.Collectors;

public class Medic {
    private final String nume;
    private final List<Pacient> pacienti;

    public Medic(String nume, List<Pacient> pacienti) {
        this.nume = nume;
        this.pacienti = pacienti.stream().map(Pacient::new).collect(Collectors.toList());
    }

    public Medic(Medic altMedic) {
        this.nume = altMedic.nume;
        this.pacienti = altMedic.pacienti.stream().map(Pacient::new).collect(Collectors.toList());
    }

    public String getNume() {
        return this.nume;
    }

    public List<Pacient> getPacienti() {
        return List.copyOf(this.pacienti);
    }

    public boolean decideInternare(int numarPacient) {
        return this.pacienti.get(numarPacient).areStareGrava();
    }
}