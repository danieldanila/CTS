import templatemethod.InternareStandard;
import templatemethod.InternareTemplate;
import templatemethod.InternareUrgenta;

void main() {
    InternareTemplate internareStandard = new InternareStandard();
    internareStandard.interneazaPacient("Andrei");

    InternareTemplate internareUrgenta = new InternareUrgenta();
    internareUrgenta.interneazaPacient("Maria");
}