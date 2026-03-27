import builder._01fieldsingleton.Rezervare;
import builder._01fieldsingleton.RezervareBuilderSingleton;

void main() {
    RezervareBuilderSingleton rezervareBuilder = RezervareBuilderSingleton.getInstanta();

    Rezervare rezervare1 = rezervareBuilder
            .resetare()
            .setAreAsezareGeam(true)
            .setAreScaunErgonomic(true)
            .setGenMuzica("Clasica")
            .build();
    System.out.println(rezervare1);

    Rezervare rezervare2 = rezervareBuilder
            .resetare()
            .setAreMasaDecorata(true)
            .setAreMuzicaAmbientalaPersonalizata(true)
            .setGenMuzica("Pop")
            .build();
    System.out.println(rezervare2);
}