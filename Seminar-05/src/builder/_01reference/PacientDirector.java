package builder._01reference;

public class PacientDirector {
    public Pacient buildPacientStandard(String nume) {
        return new PacientBuilder()
                .setNume(nume)
                .setArePatRabatabil(true)
                .build();
    }

    public Pacient buildPacientPremium(String nume) {
        return new PacientBuilder()
                .setNume(nume)
                .setArePatRabatabil(true)
                .setAreMicDejunInclus(true)
                .setArePapuciDeCamera(true)
                .setAreHalatPentruInterior(true)
                .build();
    }
}