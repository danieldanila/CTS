package prototype._02mutabletypes;

import java.util.StringJoiner;

public class Solutie implements Cloneable {
    private String nume;
    private Double cantitate;

    public Solutie(String nume, Double cantitate) {
        this.nume = nume;
        this.cantitate = cantitate;
    }

    public void setCantitate(Double cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Solutie.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.nume + "'")
                .add("cantitate=" + this.cantitate)
                .toString();
    }

    @Override
    public Solutie clone() {
        try {
            return (Solutie) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}