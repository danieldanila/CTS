package builder._01fieldsingleton;

import java.util.StringJoiner;

public class Rezervare {
    private final boolean areAsezareGeam;
    private final boolean areScaunErgonomic;
    private final boolean areMasaDecorata;
    private final boolean areMuzicaAmbientalaPersonalizata;
    private final String genMuzica;

    protected Rezervare(boolean areAsezareGeam, boolean areScaunErgonomic,
                        boolean areMasaDecorata, boolean areMuzicaAmbientalaPersonalizata,
                        String genMuzica) {
        this.areAsezareGeam = areAsezareGeam;
        this.areScaunErgonomic = areScaunErgonomic;
        this.areMasaDecorata = areMasaDecorata;
        this.areMuzicaAmbientalaPersonalizata = areMuzicaAmbientalaPersonalizata;
        this.genMuzica = genMuzica;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Rezervare.class.getSimpleName() + "[", "]")
                .add("areAsezareGeam=" + this.areAsezareGeam)
                .add("areScaunErgonomic=" + this.areScaunErgonomic)
                .add("areMasaDecorata=" + this.areMasaDecorata)
                .add("areMuzicaAmbientalaPersonalizata=" + this.areMuzicaAmbientalaPersonalizata)
                .add("genMuzica='" + this.genMuzica + "'")
                .toString();
    }
}