import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persoana implements IPersoana {
    private String nume;
    private String CNP;

    public Persoana() {
        this.nume = "Popescu Ion";
        this.setCNP("1000000000001");
    }

    public Persoana(String nume, String CNP) {
        this.nume = nume;
        this.setCNP(CNP);
    }

    public String getCNP() {
        return this.CNP;
    }

    public void setCNP(String CNP) {
        if (CNP == null || CNP.isEmpty()) {
            throw new IllegalArgumentException("CNP-ul nu poate fi null sau necompletat.");
        }
        this.CNP = CNP;
    }

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String getSex() {
        return switch (CNP.charAt(0)) {
            case '1', '3', '5', '7' -> "M";
            case '2', '4', '6', '8' -> "F";
            default -> throw new IllegalArgumentException("Prima cifră din CNP este invalidă: " + this.CNP);
        };
    }

    @Override
    public int getVarsta() {
        int bazaSecol = switch (this.CNP.charAt(0)) {
            case '1', '2' -> 1900;
            case '3', '4' -> 1800;
            case '5', '6' -> 2000;
            default -> throw new IllegalArgumentException("Prima cifră din CNP este invalidă: " + this.CNP);
        };

        int anNastere = bazaSecol + Integer.parseInt(this.CNP.substring(1, 3));
        int lunaNastere = Integer.parseInt(this.CNP.substring(3, 5));
        int ziNastere = Integer.parseInt(this.CNP.substring(5, 7));

        LocalDate ziuaNastere = LocalDate.of(anNastere, lunaNastere, ziNastere);
        LocalDate ziuaCurenta = LocalDate.now();

        if (!ziuaCurenta.isBefore(ziuaNastere)) {
            return (int) ChronoUnit.YEARS.between(ziuaNastere, ziuaCurenta);
        }

        throw new IllegalArgumentException("Ziua de naștere nu poate fi în viitor: " + ziuaNastere);
    }

    @Override
    public boolean checkCNP() {
        if (this.CNP.length() != 13)
            throw new IllegalArgumentException("CNP-ul trebuie să conțină exact 13 cifre: " + this.CNP);

        final String COMPONENTA_C = "279146358279";

        try {
            int suma = 0;

            for (int i = 0; i < COMPONENTA_C.length(); i++) {
                suma += Character.getNumericValue(this.CNP.charAt(i))
                        * Character.getNumericValue(COMPONENTA_C.charAt(i));
            }

            int cifraControl = suma % 11;

            if (cifraControl == 10) {
                cifraControl = 1;
            }

            return cifraControl == Character.getNumericValue(this.CNP.charAt(12));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("CNP-ul trebuie să conțină doar cifre: " + this.CNP);
        }
    }
}