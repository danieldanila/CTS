package command;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OperatorTriaj {
    private final Queue<Comanda> coadaComenzi;
    private final Stack<Comanda> undoComenzi;
    private final Stack<Comanda> redoComenzi;

    public OperatorTriaj() {
        this.coadaComenzi = new LinkedList<>();
        this.undoComenzi = new Stack<>();
        this.redoComenzi = new Stack<>();
    }

    public void adaugaComanda(Comanda comanda) {
        this.coadaComenzi.add(comanda);
    }

    public void trimiteComandaCatreMedic() {
        if (!this.coadaComenzi.isEmpty()) {
            System.out.println("Operatorul trimite o comandă către medic.");
            Comanda comanda = this.coadaComenzi.poll();
            comanda.executa();
            this.undoComenzi.push(comanda);
            this.redoComenzi.clear();
        } else {
            System.out.println("Coada de comenzi este goală: nu s-a trimis nicio comandă către medic.");
        }
    }

    public void undoUltimaComanda() {
        if (!this.undoComenzi.isEmpty()) {
            System.out.println("Operatorul anulează ultima comandă trimisă către medic.");
            Comanda comanda = this.undoComenzi.pop();
            comanda.undo();
            this.redoComenzi.push(comanda);
        } else {
            System.out.println("Stiva de undo este goală: nu există comenzi de anulat.");
        }
    }

    public void redoUltimaComanda() {
        if (!this.redoComenzi.isEmpty()) {
            System.out.println("Operatorul retrimite ultima comandă anulată către medic.");
            Comanda comanda = this.redoComenzi.pop();
            comanda.redo();
            this.undoComenzi.push(comanda);
        } else {
            System.out.println("Stiva de redo este goală: nu există comenzi de retrimis.");
        }
    }
}