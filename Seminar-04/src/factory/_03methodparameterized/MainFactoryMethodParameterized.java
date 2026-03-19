import factory._03methodparameterized.*;

void main() {
    PersonalSpitalFactoryMethodParameterized personalSpitalMedicalFactoryMethodParameterized = new PersonalSpitalMedicalFactoryParameterized();
    PersonalSpital medic = personalSpitalMedicalFactoryMethodParameterized.getPersonalSpital(TipPersonalSpitalMedical.MEDIC);
    medic.afiseazaOcupatia();

    PersonalSpitalFactoryMethodParameterized personalSpitalNonMedicalFactoryMethodParameterized = new PersonalSpitalNonMedicalFactoryParameterized();
    PersonalSpital secretar = personalSpitalNonMedicalFactoryMethodParameterized.getPersonalSpital(TipPersonalSpitalNonMedical.SECRETAR);
    secretar.afiseazaOcupatia();

    // Va genera o excepție deoarece clasa Asistent nu poate fi creată în factory-ul non medical
    PersonalSpital asistent = personalSpitalNonMedicalFactoryMethodParameterized.getPersonalSpital(TipPersonalSpitalMedical.ASISTENT);
    asistent.afiseazaOcupatia();
}