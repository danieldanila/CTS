import builder._03inner.PacientDirector;
import builder._03inner.Pacient;

void main() {
    Pacient pacient1 = new Pacient.Builder()
            .setNume("Matei")
            .setAreMicDejunInclus(true)
            .build();
    System.out.println(pacient1);

    Pacient pacient2 = new Pacient.Builder()
            .setNume("Ionut")
            .setArePatRabatabil(true)
            .setAreMicDejunInclus(true)
            .setArePapuciDeCamera(true)
            .setAreHalatPentruInterior(true)
            .build();
    System.out.println(pacient2);

    PacientDirector director = new PacientDirector();

    Pacient pacientPremium = director.buildPacientPremium("Andreea");
    System.out.println(pacientPremium);

    Pacient pacientStandard = director.buildPacientStandard("Ioana");
    System.out.println(pacientStandard);
}