package factory._02methodparameterizedsingleton;

public abstract class FelMancare {
    private String denumire;

    public FelMancare(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return this.denumire;
    }

    public abstract void afiseazaDetalii();
}