package observer;

public class Spital extends Subject {
    private final String nume;

    public Spital(String nume) {
        super();
        this.nume = nume;
    }

    public void notificaEpidemie(String numeVirusNou) {
        String mesaj = "Alertă de la spitalul " + this.nume + ": A fost detectat un virs nou în oraș: " + numeVirusNou;
        super.trimiteNotificare(mesaj);
    }
}