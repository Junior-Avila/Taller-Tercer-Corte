package repositories;

import entities.Route;
import java.util.ArrayList;

public class RouteRepository {

    private ArrayList<Route> routes = new ArrayList<>();

    public void create(Route r){
        routes.add(r);
    }

    public ArrayList<Route> getAll(){
        return routes;
    }

    public Route getByCode(String code){
        for(Route r : routes){
            if(r.getCode().equals(code)){
                return r;
            }
        }
        return null;
    }

    public boolean deleteByCode(String code){
        return routes.removeIf(r -> r.getCode().equals(code));
    }

    public boolean updateRoute(String code, int newAvailableChairs, String newStatus){

        Route r = getByCode(code);
        if(r != null){
            r.setAvailableChairs(newAvailableChairs);
            r.setStatus(newStatus);
            return true;
        }
        return false;
    }
}