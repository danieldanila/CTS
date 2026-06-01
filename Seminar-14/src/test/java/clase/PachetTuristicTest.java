package clase;

import dubluri.FakePersoana;
import dubluri.FakeSpyPersoana;
import dubluri.StubPersoana;
import dubluri.StubSpyPersoana;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PachetTuristicTest {
    @Tag("stub")
    @Test
    void poateRezervaShouldReturnTrueForAdult() {
        StubPersoana stub = new StubPersoana();

        PachetTuristic pachet = new PachetTuristic(stub, "Paris", 1000.0);

        assertTrue(pachet.poateRezerva(), "Clientul cu vârsta 21 ar trebui să poată rezerva");
    }

    @Tag("mockito")
    @Test
    void poateRezervaShouldReturnTrueForAdult_Mockito() {
        IPersoana mockClient = mock(IPersoana.class);
        when(mockClient.getVarsta()).thenReturn(21);

        PachetTuristic pachet = new PachetTuristic(mockClient, "Paris", 1000.0);

        assertTrue(pachet.poateRezerva(), "Clientul cu vârsta 21 ar trebui să poată rezerva");
    }

    @Tag("fake")
    @Test
    void poateRezervaShouldReturnFalseForMinorThenTrueAfterSetVarsta() {
        FakePersoana fake = new FakePersoana("Maria", "F", 17);

        PachetTuristic pachet = new PachetTuristic(fake, "Paris", 1000.0);

        assertFalse(pachet.poateRezerva(), "Clientul cu vârsta 17 nu ar trebui să poată rezerva");

        fake.setVarsta(18);

        assertTrue(pachet.poateRezerva(), "Clientul cu vârsta 18 ar trebui să poată rezerva");
    }

    @Tag("mockito")
    @Test
    void poateRezervaShouldReturnFalseForMinorThenTrueAfterSetVarsta_Mockito() {
        IPersoana mockClient = mock(IPersoana.class);
        when(mockClient.getVarsta()).thenReturn(17).thenReturn(18);

        PachetTuristic pachet = new PachetTuristic(mockClient, "Paris", 1000.0);

        assertFalse(pachet.poateRezerva(), "Clientul cu vârsta 17 nu ar trebui să poată rezerva");
        assertTrue(pachet.poateRezerva(), "Clientul cu vârsta 18 ar trebui să poată rezerva");
    }

    @Tag("fake-spy")
    @Test
    void aplicaDiscountShouldReducePretForVarstnic() {
        FakeSpyPersoana fakeSpy = new FakeSpyPersoana("Maria", "F", 65);

        PachetTuristic pachet = new PachetTuristic(fakeSpy, "Paris", 1000.0);

        pachet.aplicaDiscountVarstnici(10);

        assertEquals(900.0, pachet.getPret(), "Prețul ar trebui să fie 900.0 după aplicarea unui discount de 10%");
        assertEquals(1, fakeSpy.getGetVarstaNumarApeluri(), "getVarsta() ar trebui să fie apelat exact o dată pentru aplicarea discountului");
    }

    @Tag("mockito")
    @Test
    void aplicaDiscountShouldReducePretForVarstnic_Mockito() {
        IPersoana mockClient = mock(IPersoana.class);
        when(mockClient.getVarsta()).thenReturn(65);

        PachetTuristic pachet = new PachetTuristic(mockClient, "Paris", 1000.0);
        pachet.aplicaDiscountVarstnici(10);

        assertEquals(900.0, pachet.getPret(), "Prețul ar trebui să fie 900.0 după aplicarea unui discount de 10%");
        verify(mockClient, times(1)).getVarsta();
    }

    @Tag("stub-spy")
    @Test
    void aplicaDiscountShouldNotReducePretForNonVarstnic() {
        StubSpyPersoana stubSpy = new StubSpyPersoana();

        PachetTuristic pachet = new PachetTuristic(stubSpy, "Paris", 1000.0);

        pachet.aplicaDiscountVarstnici(10);

        assertEquals(1000.0, pachet.getPret(),"Prețul nu ar trebui să se modifice pentru un client non-vârstnic");
        assertEquals(1, stubSpy.getGetVarstaNumarApeluri(), "getVarsta() ar trebui să fie apelat exact o dată pentru verificarea vârstei");
    }

    @Tag("mockito")
    @Test
    void aplicaDiscountShouldNotReducePretForNonVarstnic_Mockito() {
        IPersoana mockClient = mock(IPersoana.class);
        when(mockClient.getVarsta()).thenReturn(21);

        PachetTuristic pachet = new PachetTuristic(mockClient, "Paris", 1000.0);
        pachet.aplicaDiscountVarstnici(10);

        assertEquals(1000.0, pachet.getPret(), "Prețul nu ar trebui să se modifice pentru un client non-vârstnic");
        verify(mockClient).getVarsta();
    }
}
