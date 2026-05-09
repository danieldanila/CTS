import memento.Autobuz;
import memento.ManagerAutobuze;

void main() {
    ManagerAutobuze managerAutobuze = new ManagerAutobuze();

    Autobuz autobuz = new Autobuz("Vasile", 12.5, "Mercedes", 1997, 50);
    System.out.println(autobuz);

    managerAutobuze.adaugaMemento(autobuz.salvareMemento());

    autobuz.setNumeSofer("Ana");
    autobuz.setConsumMediu(10.8);
    System.out.println(autobuz);

    managerAutobuze.adaugaMemento(autobuz.salvareMemento());

    autobuz.restaurareMemento(managerAutobuze.getMemento(0));
    System.out.println(autobuz);

    autobuz.restaurareMemento(managerAutobuze.getUltimulMemento());
    System.out.println(autobuz);
}