package person;

import menu.client.EditClientMenu;
import model.Client;
import model.ModelStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UpdateClientTest {
    private static ModelStorage modelStorage;
    private static EditClientMenu editClientMenu;
    private static List<Client> clients;
    private static Client client;;


    @BeforeClass
    public static void initStorage(){
        modelStorage = new ModelStorage();
        editClientMenu = new EditClientMenu(modelStorage);
        clients = new ArrayList<>();
    }

    @Before
    public void addClient(){
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        client = new Client.Builder(0)
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setBirthDate(birthDate)
                .build();

        modelStorage.addClient(client);
    }
    @Test
    public void updateClientTest(){
        editClientMenu.editFirstName(0, "Смирнов");

        String editClient = modelStorage.getClients().get(0).getFirstName();
        Assert.assertNotEquals("Иванов", editClient);
        Assert.assertEquals("Смирнов", editClient);
    }
}
