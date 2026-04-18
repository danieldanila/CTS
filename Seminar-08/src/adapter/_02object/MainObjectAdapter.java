import adapter._02object.IMedicamentFarmacie;
import adapter._02object.MedicamentSpitalAdapter;
import adapter._02object.MedicamentFarmacie;
import adapter._02object.MedicamentSpital;

void main() {
    IMedicamentFarmacie medicamentFarmacie = new MedicamentFarmacie();

    MedicamentSpital medicamentSpital = new MedicamentSpital("Ibuprofen");
    IMedicamentFarmacie medicamentSpitalAdapter = new MedicamentSpitalAdapter(medicamentSpital);

    List<IMedicamentFarmacie> medicamente = List.of(medicamentFarmacie, medicamentSpitalAdapter);
    medicamente.forEach(IMedicamentFarmacie::cumparaMedicament);
}