package clase;

import exceptii.CnpInvalidException;
import exceptii.DataNastereInvalidaException;
import exceptii.NumeInvalidException;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CetateanRomanTest {

    // ================================
    // Fixtures
    // ================================

    private static final String CNP_BARBAT_1990 = "1900522400993";
    private static final String CNP_FEMEIE_1990 = "2900522409289";
    private static final String CNP_VARSTNIC_1960 = "1600522402277";
    private static final String CNP_NOU_NASCUT = "5260522405291"; // Seminarul a avut loc pe data de 22.05.2026

    private static final String CNP_NULL = null;
    private static final String CNP_GOL = "";
    private static final String CNP_PREA_SCURT = "190052240099";
    private static final String CNP_PREA_LUNG = "19005224009931";
    private static final String CNP_CU_LITERE = "190052240099A";
    private static final String CNP_PRIMA_CIFRA_INVALIDA = "9100522405099";
    private static final String CNP_NASCUT_VIITOR = "5990522406530";

    private static final LocalDate DATA_REFERINTA_SEMINAR = LocalDate.of(2026, 5, 22);
    private static final LocalDate DATA_REFERINTA_TRECUT = LocalDate.of(1940, 5, 22);

    private CetateanRoman cetateanRomanBarbat;
    private CetateanRoman cetateanRomanFemeie;
    private CetateanRoman cetateanRomanVarstnic;
    private CetateanRoman cetateanRomanNouNascut;

    // ================================
    // SETUP & TEARDOWN
    // ================================

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Pregătiri generale înainte de toate testele CetateanRoman");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Se efectuează pregătirile pentru un test: se initițializează cetățean român bărbat, cetățean român femeie, cetățean român vârstnic și cetățean român nou născut");
        this.cetateanRomanBarbat = new CetateanRoman("Andrei", CNP_BARBAT_1990);
        this.cetateanRomanFemeie = new CetateanRoman("Maria", CNP_FEMEIE_1990);
        this.cetateanRomanVarstnic = new CetateanRoman("Andreea", CNP_VARSTNIC_1960);
        this.cetateanRomanNouNascut = new CetateanRoman("Alex", CNP_NOU_NASCUT);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Se efectuează curățenia de după un test: se șterg cetățean român bărbat, cetățean român femeie, cetățean român vârstnic și cetățean român nou născut");
        this.cetateanRomanBarbat = null;
        this.cetateanRomanFemeie = null;
        this.cetateanRomanVarstnic = null;
        this.cetateanRomanNouNascut = null;
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Curățenie generală după toate testele CetateanRoman");
    }

    // ================================
    // Teste
    // ================================

    @Disabled("Test ignorat pentru moment")
    @Test
    void testInLucru() {
    }

    @Disabled
    @Test
    void testCareEsueazaIntentionat() {
        fail("Eșuare intenționată");
    }

    // ================================
    // RIGHT BICEP
    // ================================

    // [R] RIGHT

    @Tag("important")
    @Tag("right")
    @Test
    void getNumeShouldReturnCorrectNume() {
        assertEquals("Andrei", this.cetateanRomanBarbat.getNume(), "Getter-ul pentru nume ar trebui să returneze valoarea corectă setată în obiect");
    }

    @Tag("right")
    @Test
    void getSexShouldReturnMaleForOddFirstDigit() {
        assertEquals("M", this.cetateanRomanBarbat.getSex(), "Sexul ar trebui determinat corect din CNP (M pentru prima cifră impară)");
    }

    @Tag("right")
    @Test
    void getSexShouldReturnFemaleForEvenFirstDigit() {
        assertEquals("F", this.cetateanRomanFemeie.getSex());
    }

    @Tag("right")
    @Test
    void getVarstaLaShouldReturnCorrectAge() {
        assertEquals(36, this.cetateanRomanBarbat.getVarstaLa(DATA_REFERINTA_SEMINAR));
    }

    @Tag("right")
    @Test
    void getVarstaLaShouldReturnCorrectAgeAtReferenceDate() {
        assertEquals(66, this.cetateanRomanVarstnic.getVarstaLa(DATA_REFERINTA_SEMINAR));
    }

    // [B] BOUNDARY

    @Tag("boundary")
    @Test
    void getVarstaLaShouldReturnZeroWhenBirthDateEqualsReferenceDate() {
        assertEquals(0, this.cetateanRomanNouNascut.getVarstaLa(DATA_REFERINTA_SEMINAR));

    }

    @Tag("boundary")
    @Test
    void getVarstaShouldReturnCorrectAgeForCenturyLowerBoundary2000() {
        CetateanRoman cetatean2000 = new CetateanRoman("Andrei", "5000101408797");
        assertEquals(26, cetatean2000.getVarstaLa(DATA_REFERINTA_SEMINAR));
    }

    @Tag("boundary")
    @Test
    void getVarstaShouldReturnCorrectAgeForCenturyUpperBoundary1900() {
        CetateanRoman cetatean1999 = new CetateanRoman("Andrei", "1991231408070");
        assertEquals(26, cetatean1999.getVarstaLa(DATA_REFERINTA_SEMINAR));
    }

    @Tag("boundary")
    @Test
    void getVarstaShouldReturnCorrectAgeForCenturyLowerBoundary1900() {
        CetateanRoman cetatean1900 = new CetateanRoman("Andrei", "1000101405866");
        assertEquals(126, cetatean1900.getVarstaLa(DATA_REFERINTA_SEMINAR));
    }

    @Tag("boundary")
    @Test
    void getVarstaShouldReturnCorrectAgeForCenturyUpperBoundary1800() {
        CetateanRoman cetatean1899 = new CetateanRoman("Andrei", "3991231400071");
        assertEquals(126, cetatean1899.getVarstaLa(DATA_REFERINTA_SEMINAR));
    }

    // [I] INVERSE RELATIONSHIP

    @Tag("inverse")
    @Test
    void setAndGetNumeShouldBeInverse() {
        this.cetateanRomanBarbat.setNume("Ion");
        assertEquals("Ion", this.cetateanRomanBarbat.getNume());
    }

    @Tag("inverse")
    @Test
    void setAndGetCnpShouldBeInverse() {
        this.cetateanRomanFemeie.setCnp(CNP_VARSTNIC_1960);
        assertEquals(CNP_VARSTNIC_1960, this.cetateanRomanFemeie.getCnp());
    }

    // [C] CROSS-CHECK

    @Tag("crosscheck")
    @Test
    void getVarstaCrossCheck() {
        int varstaGetVarsta = this.cetateanRomanBarbat.getVarsta();
        int varstaGetVarstaLa = this.cetateanRomanBarbat.getVarstaLa(LocalDate.now());
        assertEquals(varstaGetVarstaLa, varstaGetVarsta);
    }

    @Tag("crosscheck")
    @Test
    void getSexCrossCheck() {
        char primaCifra = this.cetateanRomanBarbat.getCnp().charAt(0);
        String sexAsteptat = (primaCifra == '1' || primaCifra == '3'
                || primaCifra == '5' || primaCifra == '7') ? "M" : "F";
        assertEquals(sexAsteptat, this.cetateanRomanBarbat.getSex());
    }

    @Tag("crosscheck")
    @Test
    void getVarstaLaCrossCheck() {
        int varstaMetoda = this.cetateanRomanVarstnic.getVarstaLa(DATA_REFERINTA_SEMINAR);
        int anNastere = 1900 + Integer.parseInt(CNP_VARSTNIC_1960.substring(1, 3));
        int varstaManual = DATA_REFERINTA_SEMINAR.getYear() - anNastere;
        assertEquals(varstaManual, varstaMetoda);
    }

    // [E] ERROR CONDITIONS

    @Tag("error")
    @Test
    void constructorShouldThrowForNullCnp() {
        assertThrows(CnpInvalidException.class, () -> new CetateanRoman("Andrei", CNP_NULL));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForEmptyCnp() {
        assertThrows(CnpInvalidException.class, () -> new CetateanRoman("Andrei", CNP_GOL));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForCnpTooShort() {
        assertThrows(CnpInvalidException.class, () -> new CetateanRoman("Andrei", CNP_PREA_SCURT));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForCnpTooLong() {
        assertThrows(CnpInvalidException.class, () -> new CetateanRoman("Andrei", CNP_PREA_LUNG));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForCnpWithLetters() {
        assertThrows(CnpInvalidException.class, () -> new CetateanRoman("Andrei", CNP_CU_LITERE));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForNullNume() {
        assertThrows(NumeInvalidException.class, () -> new CetateanRoman(null, CNP_BARBAT_1990));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForEmptyNume() {
        assertThrows(NumeInvalidException.class, () -> new CetateanRoman("", CNP_BARBAT_1990));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForInvalidFirstDigit() {
        assertThrows(CnpInvalidException.class, () -> new CetateanRoman("Andrei", CNP_PRIMA_CIFRA_INVALIDA));
    }

    @Tag("error")
    @Test
    void getVarstaLaShouldThrowWhenReferenceDateIsBeforeBirthDate() {
        assertThrows(DataNastereInvalidaException.class, () -> this.cetateanRomanBarbat.getVarstaLa(DATA_REFERINTA_TRECUT));
    }

    @Tag("error")
    @Test
    void getVarstaShouldThrowWhenBirthDateIsInFuture() {
        CetateanRoman cetateanRoman = new CetateanRoman("Andrei", CNP_NASCUT_VIITOR);
        assertThrows(DataNastereInvalidaException.class, cetateanRoman::getVarsta);
    }

    // [P] PERFORMANCE

    @Tag("performance")
    @Test
    void getVarstaShouldRunWithinTimeLimit() {
        assertTimeout(Duration.ofMillis(100), this.cetateanRomanBarbat::getVarsta);
    }

    @Tag("performance")
    @Test
    void getSexShouldRunWithinTimeLimit() {
        assertTimeout(Duration.ofMillis(100), this.cetateanRomanFemeie::getSex);
    }

    // ================================
    // CORRECT
    // ================================

    // [C] CONFORMANCE

    @Tag("conformance")
    @Test
    void getCNPShouldReturn13Characters() {
        assertEquals(13, this.cetateanRomanBarbat.getCnp().length());
    }

    @Tag("conformance")
    @Test
    void getSexShouldReturnSingleCharacter() {
        assertEquals(1, this.cetateanRomanBarbat.getSex().length());
    }

    @Tag("conformance")
    @Test
    void getSexShouldReturnOnlyMOrF() {
        assertTrue(this.cetateanRomanBarbat.getSex().equals("M") || this.cetateanRomanBarbat.getSex().equals("F"));
    }

    // [O] ORDERING

    // Nu se aplică natural la CetateanRoman deoarece nu conține colecții

    // [R] RANGE

    @Tag("range")
    @Test
    void getVarstaShouldReturnNonNegativeAge() {
        assertTrue(this.cetateanRomanBarbat.getVarsta() >= 0);
    }

    @Tag("range")
    @Test
    void getVarstaShouldNotExceedYearsSince1800() {
        // Cea mai veche dată de naștere posibilă a unui CNP românesc este 01 ianuarie 1800
        int varstMaximaPosibila = LocalDate.now().getYear() - 1800;
        CetateanRoman cetateanRoman = new CetateanRoman("Andrei", "3000101404868");
        assertTrue(cetateanRoman.getVarsta() <= varstMaximaPosibila);
    }

    // [R] REFERENCE

    // Nu se aplică natural la CetateanRoman deoarece nu are dependințe externe

    // [E] EXISTENCE

    // Existence și Error se suprapun complet în clasa CetateanRoman

    // [C] CARDINALITY

    // Nu se aplică natural la CetateanRoman deoarece nu conține colecții

    // [T] TIME

    // Nu se aplică natural la CetateanRoman deoarece nu există un flux obligatoriu de apeluri
}
