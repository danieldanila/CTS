package command;

public abstract class Comanda {
    private final Medic medic;
    private final String numePacient;

    public Comanda(Medic medic, String numePacient) {
        this.medic = medic;
        this.numePacient = numePacient;
    }

    public Medic getMedic() {
        return this.medic;
    }

    public String getNumePacient() {
        return this.numePacient;
    }

    abstract public void executa();
    abstract public void undo();
    abstract public void redo();
}