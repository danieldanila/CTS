package builder._03inner;

import java.util.StringJoiner;

public class Pacient {
    private final String nume;
    private final boolean arePatRabatabil;
    private final boolean areMicDejunInclus;
    private final boolean arePapuciDeCamera;
    private final boolean areHalatPentruInterior;

    private Pacient(Builder builder) {
        this.nume = builder.nume;
        this.arePatRabatabil = builder.arePatRabatabil;
        this.areMicDejunInclus = builder.areMicDejunInclus;
        this.arePapuciDeCamera = builder.arePapuciDeCamera;
        this.areHalatPentruInterior = builder.areHalatPentruInterior;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pacient.class.getSimpleName() + "[", "]")
                .add("nume='" + this.nume + "'")
                .add("arePatRabatabil=" + this.arePatRabatabil)
                .add("areMicDejunInclus=" + this.areMicDejunInclus)
                .add("arePapuciDeCamera=" + this.arePapuciDeCamera)
                .add("areHalatPentruInterior=" + this.areHalatPentruInterior)
                .toString();
    }

    public static class Builder {
        private String nume;
        private boolean arePatRabatabil;
        private boolean areMicDejunInclus;
        private boolean arePapuciDeCamera;
        private boolean areHalatPentruInterior;

        public Builder() {
            this.nume = "Anonim";
            this.arePatRabatabil = false;
            this.areMicDejunInclus = false;
            this.arePapuciDeCamera = false;
            this.areHalatPentruInterior = false;
        }

        public Pacient build() {
            return new Pacient(this);
        }

        public Builder setNume(String nume) {
            this.nume = nume;
            return this;
        }

        public Builder setArePatRabatabil(boolean arePatRabatabil) {
            this.arePatRabatabil = arePatRabatabil;
            return this;
        }

        public Builder setAreMicDejunInclus(boolean areMicDejunInclus) {
            this.areMicDejunInclus = areMicDejunInclus;
            return this;
        }

        public Builder setArePapuciDeCamera(boolean arePapuciDeCamera) {
            this.arePapuciDeCamera = arePapuciDeCamera;
            return this;
        }

        public Builder setAreHalatPentruInterior(boolean areHalatPentruInterior) {
            this.areHalatPentruInterior = areHalatPentruInterior;
            return this;
        }
    }
}