package storage;

import exceptions.EmptyListException;
import exceptions.FieldNotFoundException;
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

    public void deleteClient(int id) throws FieldNotFoundException, EmptyListException {
        boolean isFindId = false;

        if (!clients.isEmpty()) {
            Iterator<Client> it = clients.iterator();

            while (it.hasNext()) {
                if (it.next().getClientId() == id) {
                    it.remove();
                    isFindId = true;
                }
            }

            if(!isFindId){
                throw new FieldNotFoundException();
            }

        } else {
            throw new EmptyListException("List is empty\n");
        }

    }

    public void editFirstName(int id, String newFirstName) throws FieldNotFoundException {
        boolean isFind = false;

        ListIterator<Client> it = clients.listIterator();

        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setFirstName(newFirstName);
                isFind = true;
            }
        }

        if(!isFind){
            throw new FieldNotFoundException();
        }
    }

    public void editLastName(int id, String newLastName) throws FieldNotFoundException {
        boolean isFind = false;

        ListIterator<Client> it = clients.listIterator();

        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setLastName(newLastName);
                isFind = true;
            }
        }

        if(!isFind){
            throw new FieldNotFoundException();
        }
    }

    public void editBirthDate(int id, String newBirthDate) throws FieldNotFoundException {
        boolean isFind = false;

        ListIterator<Client> it = clients.listIterator();

        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setBirthDate(newBirthDate);
                isFind = true;
            }
        }

        if(!isFind){
            throw new FieldNotFoundException();
        }
    }

    public Client findClient(int clientId) throws FieldNotFoundException {
        boolean isFind = false;

        Client rightClient = null;

        for (Client client : clients) {
            if (client.getClientId() == clientId) {
                rightClient = client;
                isFind = true;
            }
        }

        if(!isFind){
            throw  new FieldNotFoundException();
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
