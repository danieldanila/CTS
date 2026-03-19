import factory._02method.*;

void main() {
    PersonalSpitalFactoryMethod asistentFactory = new AsistentFactory();
    PersonalSpital asistent = asistentFactory.getPersonalSpital();
    asistent.afiseazaOcupatia();

    PersonalSpitalFactoryMethod medicFactory = new MedicFactory();
    PersonalSpital medic = medicFactory.getPersonalSpital();
    medic.afiseazaOcupatia();

    PersonalSpitalFactoryMethod brancardierFactory = new BrancardierFactory();
    PersonalSpital brancardier = brancardierFactory.getPersonalSpital();
    brancardier.afiseazaOcupatia();
}