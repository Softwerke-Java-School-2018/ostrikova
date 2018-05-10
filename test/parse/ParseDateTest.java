package parse;

import model.Client;
import org.junit.Assert;
import org.junit.Test;
import storage.ClientModelStorage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ParseDateTest {

    @Test
    public void dateParseTest(){
        LocalDate birthDate = LocalDate.parse("1998-01-22");

        Client client = new Client.Builder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setBirthDate(birthDate)
                .build();

        Assert.assertEquals(client.getBirthDate(), birthDate);
        Assert.assertNotEquals(client.getBirthDate(), "1998/01/22");
    }

    @Test(expected = DateTimeParseException.class)
    public void parseDateTest(){
        LocalDate birthDate = LocalDate.parse("1998/01/22");

        Client client = new Client.Builder()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setBirthDate(birthDate)
                .build();

        ClientModelStorage.getInstance().addClient(client);
    }
}
