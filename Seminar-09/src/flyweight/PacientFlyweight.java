package flyweight;

public class PacientFlyweight implements IPacientFlyweight {
    private final Pacient pacient;

    public PacientFlyweight(Pacient pacient) {
        this.pacient = new Pacient(pacient);
    }

    @Override
    public void afiseazaDetaliiInternare(Internare internare) {
        System.out.println(this.pacient + " " + internare);
    }
}