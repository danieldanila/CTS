package factory._02method;

public class AsistentFactory extends PersonalSpitalFactoryMethod {
    @Override
    public PersonalSpital getPersonalSpital() {
        return new Asistent();
    }
}