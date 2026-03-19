package factory._03methodparameterized;

public class PersonalSpitalNonMedicalFactoryParameterized extends PersonalSpitalFactoryMethodParameterized {
    @Override
    public PersonalSpital getPersonalSpital(TipPersonalSpital tipPersonalSpital) {
        return switch (tipPersonalSpital) {
            case TipPersonalSpitalNonMedical.REGISTRATOR -> new Registrator();
            case TipPersonalSpitalNonMedical.SECRETAR -> new Secretar();
            default -> throw new IllegalArgumentException("Tipul personal spital transmis nu există.");
        };
    }
}