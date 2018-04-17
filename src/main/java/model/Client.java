package model;

import java.time.LocalDate;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
    }

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
