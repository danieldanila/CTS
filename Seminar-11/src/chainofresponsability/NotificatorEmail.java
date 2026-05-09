package chainofresponsability;

public class NotificatorEmail extends Notificator {
    @Override
    public void notifica(Client client, String mesaj) {
        if (client.getEmail() != null && !client.getEmail().isEmpty()) {
            System.out.println("Notificare email pentru clientul " + client.getNume() + " legată de noua ofertă: " + mesaj);
        } else if (super.getUrmatorulNotificator() != null) {
            super.getUrmatorulNotificator().notifica(client, mesaj);
        } else {
            System.out.println("Eroare: Clientul nu are un email valid și nu există o alternativă de a trimite notificarea.");
        }
    }
}