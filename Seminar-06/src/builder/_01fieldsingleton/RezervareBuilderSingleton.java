package builder._01fieldsingleton;

public class RezervareBuilderSingleton extends Builder {
    private static RezervareBuilderSingleton instanta = null;

    private boolean areAsezareGeam;
    private boolean areScaunErgonomic;
    private boolean areMasaDecorata;
    private boolean areMuzicaAmbientalaPersonalizata;
    private String genMuzica;

    private RezervareBuilderSingleton() {
        this.resetare();
    }

    public static synchronized RezervareBuilderSingleton getInstanta() {
        if (RezervareBuilderSingleton.instanta == null) {
            RezervareBuilderSingleton.instanta = new RezervareBuilderSingleton();
        }
        return RezervareBuilderSingleton.instanta;
    }

    @Override
    public Rezervare build() {
        return new Rezervare(this.areAsezareGeam, this.areScaunErgonomic,
                this.areMasaDecorata, this.areMuzicaAmbientalaPersonalizata, this.genMuzica);
    }

    public RezervareBuilderSingleton resetare() {
        this.areAsezareGeam = false;
        this.areScaunErgonomic = false;
        this.areMasaDecorata = false;
        this.areMuzicaAmbientalaPersonalizata = false;
        this.genMuzica = "Necunoscut";
        return this;
    }

    public RezervareBuilderSingleton setAreAsezareGeam(boolean areAsezareGeam) {
        this.areAsezareGeam = areAsezareGeam;
        return this;
    }

    public RezervareBuilderSingleton setAreScaunErgonomic(boolean areScaunErgonomic) {
        this.areScaunErgonomic = areScaunErgonomic;
        return this;
    }

    public RezervareBuilderSingleton setAreMasaDecorata(boolean areMasaDecorata) {
        this.areMasaDecorata = areMasaDecorata;
        return this;
    }

    public RezervareBuilderSingleton setAreMuzicaAmbientalaPersonalizata(boolean areMuzicaAmbientalaPersonalizata) {
        this.areMuzicaAmbientalaPersonalizata = areMuzicaAmbientalaPersonalizata;
        return this;
    }

    public RezervareBuilderSingleton setGenMuzica(String genMuzica) {
        this.genMuzica = genMuzica;
        return this;
    }
}