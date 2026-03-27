import prototype._01factorysingleton.Client;
import prototype._01factorysingleton.ClientPrototypeFactorySingleton;

void main() {
    Client client = new Client("Andrei", "0722222222");

    ClientPrototypeFactorySingleton clientPrototypeFactorySingleton = ClientPrototypeFactorySingleton.getInstanta();
    clientPrototypeFactorySingleton.adaugaClient(client);
    Client clonaClient = clientPrototypeFactorySingleton.getClient("0722222222");
    Client altClient = clientPrototypeFactorySingleton.getClient("0733333333");

    System.out.println(client);
    System.out.println(clonaClient);
    System.out.println(altClient);

    System.out.println(client == clonaClient);

    clonaClient.setNumarTelefon("0711111111");
    System.out.println(client);
    System.out.println(clonaClient);
}