package builder._01reference;

public class PacientBuilder implements IPacientBuilder {
    private Pacient pacient;

    public PacientBuilder() {
        this.pacient = new Pacient();
    }

    @Override
    public Pacient build() {
        return this.pacient;
    }

    @Override
    public IPacientBuilder setNume(String nume) {
        this.pacient.setNume(nume);
        return this;
    }

    @Override
    public IPacientBuilder setArePatRabatabil(boolean arePatRabatabil) {
        this.pacient.setArePatRabatabil(arePatRabatabil);
        return this;
    }

    @Override
    public IPacientBuilder setAreMicDejunInclus(boolean areMicDejunInclus) {
        this.pacient.setAreMicDejunInclus(areMicDejunInclus);
        return this;
    }

    @Override
    public IPacientBuilder setArePapuciDeCamera(boolean arePapuciDeCamera) {
        this.pacient.setArePapuciDeCamera(arePapuciDeCamera);
        return this;
    }

    @Override
    public IPacientBuilder setAreHalatPentruInterior(boolean areHalatPentruInterior) {
        this.pacient.setAreHalatPentruInterior(areHalatPentruInterior);
        return this;
    }
}