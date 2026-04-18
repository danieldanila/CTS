package proxy;

public class SpitalProxy implements ISpital {
    private final ISpital spital;

    public SpitalProxy(ISpital spital) {
        this.spital = spital;
    }

    @Override
    public void interneaza(Pacient pacient) {
        if (pacient.areAsigurareSanatate()) {
            this.spital.interneaza(pacient);
        } else {
            System.out.println("Pacientul " + pacient.getNume() + " nu are asigurare de sanatate. Internare refuzata.");
        }
    }
}