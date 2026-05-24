public class PachetTuristic {
    private IPersoana client;
    private String destinatie;
    private Double pret;

    public PachetTuristic(IPersoana client, String destinatie, Double pret) {
        this.client = client;
        this.destinatie = destinatie;
        this.pret = pret;
    }

    public boolean poateRezerva() {
        return this.client.getVarsta() > 18;
    }

    public void aplicaDiscountVarstnici(int procent) {
        if (this.client.getVarsta() >= 65) {
            this.pret = this.pret - (procent / 100);
        }
    }

    public IPersoana getClient() {
        return this.client;
    }

    public void setClient(IPersoana client) {
        this.client = client;
    }

    public String getDestinatie() {
        return this.destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public Double getPret() {
        return this.pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }
}