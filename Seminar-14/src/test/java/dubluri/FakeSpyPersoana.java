package dubluri;

import clase.IPersoana;

public class FakeSpyPersoana implements IPersoana {
    private String nume;
    private String sex;
    private int varsta;

    private int getNumeNumarApeluri;
    private int getSexNumarApeluri;
    private int getVarstaNumarApeluri;

    public FakeSpyPersoana(String nume, String sex, int varsta) {
        this.nume = nume;
        this.sex = sex;
        this.varsta = varsta;

        this.getNumeNumarApeluri = 0;
        this.getSexNumarApeluri = 0;
        this.getVarstaNumarApeluri = 0;
    }

    @Override
    public String getNume() {
        this.getNumeNumarApeluri++;
        return this.nume;
    }

    @Override
    public String getSex() {
        this.getSexNumarApeluri++;
        return this.sex;
    }

    @Override
    public int getVarsta() {
        this.getVarstaNumarApeluri++;
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

    public int getGetNumeNumarApeluri() {
        return this.getNumeNumarApeluri;
    }

    public int getGetSexNumarApeluri() {
        return this.getSexNumarApeluri;
    }

    public int getGetVarstaNumarApeluri() {
        return this.getVarstaNumarApeluri;
    }
}
