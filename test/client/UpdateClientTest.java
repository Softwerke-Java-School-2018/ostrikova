package client;

import model.Client;
import storage.ClientModelStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateClientTest {
    private static List<Client> clients;
    private static Client client;;


    @BeforeClass
    public static void initStorage(){
        clients = new ArrayList<>();
    }

    @Before
    public void addClient(){
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        client = new Client.Builder()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setBirthDate(birthDate)
                .build();

        ClientModelStorage.getInstance().addClient(client);
    }

    @Test
    public void updateClientTest(){
        ClientModelStorage.getInstance().editFirstName(0, "Смирнов");

        List<Client> clientList = ClientModelStorage
                .getInstance()
                .getStreamClients()
                .collect(Collectors.toList());

        String editClient = clientList.get(0).getFirstName();
        Assert.assertNotEquals("Иванов", editClient);
        Assert.assertEquals("Смирнов", editClient);
    }
}
