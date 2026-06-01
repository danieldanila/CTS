package clase;

import exceptii.DestinatieInvalidaException;
import exceptii.PersoanaInvalidaException;
import exceptii.PretInvalidException;
import exceptii.ProcentInvalidException;

public class PachetTuristic {
    private static final int VARSTA_MINIMA_REZERVARE = 18;
    private static final int VARSTA_MINIMA_VARSTNIC = 65;
    private static final int PROCENT_MINIM = 0;
    private static final int PROCENT_MAXIM = 100;

    private IPersoana client;
    private String destinatie;
    private double pret;

    public PachetTuristic(IPersoana client, String destinatie, double pret) {
        this.valideazaClient(client);
        this.valideazaDestinatie(destinatie);
        this.valideazaPret(pret);
        this.client = client;
        this.destinatie = destinatie;
        this.pret = pret;
    }

    public IPersoana getClient() {
        return this.client;
    }

    public void setClient(IPersoana client) {
        this.valideazaClient(client);
        this.client = client;
    }

    public String getDestinatie() {
        return this.destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.valideazaDestinatie(destinatie);
        this.destinatie = destinatie;
    }

    public double getPret() {
        return this.pret;
    }

    public void setPret(double pret) {
        this.valideazaPret(pret);
        this.pret = pret;
    }

    public boolean poateRezerva() {
        return this.client.getVarsta() >= VARSTA_MINIMA_REZERVARE;
    }

    public void aplicaDiscountVarstnici(int procent) {
        if (procent < PROCENT_MINIM || procent > PROCENT_MAXIM) {
            throw new ProcentInvalidException("Procentul trebuie să fie între " + PROCENT_MINIM + " și " + PROCENT_MAXIM);
        }

        if (this.client.getVarsta() >= VARSTA_MINIMA_VARSTNIC) {
            this.pret = this.pret - (this.pret * ((double) procent / 100));
        }
    }

    private void valideazaClient(IPersoana client) {
        if (client == null) {
            throw new PersoanaInvalidaException("Clientul nu poate fi null");
        }
    }

    private void valideazaDestinatie(String destinatie) {
        if (destinatie == null || destinatie.isEmpty()) {
            throw new DestinatieInvalidaException("Destinația nu poate fi null sau necompletată");
        }
    }

    private void valideazaPret(double pret) {
        if (pret < 0) {
            throw new PretInvalidException("Prețul nu poate fi negativ: " + pret);
        }
    }
}
