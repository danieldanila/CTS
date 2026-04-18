import proxy.ISpital;
import proxy.Pacient;
import proxy.Spital;
import proxy.SpitalProxy;

void main() {
    ISpital spital = new Spital();
    ISpital spitalProxy = new SpitalProxy(spital);

    Pacient pacient1 = new Pacient("Ion", true);
    Pacient pacient2 = new Pacient("Popescu", false);

    spital.interneaza(pacient1);
    spital.interneaza(pacient2);

    spitalProxy.interneaza(pacient1);
    spitalProxy.interneaza(pacient2);
}