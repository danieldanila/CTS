package factory._02methodparameterizedsingleton;

public class FelMancareDesertFactoryMethodParameterized extends FelMancareFactoryMethodParameterized {
    private static FelMancareDesertFactoryMethodParameterized instanta = null;

    private FelMancareDesertFactoryMethodParameterized() {
    }

    public static synchronized FelMancareDesertFactoryMethodParameterized getInstanta() {
        if (FelMancareDesertFactoryMethodParameterized.instanta == null) {
            FelMancareDesertFactoryMethodParameterized.instanta = new FelMancareDesertFactoryMethodParameterized();
        }
        return FelMancareDesertFactoryMethodParameterized.instanta;
    }

    @Override
    public FelMancare getFelMancare(TipFelMancare tipFelMancare, String denumire) {
        return switch (tipFelMancare) {
            case TipDesert.PAPANASI -> new Papanasi(denumire);
            case TipDesert.CLATITE -> new Clatite(denumire);
            default -> throw new IllegalArgumentException("Tipul desertului transmis nu există.");
        };
    }

    @Override
    public FelMancare getFelMancare(TipFelMancare tipFelMancare, String denumire, Double gramaj) {
        return switch (tipFelMancare) {
            case TipDesert.CHEESECAKE -> new Cheesecake(denumire, gramaj);
            default -> this.getFelMancare(tipFelMancare, denumire);
        };
    }
}