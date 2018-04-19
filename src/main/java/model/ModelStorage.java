package model;

import java.util.ArrayList;
import java.util.List;

public class ModelStorage {
    private List<Device> devices;
    private List<Client> clients;

    public ModelStorage(){
        this.devices = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

   public void addClient(Client client){
        this.clients.add(client);
   }

   public List<Client> getClients(){
       return this.clients;
   }

   public List<Device> getDevices(){
       return this.devices;
   }

   public void addDevice(Device device){
       this.devices.add(device);
   }
}
