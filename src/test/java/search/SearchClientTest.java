package search;

import exceptions.EmptyListException;
import exceptions.FieldNotFoundException;
import model.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import storage.ClientModelStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchClientTest {
    private static List<Client> clients;

    @BeforeClass
    public static void initStorage(){
        clients = new ArrayList<>();
    }

    @Before
    public void addClient(){
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        Client client = new Client.Builder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setBirthDate(birthDate)
                .build();

        ClientModelStorage.getInstance().addClient(client);
    }


    @Test
    public void searchClientTest(){
        clients = ClientModelStorage.getInstance()
                .findClientStreamByFirstName("Ivan")
                .collect(Collectors.toCollection(ArrayList::new));

        Assert.assertEquals(clients.get(0).getLastName(), "Ivanov");
        Assert.assertEquals(clients.get(0).getBirthDate().toString(), "1998-01-22");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void searchFallClientTest(){
        clients = ClientModelStorage.getInstance()
                .findClientStreamByFirstName("Nikolay")
                .collect(Collectors.toCollection(ArrayList::new));

        Assert.assertEquals(clients.get(0).getLastName(), "Ivanov");
        Assert.assertEquals(clients.get(0).getBirthDate().toString(), "1998-01-22");
    }
}
