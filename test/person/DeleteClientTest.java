package person;

import menu.client.DeleteClientMenu;
import model.Client;
import model.ModelStorage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeleteClientTest {
    private static ModelStorage modelStorage;
    private static DeleteClientMenu deleteClientMenu;
    private static List<Client> clients;


    @BeforeClass
    public static void initStorage(){
        modelStorage = new ModelStorage();
        deleteClientMenu = new DeleteClientMenu(modelStorage);
        clients = new ArrayList<>();
    }

    @Before
    public void addClient(){
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        Client client = new Client.Builder(0)
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setBirthDate(birthDate)
                .build();

        modelStorage.addClient(client);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteClientTest(){
        deleteClientMenu.deleteClient(0);

        List<Client> deletedClient = modelStorage.getClients();
        deletedClient.get(0);
    }
}
