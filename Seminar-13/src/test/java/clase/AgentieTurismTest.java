package clase;

import exceptii.PachetTuristicInvalidException;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgentieTurismTest {

    // ================================
    // Fixtures
    // ================================

    private static final String CNP_ADULT = "1900522400993";
    private static final String CNP_VARSTNIC = "1600522402277";
    private static final String CNP_NOU_NASCUT = "5260522405291";

    private CetateanRoman clientAdult;
    private CetateanRoman clientVarstnic;
    private CetateanRoman clientMinor;
    private PachetTuristic pachetAdult;
    private PachetTuristic pachetVarstnic;
    private PachetTuristic pachetMinor;
    private AgentieTurism agentie;

    // ================================
    // SETUP & TEARDOWN
    // ================================

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Pregătiri generale înainte de toate testele AgentieTurism");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Se efectuează pregătirile pentru un test: se initițializează clienții, pachetele și agenția");
        this.clientAdult = new CetateanRoman("Andrei", CNP_ADULT);
        this.clientVarstnic = new CetateanRoman("Maria", CNP_VARSTNIC);
        this.clientMinor = new CetateanRoman("Copil", CNP_NOU_NASCUT);
        this.pachetAdult = new PachetTuristic(this.clientAdult, "Paris", 1000.0);
        this.pachetVarstnic = new PachetTuristic(this.clientVarstnic, "Roma", 2000.0);
        this.pachetMinor = new PachetTuristic(this.clientMinor, "Tokyo", 3000.0);
        this.agentie = new AgentieTurism();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Se efectuează curățenia de după un test: se șterg clienții, pachetele și agenția");
        this.clientAdult = null;
        this.clientVarstnic = null;
        this.clientMinor = null;
        this.pachetAdult = null;
        this.pachetVarstnic = null;
        this.pachetMinor = null;
        this.agentie = null;
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Curățenie generală după toate testele AgentieTurism");
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
    void calculareSumaTotalaShouldReturnCorrectSumForMultiplePachete() {
        this.agentie.adaugaPachet(this.pachetAdult);
        this.agentie.adaugaPachet(this.pachetVarstnic);
        assertEquals(3000.0, this.agentie.calculareSumaTotalaPachete(), 0.01, "Suma totală ar trebui să fie 3000.0 pentru pachete de 1000.0 și 2000.0");
    }

    @Tag("right")
    @Test
    void adaugaPachetShouldAddPachetToList() {
        this.agentie.adaugaPachet(this.pachetAdult);
        assertTrue(this.agentie.getPacheteTuristice().contains(this.pachetAdult), "Lista ar trebui să conțină pachetul după adăugare");
    }

    @Tag("right")
    @Test
    void stergePachetShouldRemovePachetFromList() {
        this.agentie.adaugaPachet(this.pachetAdult);
        this.agentie.stergePachet(this.pachetAdult);
        assertFalse(this.agentie.getPacheteTuristice().contains(this.pachetAdult));
    }

    // [B] BOUNDARY

    @Tag("boundary")
    @Test
    void calculareSumaTotalaShouldReturnZeroWhenListIsEmpty() {
        assertEquals(0.0, this.agentie.calculareSumaTotalaPachete());
    }

    @Tag("boundary")
    @Test
    void calculareSumaTotalaShouldReturnCorrectSumForExactlyOnePachet() {
        this.agentie.adaugaPachet(this.pachetAdult);
        assertEquals(this.pachetAdult.getPret(), this.agentie.calculareSumaTotalaPachete());
    }

    @Tag("boundary")
    @Test
    void calculareSumaTotalaShouldHandleLargeNumberOfPachete() {
        for (int i = 0; i < 10000; i++) {
            this.agentie.adaugaPachet(new PachetTuristic(this.clientAdult, "Destinatie " + i, 1.0));
        }
        assertEquals(10000.0, this.agentie.calculareSumaTotalaPachete());
    }

    // [I] INVERSE RELATIONSHIP

    @Tag("inverse")
    @Test
    void adaugaUrmatDeStergeShouldRestoreSumaInitiala() {
        double sumaInitiala = this.agentie.calculareSumaTotalaPachete();
        this.agentie.adaugaPachet(this.pachetAdult);
        this.agentie.stergePachet(this.pachetAdult);
        assertEquals(sumaInitiala, this.agentie.calculareSumaTotalaPachete());
    }

    @Tag("inverse")
    @Test
    void adaugaUrmatDeStergeShouldRestoreListaInitiala() {
        this.agentie.adaugaPachet(this.pachetAdult);
        this.agentie.stergePachet(this.pachetAdult);
        assertFalse(this.agentie.getPacheteTuristice().contains(this.pachetAdult));
    }

    // [C] CROSS-CHECK

    @Tag("crosscheck")
    @Test
    void calculareSumaTotalaCrossCheck() {
        this.agentie.adaugaPachet(this.pachetAdult);
        this.agentie.adaugaPachet(this.pachetVarstnic);
        this.agentie.adaugaPachet(this.pachetMinor);
        double sumaCalculataManual = this.pachetAdult.getPret() + this.pachetVarstnic.getPret() + this.pachetMinor.getPret();
        assertEquals(sumaCalculataManual, this.agentie.calculareSumaTotalaPachete());
    }

    // [E] ERROR CONDITIONS

    @Tag("error")
    @Test
    void adaugaPachetShouldThrowForNullPachet() {
        assertThrows(PachetTuristicInvalidException.class, () -> this.agentie.adaugaPachet(null));
    }

    @Tag("error")
    @Test
    void adaugaPachetShouldThrowForDuplicatePachet() {
        this.agentie.adaugaPachet(this.pachetAdult);
        assertThrows(PachetTuristicInvalidException.class, () -> this.agentie.adaugaPachet(this.pachetAdult));
    }

    @Tag("error")
    @Test
    void stergePachetShouldThrowForNullPachet() {
        assertThrows(PachetTuristicInvalidException.class, () -> this.agentie.stergePachet(null));
    }

    @Tag("error")
    @Test
    void stergePachetShouldThrowForNonExistentPachet() {
        assertThrows(PachetTuristicInvalidException.class, () -> this.agentie.stergePachet(this.pachetAdult));
    }

    // [P] PERFORMANCE

    @Tag("performance")
    @Test
    void calculareSumaTotalaShouldRunWithinTimeLimitForLargeList() {
        for (int i = 0; i < 10000; i++) {
            this.agentie.adaugaPachet(new PachetTuristic(this.clientAdult, "Destinatie " + i, 1.0));
        }
        assertTimeout(Duration.ofMillis(100), this.agentie::calculareSumaTotalaPachete);
    }

    // ================================
    // CORRECT
    // ================================

    // [C] CONFORMANCE

    @Tag("conformance")
    @Test
    void getPacheteTuristiceShouldReturnUnmodifiableList() {
        this.agentie.adaugaPachet(this.pachetAdult);
        assertThrows(UnsupportedOperationException.class, () -> this.agentie.getPacheteTuristice().add(this.pachetVarstnic));
    }

    // [O] ORDERING

    @Tag("ordering")
    @Test
    void getPacheteTuristiceShouldReturnPacheteInInsertionOrder() {
        this.agentie.adaugaPachet(this.pachetAdult);
        this.agentie.adaugaPachet(this.pachetVarstnic);
        this.agentie.adaugaPachet(this.pachetMinor);
        List<PachetTuristic> pachete = this.agentie.getPacheteTuristice();
        assertEquals(this.pachetAdult, pachete.get(0));
        assertEquals(this.pachetVarstnic, pachete.get(1));
        assertEquals(this.pachetMinor, pachete.get(2));
    }

    // [R] RANGE

    @Tag("range")
    @Test
    void calculareSumaTotalaShouldReturnNonNegativeValue() {
        this.agentie.adaugaPachet(this.pachetAdult);
        this.agentie.adaugaPachet(this.pachetVarstnic);
        assertTrue(this.agentie.calculareSumaTotalaPachete() >= 0);
    }

    // [R] REFERENCE

    @Tag("reference")
    @Test
    void calculareSumaTotalaShouldReflectPretChangesOnExistingPachet() {
        this.agentie.adaugaPachet(this.pachetAdult);
        this.pachetAdult.setPret(5000.0);
        assertEquals(5000.0, this.agentie.calculareSumaTotalaPachete());
    }

    @Tag("reference")
    @Test
    void calculareSumaTotalaShouldReflectDiscountAppliedOnExistingPachet() {
        this.agentie.adaugaPachet(this.pachetVarstnic);
        double sumaInainte = this.agentie.calculareSumaTotalaPachete();
        this.pachetVarstnic.aplicaDiscountVarstnici(10);
        assertTrue(this.agentie.calculareSumaTotalaPachete() < sumaInainte);
    }

    // [E] EXISTENCE

    @Tag("existence")
    @Test
    void agentieShouldInitialiseWithEmptyList() {
        assertNotNull(this.agentie.getPacheteTuristice());
        assertTrue(this.agentie.getPacheteTuristice().isEmpty());
    }

    // [C] CARDINALITY

    @Tag("cardinality")
    @Test
    void agentieShouldHandleZeroPachete() {
        assertEquals(0, this.agentie.getPacheteTuristice().size());
    }

    @Tag("cardinality")
    @Test
    void agentieShouldHandleExactlyOnePachet() {
        this.agentie.adaugaPachet(this.pachetAdult);
        assertEquals(1, this.agentie.getPacheteTuristice().size());
    }

    @Tag("cardinality")
    @Test
    void agentieShouldHandleMultiplePachete() {
        this.agentie.adaugaPachet(this.pachetAdult);
        this.agentie.adaugaPachet(this.pachetVarstnic);
        this.agentie.adaugaPachet(this.pachetMinor);
        assertEquals(3, this.agentie.getPacheteTuristice().size());
    }

    @Tag("cardinality")
    @Test
    void agentieShouldHandleLargeNumberOfPacheteAsUpperBoundary() {
        for (int i = 0; i < 10000; i++) {
            this.agentie.adaugaPachet(new PachetTuristic(this.clientAdult, "Destinatie " + i, 1.0));
        }
        assertEquals(10000, this.agentie.getPacheteTuristice().size());
    }

    // [T] TIME

    @Tag("time")
    @Test
    void stergePachetShouldBeCalledAfterAdaugaPachet() {
        assertThrows(PachetTuristicInvalidException.class, () -> this.agentie.stergePachet(this.pachetAdult));
        this.agentie.adaugaPachet(this.pachetAdult);
        assertDoesNotThrow(() -> this.agentie.stergePachet(this.pachetAdult));
    }
}
