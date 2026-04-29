import strategy.Pacient;
import strategy.PlataCard;
import strategy.PlataCash;

void main() {
    Pacient pacient = new Pacient("Andrei");
    pacient.plateste(10.0);

    pacient.setModPlata(new PlataCard());
    pacient.plateste(20.0);

    pacient.setModPlata(new PlataCash());
    pacient.plateste(30.0);
}