package model;

import java.time.LocalDate;

public class Client {
    private static int id = 0;

    private int clientId;

    private String firstName;
    private String lastName;

    private LocalDate birthDate;

    private Client(Builder builder){
        this.clientId = id++;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;

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

    public LocalDate getBirthDate() {
        return birthDate;
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


    public static class Builder{
        private int clientId;

        private String firstName;
        private String lastName;

        private LocalDate birthDate;

        public Builder(){

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

            return new Client(this);
        }
    }

}
