import observer.Pacient;
import observer.Spital;

void main() {
    Spital spital = new Spital("Spital Epidemiologic");

    Pacient pacient1 = new Pacient("Ion");
    Pacient pacient2 = new Pacient("Mihai");
    Pacient pacient3 = new Pacient("Ana");

    spital.adaugaObserver(pacient1);
    spital.adaugaObserver(pacient2);
    spital.adaugaObserver(pacient3);

    spital.notificaEpidemie("Virus periculos");

    spital.stergeObserver(pacient2);

    spital.notificaEpidemie("Virous extraordinar de periculos");
}