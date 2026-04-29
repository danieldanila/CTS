package templatemethod;

public abstract class InternareTemplate {
    public final void interneazaPacient(String numePacient) {
        this.analizeazaStare(numePacient);
        this.verificaDisponibilitate();
        this.emiteFisa(numePacient);
    }

    protected abstract void analizeazaStare(String numePacient);
    protected abstract void verificaDisponibilitate();
    protected abstract void emiteFisa(String numePacient);
}