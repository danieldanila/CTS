import chainofresponsability.*;

void main() {
    Notificator notificatorSMS = new NotificatorSMS();
    Notificator notificatorEmail = new NotificatorEmail();
    Notificator notificatorManager = new NotificatorManager();

    notificatorSMS.setUrmatorulNotificator(notificatorEmail);
    notificatorEmail.setUrmatorulNotificator(notificatorManager);

    List<Client> clienti = List.of(
            new Client("Client 1", "0722222222", null),
            new Client("Client 2", null, "client2@ase.ro"),
            new Client("Client 3", null, null));

    clienti.forEach(client -> notificatorSMS.notifica(client, "Notificare nou produs"));
}