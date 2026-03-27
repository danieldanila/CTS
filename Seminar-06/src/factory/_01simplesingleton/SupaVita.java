package factory._01simplesingleton;

public class SupaVita extends Supa {
    private Double gramaj;

    public SupaVita(String denumire, Double gramaj) {
        super(denumire);
        this.gramaj = gramaj;
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Supa de vita: " + super.getDenumire() + ", " + this.gramaj + " grame");
    }
}