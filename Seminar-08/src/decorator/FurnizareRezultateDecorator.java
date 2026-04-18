package decorator;

public abstract class FurnizareRezultateDecorator implements IFurnizareRezultate {
    private final IFurnizareRezultate furnizareRezultate;

    public FurnizareRezultateDecorator(IFurnizareRezultate furnizareRezultate) {
        this.furnizareRezultate = furnizareRezultate;
    }

    @Override
    public void afiseazaRezultate(String rezultate) {
        this.furnizareRezultate.afiseazaRezultate(rezultate);
    }
}