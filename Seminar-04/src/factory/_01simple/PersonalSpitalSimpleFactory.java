package factory._01simple;

public class PersonalSpitalSimpleFactory {
    public static PersonalSpital getPersonalSpital(TipPersonalSpital tipPersonalSpital) {
        return switch (tipPersonalSpital) {
            case TipPersonalSpital.ASISTENT -> new Asistent();
            case TipPersonalSpital.MEDIC -> new Medic();
            case TipPersonalSpital.BRANCARDIER -> new Brancardier();
            default -> throw new IllegalArgumentException("Tipul personal spital transmis nu există.");
        };
    }
}