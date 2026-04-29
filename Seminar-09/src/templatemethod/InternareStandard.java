package templatemethod;

public class InternareStandard extends InternareTemplate {
    @Override
    protected void analizeazaStare(String numePacient) {
        System.out.println("Pacientul " + numePacient + " a fost analizat în regim standard.");
    }

    @Override
    protected void verificaDisponibilitate() {
        System.out.println("Verificare disponibilitate pentru locuri în saloane standard.");
    }

    @Override
    protected void emiteFisa(String numePacient) {
        System.out.println("Fișa de internare standard pentru pacientul " + numePacient + " a fost emisă.");
    }
}