package composite;

public class Sectie extends StructuraSpital {
    public Sectie(String nume) {
        super(nume);
    }

    @Override
    public void afiseazaIerarhie(String indentare) {
        System.out.println(indentare + "Sectia: " + super.getNume());
    }
}