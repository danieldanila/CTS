package flyweight;

import java.util.StringJoiner;

public class Pacient {
    private final String nume;
    private final String numarTelefon;
    private final String adresa;

    public Pacient(String nume, String numarTelefon, String adresa) {
        this.nume = nume;
        this.numarTelefon = numarTelefon;
        this.adresa = adresa;
    }

    public Pacient(Pacient pacient) {
        this.nume = pacient.nume;
        this.numarTelefon = pacient.numarTelefon;
        this.adresa = pacient.adresa;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pacient.class.getSimpleName() + "[", "]")
                .add("nume='" + this.nume + "'")
                .add("telefon='" + this.numarTelefon + "'")
                .add("adresa='" + this.adresa + "'")
                .toString();
    }
}