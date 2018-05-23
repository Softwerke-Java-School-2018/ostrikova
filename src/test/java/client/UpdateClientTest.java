package client;

import exceptions.EmptyListException;
import exceptions.FieldNotFoundException;
import model.Client;
import org.junit.*;
import storage.ClientModelStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateClientTest {
    private static List<Client> clients;
    private static Client client;


    @BeforeClass
    public static void initStorage() {
        clients = new ArrayList<>();
    }

    @Before
    public void addClient() {
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        client = new Client.Builder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setBirthDate(birthDate)
                .build();

        ClientModelStorage.getInstance().addClient(client);
    }

    @Test
    public void updateClientTest() throws EmptyListException, FieldNotFoundException {
        ClientModelStorage.getInstance().editLastName(1, "Smirnov");

        List<Client> clientList = ClientModelStorage
                .getInstance()
                .getStreamClients()
                .collect(Collectors.toList());

        String editClient = clientList.get(0).getLastName();
        Assert.assertNotEquals("Ivanov", editClient);
        Assert.assertEquals("Smirnov", editClient);

    }

    @After
    public void deleteClients() throws EmptyListException, FieldNotFoundException{
        client.setId(0);
        ClientModelStorage.getInstance().deleteClient(1);
    }
}
