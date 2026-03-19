package factory._02method;

public class MedicFactory extends PersonalSpitalFactoryMethod {
    @Override
    public PersonalSpital getPersonalSpital() {
        return new Medic();
    }
}