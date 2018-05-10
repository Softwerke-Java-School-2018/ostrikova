package sort;

import menu.sort.SortClientMenu;
import model.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import storage.ClientModelStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortClientTest {
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

        LocalDate secondBirthDate = LocalDate.parse("1999-01-22");

        Client secondClient = new Client.Builder()
                .setFirstName("Александр")
                .setLastName("Иванов")
                .setBirthDate(secondBirthDate)
                .build();

        ClientModelStorage.getInstance().addClient(secondClient);
    }

    @Test
    public void sortClientTest(){
        clients = ClientModelStorage.getInstance()
                .getStreamClients()
                .sorted(this.COMPARE_BY_FIRSTNAME)
                .collect(Collectors.toCollection(ArrayList::new));


        Assert.assertEquals(clients.get(0).getFirstName(), "Александр");
        Assert.assertEquals(clients.get(1).getFirstName(), "Иван");
    }

    private Comparator<Client> COMPARE_BY_FIRSTNAME = (one, other) -> {
        String oneFirstName = one.getFirstName();
        String otherFirstName = other.getFirstName();
        return oneFirstName.compareTo(otherFirstName);
    };
}
