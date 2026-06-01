package dubluri;

import clase.IPersoana;

public class StubPersoana implements IPersoana {
    @Override
    public String getNume() {
        return "Stub Persoana";
    }

    @Override
    public String getSex() {
        return "M";
    }

    @Override
    public int getVarsta() {
        return 21;
    }
}
