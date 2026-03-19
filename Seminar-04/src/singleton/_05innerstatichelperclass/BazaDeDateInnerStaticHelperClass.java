package singleton._05innerstatichelperclass;

import java.util.StringJoiner;

public class BazaDeDateInnerStaticHelperClass {
    private String denumire;
    private int numarCampuri;

    private static class BazaDeDateHelper {
        private static final BazaDeDateInnerStaticHelperClass intanta = new BazaDeDateInnerStaticHelperClass("Baza-Inner-01", 2);
    }

    public static BazaDeDateInnerStaticHelperClass getInstanta() {
        return BazaDeDateHelper.intanta;
    }

    private BazaDeDateInnerStaticHelperClass(String denumire, int numarCampuri) {
        this.denumire = denumire;
        this.numarCampuri = numarCampuri;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BazaDeDateInnerStaticHelperClass.class.getSimpleName() + "[", "]")
                .add("denumire='" + this.denumire + "'")
                .add("numarCampuri=" + this.numarCampuri)
                .toString();
    }
}