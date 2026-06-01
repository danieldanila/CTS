package clase;

import exceptii.CnpInvalidException;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CnpValidatorTest {

    // ================================
    // Fixtures
    // ================================

    private static final String CNP_VALID_BARBAT = "1900522400993";
    private static final String CNP_VALID_FEMEIE = "2900522409289";
    private static final String CNP_VALID_CHECKSUM_10 = "5000522401581";

    private static final String CNP_NULL = null;
    private static final String CNP_GOL = "";
    private static final String CNP_PREA_SCURT = "190052240099";
    private static final String CNP_PREA_LUNG = "19005224009931";
    private static final String CNP_CU_LITERE = "190052240099A";
    private static final String CNP_PRIMA_CIFRA_0 = "0100522405999";
    private static final String CNP_PRIMA_CIFRA_9 = "9100522405099";
    private static final String CNP_CHECKSUM_INVALID = "1900522400991";

    private CnpValidator validator;

    // ================================
    // SETUP & TEARDOWN
    // ================================

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Pregătiri generale înainte de toate testele CnpValidator");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Se efectuează pregătirile pentru un test: se initițializează validatorul de CNP");
        this.validator = new CnpValidator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Se efectuează curățenia de după un test: se șterge validatorul de CNP");
        this.validator = null;
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Curățenie generală după toate testele CnpValidator");
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
    void valideazaCnpShouldNotThrowForValidMaleCnp() {
        assertDoesNotThrow(() -> this.validator.valideazaCnp(CNP_VALID_BARBAT), "Un CNP valid pentru persoană de sex masculin nu ar trebui să arunce excepții");
    }

    @Tag("right")
    @Test
    void valideazaCnpShouldNotThrowForValidFemaleCnp() {
        assertDoesNotThrow(() -> this.validator.valideazaCnp(CNP_VALID_FEMEIE), "Un CNP valid pentru persoană de sex feminin nu ar trebui să arunce excepții");
    }

    @Tag("right")
    @Test
    void valideazaCnpShouldNotThrowWhenChecksumIs10() {
        assertDoesNotThrow(() -> this.validator.valideazaCnp(CNP_VALID_CHECKSUM_10));
    }

    // [B] BOUNDARY

    @Tag("boundary")
    @Test
    void valideazaCnpShouldThrowForCnpOf12Characters() {
        assertThrows(CnpInvalidException.class, () -> this.validator.valideazaCnp(CNP_PREA_SCURT));
    }

    @Tag("boundary")
    @Test
    void valideazaCnpShouldThrowForCnpOf14Characters() {
        assertThrows(CnpInvalidException.class, () -> this.validator.valideazaCnp(CNP_PREA_LUNG));
    }

    @Tag("boundary")
    @Test
    void valideazaCnpShouldNotThrowForCnpOfExactly13Characters() {
        assertDoesNotThrow(() -> this.validator.valideazaCnp(CNP_VALID_BARBAT));
    }

    // [I] INVERSE RELATIONSHIP

    // Nu se aplică natural la CnpValidator deoarece nu există operații matematice inversabile

    // [C] CROSS-CHECK

    @Tag("crosscheck")
    @Test
    void valideazaCnpCrossCheck() {
        String controlKey = "279146358279";
        int checksum = 0;
        for (int i = 0; i < controlKey.length(); i++) {
            checksum += Character.getNumericValue(CNP_VALID_BARBAT.charAt(i))
                    * Character.getNumericValue(controlKey.charAt(i));
        }
        int cifraControl = checksum % 11 == 10 ? 1 : checksum % 11;
        boolean rezultatAsteptat = cifraControl == Character.getNumericValue(CNP_VALID_BARBAT.charAt(12));

        assertTrue(rezultatAsteptat);
        assertDoesNotThrow(() -> this.validator.valideazaCnp(CNP_VALID_BARBAT));
    }

    // [E] ERROR CONDITIONS

    @Tag("error")
    @Test
    void valideazaCnpShouldThrowForNullCnp() {
        assertThrows(CnpInvalidException.class, () -> this.validator.valideazaCnp(CNP_NULL));
    }

    @Tag("error")
    @Test
    void valideazaCnpShouldThrowForEmptyCnp() {
        assertThrows(CnpInvalidException.class, () -> this.validator.valideazaCnp(CNP_GOL));
    }

    @Tag("error")
    @Test
    void valideazaCnpShouldThrowForCnpWithLetters() {
        assertThrows(CnpInvalidException.class, () -> this.validator.valideazaCnp(CNP_CU_LITERE));
    }

    @Tag("error")
    @Test
    void valideazaCnpShouldThrowForInvalidFirstDigit0() {
        assertThrows(CnpInvalidException.class, () -> this.validator.valideazaCnp(CNP_PRIMA_CIFRA_0));
    }

    @Tag("error")
    @Test
    void valideazaCnpShouldThrowForInvalidFirstDigit9() {
        assertThrows(CnpInvalidException.class, () -> this.validator.valideazaCnp(CNP_PRIMA_CIFRA_9));
    }

    @Tag("error")
    @Test
    void valideazaCnpShouldThrowForInvalidChecksum() {
        assertThrows(CnpInvalidException.class, () -> this.validator.valideazaCnp(CNP_CHECKSUM_INVALID));
    }

    // [P] PERFORMANCE

    @Tag("performance")
    @Test
    void valideazaCnpShouldRunWithinTimeLimit() {
        assertTimeout(Duration.ofMillis(100), () -> this.validator.valideazaCnp(CNP_VALID_BARBAT));
    }

    // ================================
    // CORRECT
    // ================================

    // [C] CONFORMANCE

    // Conformance și Error se suprapun complet în clasa CnpValidator

    // [O] ORDERING

    // Nu se aplică natural la CnpValidator deoarece nu conține colecții

    // [R] RANGE

    @Tag("range")
    @Test
    void valideazaCnpShouldAcceptFirstDigit1() {
        assertDoesNotThrow(() -> this.validator.valideazaCnp("1990522403976"));
    }

    @Tag("range")
    @Test
    void valideazaCnpShouldAcceptFirstDigit8() {
        assertDoesNotThrow(() -> this.validator.valideazaCnp("8000522409397"));
    }

    // [R] REFERENCE

    // Nu se aplică natural la CnpValidator deoarece nu are dependințe externe

    // [E] EXISTENCE

    // Existence și Error se suprapun complet în clasa CnpValidator

    // [C] CARDINALITY

    // Nu se aplică natural la CnpValidator deoarece nu conține colecții

    // [T] TIME

    // Nu se aplică natural la CnpValidator deoarece nu există un flux obligatoriu de apeluri
}
