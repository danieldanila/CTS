import decorator.FurnizareRezultateOnlineDecorator;
import decorator.FurnizareRezultatePrintate;
import decorator.IFurnizareRezultate;

void main() {
    IFurnizareRezultate furnizareRezultatePrintate = new FurnizareRezultatePrintate();
    furnizareRezultatePrintate.afiseazaRezultate("Rezultate OK");

    IFurnizareRezultate furnizareRezultateOnlineDecorator = new FurnizareRezultateOnlineDecorator(furnizareRezultatePrintate);
    furnizareRezultateOnlineDecorator.afiseazaRezultate("Rezultate foarte OK");

    furnizareRezultatePrintate.afiseazaRezultate("Rezultate mega OK");
}