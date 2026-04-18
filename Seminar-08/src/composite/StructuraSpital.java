package composite;

public abstract class StructuraSpital {
    private final String nume;

    public StructuraSpital(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return this.nume;
    }

    public void adauga(StructuraSpital structuraSpital) {
        throw new UnsupportedOperationException();
    }

    public void sterge(StructuraSpital structuraSpital) {
        throw new UnsupportedOperationException();
    }

    public StructuraSpital getStructuraSpital(int index) {
        throw new UnsupportedOperationException();
    }

    public abstract void afiseazaIerarhie(String indentare);
}