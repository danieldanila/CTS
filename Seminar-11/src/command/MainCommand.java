import command.ComandaInternare;
import command.ComandaTrateazaImediat;
import command.Medic;
import command.OperatorTriaj;

void main() {
    Medic medic = new Medic("Medic 1");
    OperatorTriaj operatorTriaj = new OperatorTriaj();

    operatorTriaj.adaugaComanda(new ComandaInternare(medic, "Pacient 1"));
    operatorTriaj.adaugaComanda(new ComandaTrateazaImediat(medic, "Pacient 2"));
    operatorTriaj.adaugaComanda(new ComandaInternare(medic, "Pacient 3"));

    operatorTriaj.trimiteComandaCatreMedic();
    operatorTriaj.trimiteComandaCatreMedic();
    operatorTriaj.trimiteComandaCatreMedic();

    operatorTriaj.trimiteComandaCatreMedic();

    operatorTriaj.undoUltimaComanda();
    operatorTriaj.undoUltimaComanda();
    operatorTriaj.undoUltimaComanda();

    operatorTriaj.undoUltimaComanda();
    operatorTriaj.trimiteComandaCatreMedic();

    operatorTriaj.redoUltimaComanda();
    operatorTriaj.redoUltimaComanda();
    operatorTriaj.redoUltimaComanda();

    operatorTriaj.redoUltimaComanda();
    operatorTriaj.trimiteComandaCatreMedic();
}