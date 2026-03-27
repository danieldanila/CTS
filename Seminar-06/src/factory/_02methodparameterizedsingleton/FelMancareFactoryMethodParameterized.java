package factory._02methodparameterizedsingleton;

public abstract class FelMancareFactoryMethodParameterized {
    public abstract FelMancare getFelMancare(TipFelMancare tipFelMancare, String denumire);

    public abstract FelMancare getFelMancare(TipFelMancare tipFelMancare, String denumire, Double gramaj);
}