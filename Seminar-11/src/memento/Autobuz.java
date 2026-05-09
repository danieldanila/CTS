package memento;

import java.util.StringJoiner;

public class Autobuz {
    private String numeSofer;
    private double consumMediu;
    private final String model;
    private final int anFabricatie;
    private final int numarLocuri;

    public Autobuz(String numeSofer, double consumMediu, String model, int anFabricatie, int numarLocuri) {
        this.numeSofer = numeSofer;
        this.consumMediu = consumMediu;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.numarLocuri = numarLocuri;
    }

    public void setNumeSofer(String numeSofer) {
        this.numeSofer = numeSofer;
    }

    public void setConsumMediu(double consumMediu) {
        this.consumMediu = consumMediu;
    }

    public AutobuzMemento salvareMemento() {
        return new AutobuzMemento(this.numeSofer, this.consumMediu);
    }

    public void restaurareMemento(AutobuzMemento autobuzMemento) {
        this.numeSofer = autobuzMemento.getNumeSofer();
        this.consumMediu = autobuzMemento.getConsumMediu();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Autobuz.class.getSimpleName() + "[", "]")
                .add("numeSofer='" + this.numeSofer + "'")
                .add("consumMediu=" + this.consumMediu)
                .add("model='" + this.model + "'")
                .add("anFabricatie=" + this.anFabricatie)
                .add("numarLocuri=" + this.numarLocuri)
                .toString();
    }
}