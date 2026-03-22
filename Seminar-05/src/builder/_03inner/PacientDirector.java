package builder._03inner;

public class PacientDirector {
    public Pacient buildPacientStandard(String nume) {
        return new Pacient.Builder()
                .setNume(nume)
                .setArePatRabatabil(true)
                .build();
    }

    public Pacient buildPacientPremium(String nume) {
        return new Pacient.Builder()
                .setNume(nume)
                .setArePatRabatabil(true)
                .setAreMicDejunInclus(true)
                .setArePapuciDeCamera(true)
                .setAreHalatPentruInterior(true)
                .build();
    }
}