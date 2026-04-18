package adapter._02object;

public class MedicamentFarmacie implements IMedicamentFarmacie {
    @Override
    public void cumparaMedicament() {
        System.out.println("Medicamentul este achiziționat prin sistemul farmaciei, fără verificarea rețetei.");
    }
}