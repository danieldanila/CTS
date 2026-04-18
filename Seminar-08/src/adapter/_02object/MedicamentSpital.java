package adapter._02object;

public class MedicamentSpital {
    private final String nume;

    public MedicamentSpital(String nume) {
        this.nume = nume;
    }

    public void prezintaReteta() {
        System.out.println("Rețeta medicamentului " + this.nume + " este verificată în sistemul spitalului.");
    }

    public void achizitioneazaMedicament() {
        this.prezintaReteta();
        System.out.println("Medicamentul " + this.nume + " este achiziționat prin sistemul spitalului.");
    }
}