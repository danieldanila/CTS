package chainofresponsability;

public class NotificatorManager extends Notificator {
    @Override
    public void notifica(Client client, String mesaj) {
        System.out.println("Notificare către manager: clientul " + client.getNume() + " nu are date de contact în baza de date.");
    }
}