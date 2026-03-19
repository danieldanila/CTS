package singleton._02staticblock;

import java.util.StringJoiner;

public class BazaDeDateStaticBlock {
    private String denumire;
    private int numarCampuri;

    private static BazaDeDateStaticBlock instanta;

    static {
        try {
            instanta = new BazaDeDateStaticBlock("Baza-Static-01", 2);
        } catch (Exception exception) {
            System.out.println("Eroare la crearea bazei de date.");
            exception.printStackTrace();
        }
    }

    public static BazaDeDateStaticBlock getInstanta() {
        return BazaDeDateStaticBlock.instanta;
    }

    private BazaDeDateStaticBlock(String denumire, int numarCampuri) {
        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateStaticBlock.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}