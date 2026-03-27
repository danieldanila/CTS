package factory._01simplesingleton;

public class SupaLegume extends Supa {
    public SupaLegume(String denumire) {
        super(denumire);
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Supa de legume: " + super.getDenumire());
    }
}