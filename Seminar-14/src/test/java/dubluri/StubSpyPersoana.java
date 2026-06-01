package dubluri;

import clase.IPersoana;

public class StubSpyPersoana implements IPersoana {
    private int getNumeNumarApeluri;
    private int getSexNumarApeluri;
    private int getVarstaNumarApeluri;

    public StubSpyPersoana() {
        this.getNumeNumarApeluri = 0;
        this.getSexNumarApeluri = 0;
        this.getVarstaNumarApeluri = 0;
    }

    @Override
    public String getNume() {
        this.getNumeNumarApeluri++;
        return "Stub Persoana";
    }

    @Override
    public String getSex() {
        this.getSexNumarApeluri++;
        return "M";
    }

    @Override
    public int getVarsta() {
        this.getVarstaNumarApeluri++;
        return 21;
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
