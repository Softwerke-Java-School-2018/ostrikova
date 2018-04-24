package person;

import model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CreateClientTest {
    @Test
    public void createPersonTest(){
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        Client client = new Client.Builder(0)
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setBirthDate(birthDate)
                .build();

        Assert.assertEquals(client.getClientId(), 0);
        Assert.assertEquals(client.getFirstName(), "Иван");
        Assert.assertEquals(client.getLastName(), "Иванов");
        Assert.assertNotEquals(client.getFirstName(), "Иванов");
        Assert.assertNotEquals(client.getLastName(), "Иван");
    }

}

