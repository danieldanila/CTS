package command;

public class ComandaTrateazaImediat extends Comanda {
    public ComandaTrateazaImediat(Medic medic, String numePacient) {
        super(medic, numePacient);
    }

    @Override
    public void executa() {
        super.getMedic().trateazaImediatPacient(super.getNumePacient());
    }

    @Override
    public void undo() {
        super.getMedic().anuleazaTratareaImediata(super.getNumePacient());
    }

    @Override
    public void redo() {
        super.getMedic().retrateazaImediatPacient(super.getNumePacient());
    }
}