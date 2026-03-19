package factory._03methodparameterized;

public class PersonalSpitalMedicalFactoryParameterized extends PersonalSpitalFactoryMethodParameterized {
    @Override
    public PersonalSpital getPersonalSpital(TipPersonalSpital tipPersonalSpital) {
        return switch (tipPersonalSpital) {
            case TipPersonalSpitalMedical.ASISTENT -> new Asistent();
            case TipPersonalSpitalMedical.MEDIC -> new Medic();
            case TipPersonalSpitalMedical.BRANCARDIER -> new Brancardier();
            default -> throw new IllegalArgumentException("Tipul personal spital transmis nu există.");
        };
    }
}