package clase;

import dubluri.DummyPersoana;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

class AgentieTurismTest {
    @Tag("dummy")
    @Test
    void agentieShouldHaveCorrectSizeAfterAdaugaPachete() {
        DummyPersoana dummy = new DummyPersoana();

        PachetTuristic pachet1 = new PachetTuristic(dummy, "Paris", 1000.0);
        PachetTuristic pachet2 = new PachetTuristic(dummy, "Roma", 2000.0);

        AgentieTurism agentie = new AgentieTurism();

        agentie.adaugaPachet(pachet1);
        agentie.adaugaPachet(pachet2);

        assertEquals(2, agentie.getPacheteTuristice().size(), "Lista ar trebui să conțină exact 2 pachete după 2 adăugări");
    }

    @Tag("mockito")
    @Test
    void agentieShouldHaveCorrectSizeAfterAdaugaPachete_Mockito() {
        IPersoana mockClient = mock(IPersoana.class);

        PachetTuristic pachet1 = new PachetTuristic(mockClient, "Paris", 1000.0);
        PachetTuristic pachet2 = new PachetTuristic(mockClient, "Roma", 2000.0);

        AgentieTurism agentie = new AgentieTurism();

        agentie.adaugaPachet(pachet1);
        agentie.adaugaPachet(pachet2);

        assertEquals(2, agentie.getPacheteTuristice().size(), "Lista ar trebui să conțină exact 2 pachete după 2 adăugări");
        verifyNoInteractions(mockClient);
    }
}
