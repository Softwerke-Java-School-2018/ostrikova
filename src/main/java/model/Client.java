package model;

import java.time.LocalDate;
import java.util.Comparator;

public class Client {
    private int clientId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private Client(){
    }

    public int getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    @Override
    public String toString(){
        return this.clientId + " " + this.firstName
                + " " + this.lastName + " " + this.birthDate;
    }

    public static Comparator<Client> COMPARE_BY_ID = new Comparator<Client>() {
        public int compare(Client one, Client other) {
            String oneId = String.valueOf(one.clientId);
            String otherId = String.valueOf(other.clientId);
            return oneId.compareTo(otherId);
        }
    };

    public static Comparator<Client> COMPARE_BY_FIRSTNAME = new Comparator<Client>() {
        public int compare(Client one, Client other) {
            String oneFirstName = one.firstName;
            String otherFirstName = other.firstName;
            return oneFirstName.compareTo(otherFirstName);
        }
    };

    public static Comparator<Client> COMPARE_BY_LASTNAME = new Comparator<Client>() {
        public int compare(Client one, Client other) {
            String oneLastName = one.lastName;
            String otherLastName = other.lastName;
            return oneLastName.compareTo(otherLastName);
        }
    };

    public static Comparator<Client> COMPARE_BY_BIRTHDATE = new Comparator<Client>() {
        public int compare(Client one, Client other) {
            String oneBirthDate = one.birthDate.toString();
            String otherBirthDate = other.birthDate.toString();
            return oneBirthDate.compareTo(otherBirthDate);
        }
    };


    public static class Builder{
        private int clientId;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;

        public Builder(int clientId){
            this.clientId = clientId;
        }

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate){
            this.birthDate = birthDate;
            return this;
        }

        public Client build(){
            Client client = new Client();
            client.clientId = this.clientId;
            client.firstName = this.firstName;
            client.lastName = this.lastName;
            client.birthDate = this.birthDate;

            return client;
        }
    }

}
