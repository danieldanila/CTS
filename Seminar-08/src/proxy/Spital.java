package proxy;

public class Spital implements ISpital {
    @Override
    public void interneaza(Pacient pacient) {
        System.out.println("Pacientul " + pacient.getNume() + " s-a internat cu succes.");
    }
}