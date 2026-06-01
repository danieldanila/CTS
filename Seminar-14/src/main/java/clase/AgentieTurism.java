package clase;

import exceptii.PachetTuristicInvalidException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgentieTurism {
    private final List<PachetTuristic> pacheteTuristice;

    public AgentieTurism() {
        this.pacheteTuristice = new ArrayList<>();
    }

    public List<PachetTuristic> getPacheteTuristice() {
        return Collections.unmodifiableList(this.pacheteTuristice);
    }

    public void adaugaPachet(PachetTuristic pachet) {
        if (pachet == null) {
            throw new PachetTuristicInvalidException("Pachetul nu poate fi null");
        }

        if (this.pacheteTuristice.contains(pachet)) {
            throw new PachetTuristicInvalidException("Pachetul există deja în agenție");
        }

        this.pacheteTuristice.add(pachet);
    }

    public void stergePachet(PachetTuristic pachet) {
        if (pachet == null) {
            throw new PachetTuristicInvalidException("Pachetul nu poate fi null");
        }

        if (!this.pacheteTuristice.remove(pachet)) {
            throw new PachetTuristicInvalidException("Pachetul nu există în agenție");
        }
    }

    public double calculareSumaTotalaPachete() {
        return this.pacheteTuristice.stream()
                .mapToDouble(PachetTuristic::getPret)
                .sum();
    }
}
