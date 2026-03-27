package prototype._01factorysingleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientPrototypeFactorySingleton {
    private static ClientPrototypeFactorySingleton instanta;
    private Map<String, Client> clienti;

    private ClientPrototypeFactorySingleton() {
        this.clienti = new HashMap<>();
    }

    public static synchronized ClientPrototypeFactorySingleton getInstanta() {
        if (ClientPrototypeFactorySingleton.instanta == null) {
            ClientPrototypeFactorySingleton.instanta = new ClientPrototypeFactorySingleton();
        }
        return ClientPrototypeFactorySingleton.instanta;
    }

    public void adaugaClient(Client client) {
        this.clienti.put(client.getNumarTelefon(), client);
    }

    public Client getClient(String numarTelefon) {
        Client client = this.clienti.get(numarTelefon);

        if (client == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Numarul de telefon '" + numarTelefon + "' nu este asociat niciunui client.\nIntroduceti numele noului client: ");
            String nume = scanner.nextLine();

            client = new Client(nume, numarTelefon);
            this.adaugaClient(client);
            return client;
        }
        return (Client) client.cloneaza();
    }
}