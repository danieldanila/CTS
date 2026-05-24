import java.util.ArrayList;
import java.util.List;

public class AgentieTurism {
    private final List<PachetTuristic> pacheteTuristice;

    public AgentieTurism() {
        this.pacheteTuristice = new ArrayList<>();
    }

    public void adaugaPachet(PachetTuristic pachet) {
        this.pacheteTuristice.add(pachet);
    }

    public double calculareSumaTotalaPachete() {
        return this.pacheteTuristice.stream()
                .mapToDouble(PachetTuristic::getPret)
                .sum();
    }
}