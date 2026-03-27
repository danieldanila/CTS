package factory._02methodparameterizedsingleton;

public class SupaLegume extends FelMancare {
    public SupaLegume(String denumire) {
        super(denumire);
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Supa de legume: " + super.getDenumire());
    }
}