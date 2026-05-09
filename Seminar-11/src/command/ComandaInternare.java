package command;

public class ComandaInternare extends Comanda {
    public ComandaInternare(Medic medic, String numePacient) {
        super(medic, numePacient);
    }

    @Override
    public void executa() {
        super.getMedic().interneazaPacient(super.getNumePacient());
    }

    @Override
    public void undo() {
        super.getMedic().anuleazaInternarea(super.getNumePacient());
    }

    @Override
    public void redo() {
        super.getMedic().reinterneazaPacient(super.getNumePacient());
    }
}