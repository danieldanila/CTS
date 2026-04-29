package strategy;

public class PlataCash implements ModPlata {
    @Override
    public void plateste(double suma) {
        System.out.println("Plata în suma de " + suma + " lei a fost efectuată cash.");
    }
}