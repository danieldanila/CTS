package singleton._08enum;

import java.util.StringJoiner;

public enum BazaDeDateEnum {
    instanta;

    private String denumire;
    private int numarCampuri;

    BazaDeDateEnum() {
        this.denumire = "Baza-Enum-01";
        this.numarCampuri = 2;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateEnum.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}