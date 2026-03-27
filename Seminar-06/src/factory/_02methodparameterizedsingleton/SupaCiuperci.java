package factory._02methodparameterizedsingleton;

public class SupaCiuperci extends FelMancare {
    public SupaCiuperci(String denumire) {
        super(denumire);
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Supa de ciuperci: " + super.getDenumire());
    }
}