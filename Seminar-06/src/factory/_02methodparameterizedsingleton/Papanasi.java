package factory._02methodparameterizedsingleton;

public class Papanasi extends FelMancare {
    public Papanasi(String denumire) {
        super(denumire);
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Papanasi: " + super.getDenumire());
    }
}