package memento;

import java.util.ArrayList;
import java.util.List;

public class ManagerAutobuze {
    private final List<AutobuzMemento> autobuzeMemento;

    public ManagerAutobuze() {
        this.autobuzeMemento = new ArrayList<>();
    }

    public void adaugaMemento(AutobuzMemento autobuzMemento) {
        this.autobuzeMemento.add(autobuzMemento);
    }

    public AutobuzMemento getMemento(int index) {
        if(index < this.autobuzeMemento.size()) {
            return this.autobuzeMemento.get(index);
        }
        throw new IllegalStateException("Indexul oferit este mai mare de dimensiunea autobuzelor salvate.");
    }

    public AutobuzMemento getUltimulMemento() {
        if (!this.autobuzeMemento.isEmpty()) {
            return this.autobuzeMemento.removeLast();
        }
        throw new IllegalStateException("Nu există niciun memento de autobuz.");
    }
}