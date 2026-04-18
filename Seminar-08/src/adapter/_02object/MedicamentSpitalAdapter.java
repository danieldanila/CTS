package adapter._02object;

public class MedicamentSpitalAdapter implements IMedicamentFarmacie {
    private final MedicamentSpital medicamentSpital;

    public MedicamentSpitalAdapter(MedicamentSpital medicamentSpital) {
        this.medicamentSpital = medicamentSpital;
    }

    @Override
    public void cumparaMedicament() {
        System.out.println("Metoda de achiziționare medicament din sistemul spitalului este inițiată folosind noul sistem al farmaciei.");
        this.medicamentSpital.achizitioneazaMedicament();
    }
}