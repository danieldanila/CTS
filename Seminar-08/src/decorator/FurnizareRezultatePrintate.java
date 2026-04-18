package decorator;

public class FurnizareRezultatePrintate implements IFurnizareRezultate {
    @Override
    public void afiseazaRezultate(String rezultate) {
        System.out.println("Rezultatele sunt furnizate printat: " + rezultate);
    }
}