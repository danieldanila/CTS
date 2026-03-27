package factory._02methodparameterizedsingleton;

public class FelMancareSupaFactoryMethodParameterized extends FelMancareFactoryMethodParameterized {
    private static FelMancareSupaFactoryMethodParameterized instanta = null;

    private FelMancareSupaFactoryMethodParameterized() {
    }

    public static synchronized FelMancareSupaFactoryMethodParameterized getInstanta() {
        if (FelMancareSupaFactoryMethodParameterized.instanta == null) {
            FelMancareSupaFactoryMethodParameterized.instanta = new FelMancareSupaFactoryMethodParameterized();
        }
        return FelMancareSupaFactoryMethodParameterized.instanta;
    }

    @Override
    public FelMancare getFelMancare(TipFelMancare tipFelMancare, String denumire) {
        return switch (tipFelMancare) {
            case TipSupa.LEGUME -> new SupaLegume(denumire);
            case TipSupa.CIUPERCI -> new SupaCiuperci(denumire);
            default -> throw new IllegalArgumentException("Tipul supei transmis nu există.");
        };
    }

    @Override
    public FelMancare getFelMancare(TipFelMancare tipFelMancare, String denumire, Double gramaj) {
        return switch (tipFelMancare) {
            case TipSupa.VITA -> new SupaVita(denumire, gramaj);
            default -> this.getFelMancare(tipFelMancare, denumire);
        };
    }
}