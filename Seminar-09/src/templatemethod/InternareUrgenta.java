package templatemethod;

public class InternareUrgenta extends InternareTemplate {
    @Override
    protected void analizeazaStare(String numePacient) {
        System.out.println("Pacientul " + numePacient + " a fost analizat în regim de urgență.");
    }

    @Override
    protected void verificaDisponibilitate() {
        System.out.println("Verificare disponibilitate pentru locuri în saloane de urgență.");
    }

    @Override
    protected void emiteFisa(String numePacient) {
        System.out.println("Fișa de internare urgentă pentru pacientul " + numePacient + " a fost emisă.");
    }
}