package prototype._01factorysingleton;

import java.util.StringJoiner;

public class Client implements ClientCloneable {
    private String nume;
    private String numarTelefon;

    public Client(String nume, String numarTelefon) {
        this.nume = nume;
        this.numarTelefon = numarTelefon;
    }

    public Client(Client altClient) {
        this.nume = altClient.nume;
        this.numarTelefon = altClient.numarTelefon;
    }

    public String getNumarTelefon() {
        return this.numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Client.class.getSimpleName() + "[", "]")
                .add("nume='" + this.nume + "'")
                .add("numarTelefon='" + this.numarTelefon + "'")
                .toString();
    }

    @Override
    public ClientCloneable cloneaza() {
        return new Client(this);
    }
}