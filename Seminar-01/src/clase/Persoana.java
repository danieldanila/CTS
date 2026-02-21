package clase;

import interfete.IPersoana;

// O clasă poate extinde o singură altă clasă, dar poate implementa multiple interfețe
public class Persoana implements IPersoana, Cloneable {
    private String nume;
    private int varsta;

    // Constructor fără parametrii
    public Persoana() {
        this.nume = "Anonim";
        this.varsta = 0;
    }

    // Constructor cu parametrii
    public Persoana(String nume, int varsta) {
       this.nume = nume;
       this.varsta = varsta;
    }

    // Constructor de copiere
    public Persoana(Persoana altaPersoana) {
        this.nume = altaPersoana.nume;
        this.varsta = altaPersoana.varsta;
    }

    @Override
    public String getNume() {
        return this.nume;
    }

    @Override
    public int getVarsta() {
        return this.varsta;
    }

    @Override
    public Persoana clone() {
        try {
            Persoana clone = (Persoana) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
