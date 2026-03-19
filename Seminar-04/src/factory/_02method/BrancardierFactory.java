package factory._02method;

public class BrancardierFactory extends PersonalSpitalFactoryMethod {
    @Override
    public PersonalSpital getPersonalSpital() {
        return new Brancardier();
    }
}