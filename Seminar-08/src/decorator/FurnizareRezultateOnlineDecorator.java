package decorator;

public class FurnizareRezultateOnlineDecorator extends FurnizareRezultateDecorator {
    public FurnizareRezultateOnlineDecorator(IFurnizareRezultate furnizareRezultate) {
        super(furnizareRezultate);
    }

    @Override
    public void afiseazaRezultate(String rezultate) {
        super.afiseazaRezultate(rezultate);
        this.afiseazaRezultateOnline(rezultate);
    }

    private void afiseazaRezultateOnline(String rezultate) {
        System.out.println("Rezultatele sunt furnizate și online: " + rezultate);
    }
}