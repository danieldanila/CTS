package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private final List<IObserver> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void adaugaObserver(IObserver observer) {
        this.observers.add(observer);
    }

    public void stergeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    public void trimiteNotificare(String mesaj) {
        for (IObserver observer : this.observers) {
            observer.primesteNotificare(mesaj);
        }
    }
}