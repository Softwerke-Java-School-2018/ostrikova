package model;

import java.time.LocalDate;

public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Client(int clientId, String firstName,
                  String lastName, LocalDate birthDate ){
        this.birthDate = birthDate;
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getClientId() {
        return clientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

}
