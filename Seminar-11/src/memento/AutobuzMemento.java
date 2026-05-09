package memento;

public class AutobuzMemento {
    private final String numeSofer;
    private final double consumMediu;

    public AutobuzMemento(String numeSofer, double consumMediu) {
        this.numeSofer = numeSofer;
        this.consumMediu = consumMediu;
    }

    public String getNumeSofer() {
        return this.numeSofer;
    }

    public double getConsumMediu() {
        return this.consumMediu;
    }
}