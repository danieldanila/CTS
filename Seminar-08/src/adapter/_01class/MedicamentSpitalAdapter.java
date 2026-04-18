package adapter._01class;

public class MedicamentSpitalAdapter extends MedicamentSpital implements IMedicamentFarmacie {
    public MedicamentSpitalAdapter(String nume) {
        super(nume);
    }

    @Override
    public void cumparaMedicament() {
        System.out.println("Metoda de achiziționare medicament din sistemul spitalului este inițiată folosind noul sistem al farmaciei.");
        super.achizitioneazaMedicament();
    }
}