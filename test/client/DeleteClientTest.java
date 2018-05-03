package client;

import exceptions.EmptyListException;
import exceptions.FieldNotFoundException;
import model.Client;
import storage.ClientModelStorage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteClientTest {
    private static List<Client> clients;


    @BeforeClass
    public static void initStorage(){
        clients = new ArrayList<>();
    }

    @Before
    public void addClient(){
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        Client client = new Client.Builder()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setBirthDate(birthDate)
                .build();

        ClientModelStorage.getInstance().addClient(client);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteClientTest(){
        try {
            ClientModelStorage.getInstance().deleteClient(0);
        } catch (FieldNotFoundException e){
            e.getMessage();
        } catch (EmptyListException e){
            e.getMessage();
        }

        List<Client> deletedClient = ClientModelStorage
                .getInstance()
                .getStreamClients()
                .collect(Collectors.toList());

        deletedClient.get(0);
    }
}
