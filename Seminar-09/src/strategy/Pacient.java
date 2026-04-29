package strategy;

public class Pacient {
    private final String nume;
    private ModPlata modPlata;

    public Pacient(String nume) {
        this.nume = nume;
    }

    public void setModPlata(ModPlata modPlata) {
        this.modPlata = modPlata;
    }

    public void plateste(double suma) {
        if (this.modPlata == null) {
            System.out.println("Pacientul " + this.nume + " nu a selectat nicio metodă de plată.");
            return;
        }
        System.out.print("Pacientul " + this.nume + ": ");
        this.modPlata.plateste(suma);
    }
}