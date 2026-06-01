package clase;

import exceptii.DestinatieInvalidaException;
import exceptii.PersoanaInvalidaException;
import exceptii.PretInvalidException;
import exceptii.ProcentInvalidException;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PachetTuristicTest {

    // ================================
    // Fixtures
    // ================================

    private static final String CNP_ADULT = "1900522400993";
    private static final String CNP_NOU_NASCUT = "5260522405291";
    private static final String CNP_EXACT_17 = "5090522406146";
    private static final String CNP_EXACT_18 = "5080522403611";
    private static final String CNP_VARSTNIC = "1600522402277";
    private static final String CNP_EXACT_64 = "1620522401968";
    private static final String CNP_EXACT_65 = "1610522400933";

    private static final String DESTINATIE_VALIDA = "Paris";
    private static final double PRET_VALID = 1000.0;
    private static final double PRET_ZERO = 0.0;

    private CetateanRoman clientAdult;
    private CetateanRoman clientMinor;
    private CetateanRoman clientVarstnic;
    private PachetTuristic pachetAdult;
    private PachetTuristic pachetMinor;
    private PachetTuristic pachetVarstnic;

    // ================================
    // SETUP & TEARDOWN
    // ================================

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Pregătiri generale înainte de toate testele PachetTuristic");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Se efectuează pregătirile pentru un test: se initițializează client adult, client varstnic, client minor și un pachetele turistice");
        this.clientAdult = new CetateanRoman("Andrei", PachetTuristicTest.CNP_ADULT);
        this.clientVarstnic = new CetateanRoman("Maria", PachetTuristicTest.CNP_VARSTNIC);
        this.clientMinor = new CetateanRoman("Copil", PachetTuristicTest.CNP_NOU_NASCUT);
        this.pachetAdult = new PachetTuristic(this.clientAdult, DESTINATIE_VALIDA, PRET_VALID);
        this.pachetMinor = new PachetTuristic(this.clientMinor, DESTINATIE_VALIDA, PRET_VALID);
        this.pachetVarstnic = new PachetTuristic(this.clientVarstnic, DESTINATIE_VALIDA, PRET_VALID);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Se efectuează curățenia de după un test: se șterg client adult, client varstnic, client minor și un pachetele turistice");
        this.clientAdult = null;
        this.clientVarstnic = null;
        this.clientMinor = null;
        this.pachetAdult = null;
        this.pachetMinor = null;
        this.pachetVarstnic = null;
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Curățenie generală după toate testele PachetTuristic");
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
    void poateRezervaShouldReturnTrueForAdult() {
        assertTrue(this.pachetAdult.poateRezerva(), "Un pachet pentru adult ar trebui să permită rezervarea");
    }

    @Tag("right")
    @Test
    void poateRezervaShouldReturnFalseForMinor() {
        assertFalse(this.pachetMinor.poateRezerva(), "Un pachet pentru minor nu ar trebui să permită rezervarea");
    }

    @Tag("right")
    @Test
    void aplicaDiscountVarstiniciShouldReducePriceForElderlyClient() {
        this.pachetVarstnic.aplicaDiscountVarstnici(10);
        assertEquals(900, this.pachetVarstnic.getPret(), 0.01);
    }

    @Tag("right")
    @Test
    void aplicaDiscountVarstiniciShouldNotReducePriceForNonElderlyClient() {
        double pretInitial = this.pachetAdult.getPret();
        this.pachetAdult.aplicaDiscountVarstnici(10);
        assertEquals(pretInitial, this.pachetAdult.getPret());
    }

    @Tag("right")
    @Test
    void getClientShouldReturnCorrectClient() {
        assertEquals(this.clientAdult, this.pachetAdult.getClient());
    }

    @Tag("right")
    @Test
    void getDestinatieShouldReturnCorrectDestinatie() {
        assertEquals(DESTINATIE_VALIDA, this.pachetAdult.getDestinatie());
    }

    @Tag("right")
    @Test
    void getPretShouldReturnCorrectPret() {
        assertEquals(PRET_VALID, this.pachetAdult.getPret());
    }

    // [B] BOUNDARY

    @Tag("boundary")
    @Test
    void poateRezervaShouldReturnFalseForExactly17YearsOld() {
        CetateanRoman client17 = new CetateanRoman("Client 17", CNP_EXACT_17);
        PachetTuristic pachet17 = new PachetTuristic(client17, DESTINATIE_VALIDA, PRET_VALID);
        assertFalse(pachet17.poateRezerva());
    }

    @Tag("boundary")
    @Test
    void poateRezervaShouldReturnTrueForExactly18YearsOld() {
        IPersoana client18 = new CetateanRoman("Client 18", CNP_EXACT_18);
        PachetTuristic pachet18 = new PachetTuristic(client18, DESTINATIE_VALIDA, PRET_VALID);
        assertTrue(pachet18.poateRezerva());
    }

    @Tag("boundary")
    @Test
    void aplicaDiscountShouldApplyForExactly65YearsOld() {
        IPersoana client65 = new CetateanRoman("Client 65", CNP_EXACT_65);
        PachetTuristic pachet65 = new PachetTuristic(client65, DESTINATIE_VALIDA, PRET_VALID);
        double pretInitial = pachet65.getPret();
        pachet65.aplicaDiscountVarstnici(10);
        assertTrue(pachet65.getPret() < pretInitial);
    }

    @Tag("boundary")
    @Test
    void aplicaDiscountShouldNotApplyForExactly64YearsOld() {
        IPersoana client64 = new CetateanRoman("Client 64", CNP_EXACT_64);
        PachetTuristic pachet64 = new PachetTuristic(client64, DESTINATIE_VALIDA, PRET_VALID);
        double pretInitial = pachet64.getPret();
        pachet64.aplicaDiscountVarstnici(10);
        assertEquals(pretInitial, pachet64.getPret());
    }

    @Tag("boundary")
    @Test
    void aplicaDiscountShouldNotReducePretForProcentZero() {
        PachetTuristic pachetVarstnic = new PachetTuristic(this.clientVarstnic, DESTINATIE_VALIDA, PRET_VALID);
        double pretInitial = pachetVarstnic.getPret();
        pachetVarstnic.aplicaDiscountVarstnici(0);
        assertEquals(pretInitial, pachetVarstnic.getPret());
    }

    @Tag("boundary")
    @Test
    void aplicaDiscountShouldReducePretTo0ForProcent100() {
        PachetTuristic pachetVarstnic = new PachetTuristic(this.clientVarstnic, DESTINATIE_VALIDA, PRET_VALID);
        pachetVarstnic.aplicaDiscountVarstnici(100);
        assertEquals(0.0, pachetVarstnic.getPret());
    }

    @Tag("boundary")
    @Test
    void constructorShouldAcceptPretZero() {
        PachetTuristic pachetGratuit = new PachetTuristic(this.clientAdult, DESTINATIE_VALIDA, PRET_ZERO);
        assertEquals(PRET_ZERO, pachetGratuit.getPret());
    }

    // [I] INVERSE RELATIONSHIP

    @Tag("inverse")
    @Test
    void setAndGetClientShouldBeInverse() {
        this.pachetAdult.setClient(this.clientVarstnic);
        assertEquals(this.clientVarstnic, this.pachetAdult.getClient());
    }

    @Tag("inverse")
    @Test
    void setAndGetDestinatieShouldBeInverse() {
        this.pachetAdult.setDestinatie("Roma");
        assertEquals("Roma", this.pachetAdult.getDestinatie());
    }

    @Tag("inverse")
    @Test
    void setAndGetPretShouldBeInverse() {
        this.pachetAdult.setPret(2000.0);
        assertEquals(2000.0, this.pachetAdult.getPret());
    }

    // [C] CROSS-CHECK

    @Tag("crosscheck")
    @Test
    void poateRezervaCrossCheck() {
        boolean poateRezervaAsteptat = this.clientAdult.getVarsta() >= 18;
        assertEquals(poateRezervaAsteptat, this.pachetAdult.poateRezerva());
    }

    @Tag("crosscheck")
    @Test
    void aplicaDiscountVarstiniciCrossCheck() {
        double pretInitial = this.pachetVarstnic.getPret();
        int procent = 10;
        double pretAsteptat = pretInitial - (pretInitial * ((double) procent / 100));
        this.pachetVarstnic.aplicaDiscountVarstnici(procent);
        assertEquals(pretAsteptat, this.pachetVarstnic.getPret());
    }

    // [E] ERROR CONDITIONS

    @Tag("error")
    @Test
    void constructorShouldThrowForNullClient() {
        assertThrows(PersoanaInvalidaException.class, () -> new PachetTuristic(null, DESTINATIE_VALIDA, PRET_VALID));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForNullDestinatie() {
        assertThrows(DestinatieInvalidaException.class, () -> new PachetTuristic(this.clientAdult, null, PRET_VALID));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForEmptyDestinatie() {
        assertThrows(DestinatieInvalidaException.class, () -> new PachetTuristic(this.clientAdult, "", PRET_VALID));
    }

    @Tag("error")
    @Test
    void constructorShouldThrowForNegativePret() {
        assertThrows(PretInvalidException.class, () -> new PachetTuristic(clientAdult, DESTINATIE_VALIDA, -1.0));
    }

    @Tag("error")
    @Test
    void aplicaDiscountShouldThrowForNegativeProcent() {
        assertThrows(ProcentInvalidException.class, () -> this.pachetVarstnic.aplicaDiscountVarstnici(-1));
    }

    @Tag("error")
    @Test
    void aplicaDiscountShouldThrowForProcentOver100() {
        assertThrows(ProcentInvalidException.class, () -> this.pachetVarstnic.aplicaDiscountVarstnici(101));
    }

    // [P] PERFORMANCE

    @Tag("performance")
    @Test
    void poateRezervaShouldRunWithinTimeLimit() {
        assertTimeout(Duration.ofMillis(100), this.pachetAdult::poateRezerva);
    }

    @Tag("performance")
    @Test
    void aplicaDiscountShouldRunWithinTimeLimit() {
        assertTimeout(Duration.ofMillis(100), () -> this.pachetVarstnic.aplicaDiscountVarstnici(10));
    }

    // ================================
    // CORRECT
    // ================================

    // [C] CONFORMANCE

    // Conformance și Error se suprapun complet în clasa PachetTuristic

    // [O] ORDERING

    // Nu se aplică natural la PachetTuristic deoarece nu conține colecții

    // [R] RANGE

    // Range și Error, Boundary se suprapun complet în clasa PachetTuristic

    // [R] REFERENCE

    // Nu se aplică natural la PachetTuristic deoarece nu are dependințe externe

    // [E] EXISTENCE

    // Existence și Error se suprapun complet în clasa PachetTuristic

    // [C] CARDINALITY

    // Nu se aplică natural la PachetTuristic deoarece nu conține colecții

    // [T] TIME

    // Nu se aplică natural la PachetTuristic deoarece nu există un flux obligatoriu de apeluri
}
