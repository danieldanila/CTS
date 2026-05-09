package chainofresponsability;

public class Client {
    private final String nume;
    private final String telefon;
    private final String email;

    public Client(String nume, String telefon, String email) {
        this.nume = nume;
        this.telefon = telefon;
        this.email = email;
    }

    public String getNume() {
        return this.nume;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public String getEmail() {
        return this.email;
    }
}