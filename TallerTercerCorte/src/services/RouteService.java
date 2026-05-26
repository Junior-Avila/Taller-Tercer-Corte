package services;

import entities.Route;
import repositories.RouteRepository;

public class RouteService {

    private RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public void registerRoute(Route route) throws Exception {

        if(routeRepository.getByCode(route.getCode()) != null){
            throw new Exception("YA EXISTE UNA RUTA CON ESE CÓDIGO");
        }

        if(route.getCapacity() <= 0){
            throw new Exception("LA CAPACIDAD DEBE SER MAYOR A CERO(0)");
        }

        if(route.getAvailableChairs() < 0){
            throw new Exception("LOS PUESTOS DISPONIBLES NO PUEDEN SER IGUAL O MENORES A CERO(0)");
        }

        if(route.getAvailableChairs() > route.getCapacity()){
            throw new Exception("LOS PUESTOS DISPONIBLES NO PUEDEN SER MAYORES A LA CAPACIDAD");
        }

        if(route.getBasePrice() <= 0){
            throw new Exception("EL PRECIO BASE DEBE SER MAYOR A CERO(0)");
        }

        routeRepository.create(route);
    }

    public Route findRoute(String code) throws Exception {

        Route route = routeRepository.getByCode(code);
        if(route == null){
            throw new Exception("NO SE ENCONTRO LA RUTA");
        }
        return route;
    }

    public void deleteRoute(String code) throws Exception {

        boolean deleted = routeRepository.deleteByCode(code);
        if(!deleted){
            throw new Exception("NO SE PUDO ELIMINAR LA RUTA");
        }
    }

    public void updateRoute(String code, int newAvailableChairs, String newStatus) throws Exception {

        if(newAvailableChairs < 0){
            throw new Exception("LOS PUESTOS DISPONIBLES NO PUEDEN SER MENORES A CERO (0)");
        }

        boolean updated = routeRepository.updateRoute(code, newAvailableChairs, newStatus);

        if(!updated){
            throw new Exception("NO SE PUDO ACTUALIZAR LA RUTA");
        }
    }
}