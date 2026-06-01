package dubluri;

import clase.IPersoana;

public class FakePersoana implements IPersoana {
    private String nume;
    private String sex;
    private int varsta;

    public FakePersoana(String nume, String sex, int varsta) {
        this.nume = nume;
        this.sex = sex;
        this.varsta = varsta;
    }

    @Override
    public String getNume() {
        return this.nume;
    }

    @Override
    public String getSex() {
        return this.sex;
    }

    @Override
    public int getVarsta() {
        return this.varsta;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
