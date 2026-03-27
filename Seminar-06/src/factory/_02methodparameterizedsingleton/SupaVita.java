package factory._02methodparameterizedsingleton;

public class SupaVita extends FelMancare {
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