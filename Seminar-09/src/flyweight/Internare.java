package flyweight;

import java.util.StringJoiner;

public class Internare {
    private final int numarSalon;
    private final int numarPat;
    private final int numarZile;

    public Internare(int numarSalon, int numarPat, int numarZile) {
        this.numarSalon = numarSalon;
        this.numarPat = numarPat;
        this.numarZile = numarZile;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Internare.class.getSimpleName() + "[", "]")
                .add("numarPat=" + this.numarPat)
                .add("numarSalon=" + this.numarSalon)
                .add("numarZile=" + this.numarZile)
                .toString();
    }
}