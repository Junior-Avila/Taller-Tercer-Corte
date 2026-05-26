package repositories;

import entities.Passenger;
import java.util.ArrayList;

public class PassengerRepository {

    private ArrayList<Passenger> passengers = new ArrayList<>();

    public void create(Passenger p){
        passengers.add(p);
    }

    public ArrayList<Passenger> getAll(){
        return passengers;
    }

    public Passenger getById(long id){
        for(Passenger p : passengers){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public boolean deleteById(long id){
        return passengers.removeIf(p -> p.getId() == id);
    }

    public boolean updatePassenger(long id, int newAge, String newPhoneNumber){
        Passenger p = getById(id);

        if(p != null){
            p.setAge(newAge);
            p.setPhoneNumber(newPhoneNumber);
            return true;
        }
        return false;
    }
}