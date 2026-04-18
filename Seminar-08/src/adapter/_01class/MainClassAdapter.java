import adapter._01class.IMedicamentFarmacie;
import adapter._01class.MedicamentSpitalAdapter;
import adapter._01class.MedicamentFarmacie;

void main() {
    IMedicamentFarmacie medicamentFarmacie = new MedicamentFarmacie();

    IMedicamentFarmacie medicamentSpitalAdapter = new MedicamentSpitalAdapter("Ibuprofen");

    List<IMedicamentFarmacie> medicamente = List.of(medicamentFarmacie, medicamentSpitalAdapter);
    medicamente.forEach(IMedicamentFarmacie::cumparaMedicament);
}