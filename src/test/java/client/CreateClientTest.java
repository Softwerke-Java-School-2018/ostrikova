package client;

import model.Client;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CreateClientTest {
    private Client client;

    @Test
    public void createPersonTest() {
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        client = new Client.Builder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setBirthDate(birthDate)
                .build();

        Assert.assertEquals(client.getClientId(), 0);
        Assert.assertEquals(client.getFirstName(), "Ivan");
        Assert.assertEquals(client.getLastName(), "Ivanov");
        Assert.assertNotEquals(client.getFirstName(), "Ivanov");
        Assert.assertNotEquals(client.getLastName(), "Ivan");

    }

    @After
    public void setZeroId() {
        client.setId(0);
    }

}

