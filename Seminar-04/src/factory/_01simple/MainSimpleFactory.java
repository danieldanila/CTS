import factory._01simple.PersonalSpitalSimpleFactory;
import factory._01simple.PersonalSpital;
import factory._01simple.TipPersonalSpital;

void main() {
    PersonalSpital asistent = PersonalSpitalSimpleFactory.getPersonalSpital(TipPersonalSpital.ASISTENT);
    asistent.afiseazaOcupatia();

    PersonalSpital medic = PersonalSpitalSimpleFactory.getPersonalSpital(TipPersonalSpital.MEDIC);
    medic.afiseazaOcupatia();

    PersonalSpital brancardier = PersonalSpitalSimpleFactory.getPersonalSpital(TipPersonalSpital.BRANCARDIER);
    brancardier.afiseazaOcupatia();
}