package builder._02field;

public class PacientBuilder implements IPacientBuilder {
    private String numePacient;
    private boolean arePatRabatabil;
    private boolean areMicDejunInclus;
    private boolean arePapuciDeCamera;
    private boolean areHalatPentruInterior;

    public PacientBuilder() {
        this.numePacient = "Anonim";
        this.arePatRabatabil = false;
        this.areMicDejunInclus = false;
        this.arePapuciDeCamera = false;
        this.areHalatPentruInterior = false;
    }

    @Override
    public Pacient build() {
        return new Pacient(this.numePacient, this.arePatRabatabil, this.areMicDejunInclus, this.arePapuciDeCamera, this.areHalatPentruInterior);
    }

    @Override
    public IPacientBuilder setNume(String nume) {
        this.numePacient = nume;
        return this;
    }

    @Override
    public IPacientBuilder setArePatRabatabil(boolean arePatRabatabil) {
        this.arePatRabatabil = arePatRabatabil;
        return this;
    }

    @Override
    public IPacientBuilder setAreMicDejunInclus(boolean areMicDejunInclus) {
        this.areMicDejunInclus = areMicDejunInclus;
        return this;
    }

    @Override
    public IPacientBuilder setArePapuciDeCamera(boolean arePapuciDeCamera) {
        this.arePapuciDeCamera = arePapuciDeCamera;
        return this;
    }

    @Override
    public IPacientBuilder setAreHalatPentruInterior(boolean areHalatPentruInterior) {
        this.areHalatPentruInterior = areHalatPentruInterior;
        return this;
    }
}