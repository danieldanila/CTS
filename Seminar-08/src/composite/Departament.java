package composite;

import java.util.ArrayList;
import java.util.List;

public class Departament extends StructuraSpital {
    private final List<StructuraSpital> structuriSpital;

    public Departament(String nume) {
        super(nume);
        this.structuriSpital = new ArrayList<>();
    }

    @Override
    public void adauga(StructuraSpital structuraSpital) {
        this.structuriSpital.add(structuraSpital);
    }

    @Override
    public void sterge(StructuraSpital structuraSpital) {
        this.structuriSpital.remove(structuraSpital);
    }

    @Override
    public StructuraSpital getStructuraSpital(int index) {
        return this.structuriSpital.get(index);
    }

    @Override
    public void afiseazaIerarhie(String indentare) {
        System.out.println(indentare + "Departament: " + super.getNume());
        for (StructuraSpital structuraSpital : this.structuriSpital) {
            structuraSpital.afiseazaIerarhie(indentare + "  ");
        }
    }
}