package singleton._09registry;

import java.util.StringJoiner;

public class BazaDeDate {
    private String denumire;
    private int numarCampuri;

    protected BazaDeDate(String denumire, int numarCampuri) {
        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDate.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}