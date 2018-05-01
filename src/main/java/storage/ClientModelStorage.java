package storage;

import model.Client;
import scanner.ReaderWriter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class ClientModelStorage {

    private static ClientModelStorage instance;
    private List<Client> clients;

    private ClientModelStorage() {
        this.clients = new ArrayList<>();
    }

    public static ClientModelStorage getInstance() {
        if (instance == null) {
            instance = new ClientModelStorage();
        }
        return instance;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Stream<Client> getStreamClients() {
        return clients.stream();
    }

    public void deleteClient(int id) {

        if (!clients.isEmpty()) {
            Iterator<Client> it = clients.iterator();

            while (it.hasNext()) {
                if (it.next().getClientId() == id) {
                    it.remove();
                    break;
                }
            }

        } else {
            ReaderWriter.getInstance().printLine("Can't be removed. List of clients is empty");
        }

    }

    public void editFirstName(int id, String newFirstName) {

        ListIterator<Client> it = clients.listIterator();

        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setFirstName(newFirstName);
                break;
            }
        }

    }

    public void editLastName(int id, String newLastName) {

        ListIterator<Client> it = clients.listIterator();

        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setLastName(newLastName);
                break;
            }
        }

    }

    public void editBirthDate(int id, String newBirthDate) {

        ListIterator<Client> it = clients.listIterator();

        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setBirthDate(newBirthDate);
                break;
            }
        }

    }

    public Client findClient(int clientId) {

        Client rightClient = null;

        for (Client client : clients) {
            if (client.getClientId() == clientId) {
                rightClient = client;
                break;
            }
        }

        return rightClient;
    }

    public Stream<Client> findClientStreamById(int id) {
        return clients.stream()
                .filter(clients -> clients.getClientId() == id);
    }

    public Stream<Client> findClientStreamByFirstName(String firstName) {
        return clients.stream()
                .filter(clients -> firstName.equalsIgnoreCase(clients.getFirstName()));
    }

    public Stream<Client> findClientStreamByLastName(String lastName) {
        return clients.stream()
                .filter(clients -> lastName.equalsIgnoreCase(clients.getLastName()));
    }

    public Stream<Client> findClientStreamByBirthDate(LocalDate birthDate) {
        return clients.stream()
                .filter(clients -> birthDate.equals(clients.getBirthDate()));
    }

}
