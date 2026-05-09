package chainofresponsability;

public class NotificatorSMS extends Notificator {
    @Override
    public void notifica(Client client, String mesaj) {
        if (client.getTelefon() != null && !client.getTelefon().isEmpty()) {
            System.out.println("Notificare SMS pentru clientul " + client.getNume() + " legată de noua ofertă: " + mesaj);
        } else if (super.getUrmatorulNotificator() != null) {
            super.getUrmatorulNotificator().notifica(client, mesaj);
        } else {
            System.out.println("Eroare: Clientul nu are un telefon valid și nu există o alternativă de a trimite notificarea.");
        }
    }
}