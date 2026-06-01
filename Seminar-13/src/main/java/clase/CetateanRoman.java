package clase;

import exceptii.CnpInvalidException;
import exceptii.DataNastereInvalidaException;
import exceptii.NumeInvalidException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CetateanRoman implements IPersoana {
    private static final CnpValidator CNP_VALIDATOR = new CnpValidator();
    private static final int CNP_INDEX_AN_START = 1;
    private static final int CNP_INDEX_AN_STOP = 3;
    private static final int CNP_INDEX_LUNA_START = 3;
    private static final int CNP_INDEX_LUNA_STOP = 5;
    private static final int CNP_INDEX_ZI_START = 5;
    private static final int CNP_INDEX_ZI_STOP = 7;

    private String nume;
    private String cnp;

    public CetateanRoman(String nume, String cnp) {
        this.valideazaNume(nume);
        CNP_VALIDATOR.valideazaCnp(cnp);
        this.nume = nume;
        this.cnp = cnp;
    }

    @Override
    public String getNume() {
        return this.nume;
    }

    @Override
    public String getSex() {
        return switch (this.getPrimaCifra()) {
            case '1', '3', '5', '7' -> "M";
            case '2', '4', '6', '8' -> "F";
            default -> throw new CnpInvalidException("Prima cifră din CNP este invalidă: " + this.cnp);
        };
    }

    @Override
    public int getVarsta() {
        return this.getVarstaLa(LocalDate.now());
    }

    public int getVarstaLa(LocalDate dataReferinta) {
        LocalDate ziuaNastere = this.getDataNasterii();

        if (dataReferinta.isBefore(ziuaNastere)) {
            throw new DataNastereInvalidaException("Ziua de naștere " + ziuaNastere + " este după data de referință: " + dataReferinta);
        }

        return (int) ChronoUnit.YEARS.between(ziuaNastere, dataReferinta);
    }

    public void setNume(String nume) {
        this.valideazaNume(nume);
        this.nume = nume;
    }

    public String getCnp() {
        return this.cnp;
    }

    public void setCnp(String cnp) {
        CNP_VALIDATOR.valideazaCnp(cnp);
        this.cnp = cnp;
    }

    private LocalDate getDataNasterii() {
        int bazaSecol = this.getBazaSecol();

        int anNastere = bazaSecol + Integer.parseInt(this.cnp.substring(CNP_INDEX_AN_START, CNP_INDEX_AN_STOP));
        int lunaNastere = Integer.parseInt(this.cnp.substring(CNP_INDEX_LUNA_START, CNP_INDEX_LUNA_STOP));
        int ziNastere = Integer.parseInt(this.cnp.substring(CNP_INDEX_ZI_START, CNP_INDEX_ZI_STOP));

        return LocalDate.of(anNastere, lunaNastere, ziNastere);
    }

    private char getPrimaCifra() {
        return this.cnp.charAt(0);
    }

    private int getBazaSecol() {
        return switch (this.getPrimaCifra()) {
            case '1', '2' -> 1900;
            case '3', '4' -> 1800;
            case '5', '6' -> 2000;
            default -> throw new CnpInvalidException("Prima cifră din CNP este invalidă: " + this.cnp);
        };
    }

    private void valideazaNume(String nume) {
        if (nume == null || nume.isEmpty()) {
            throw new NumeInvalidException("Numele nu poate fi null sau necompletat");
        }
    }
}
