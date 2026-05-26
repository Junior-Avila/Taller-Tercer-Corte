package services;

import entities.Passenger;
import entities.Reservation;
import entities.Route;
import repositories.PassengerRepository;
import repositories.ReservationRepository;
import repositories.RouteRepository;

public class ReservationService {

    private ReservationRepository reservationRepository;
    private PassengerRepository passengerRepository;
    private RouteRepository routeRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              PassengerRepository passengerRepository,
                              RouteRepository routeRepository) {

        this.reservationRepository = reservationRepository;
        this.passengerRepository = passengerRepository;
        this.routeRepository = routeRepository;
    }

    public void createReservation(Reservation reservation) throws Exception {

        if (reservationRepository.getByCode(reservation.getCode()) != null) {
            throw new Exception("YA ESTA RUTA HA SIDO CREADA");
        }

        Passenger passenger = passengerRepository.getById(reservation.getPassenger().getId());
        if (passenger == null) {
            throw new Exception("NO SE HA ENCONTRO EL PASAJERO");
        }

        Route route = routeRepository.getByCode(reservation.getRoute().getCode());
        if (route == null) {
            throw new Exception("NO SE ENCONTRO LA RUTA");
        }

        if (!route.getStatus().equals("PROGRAMADA")) {
            throw new Exception("NO SE PUEDE RESERVAR SI NO EXISTE LA RUTA");
        }

        if (reservation.getChairReserved() < 1 || reservation.getChairReserved() > 5) {
            throw new Exception("LOS PUESTOS PARA RESERVAR ESTAN ENTRE 1 Y 5");
        }

        if (reservation.getChairReserved() > route.getAvailableChairs()) {
            throw new Exception("NO HAY PUESTOS DISPONIBLES PARA LA RUTA");
        }

        if (route.getBasePrice() <= 0) {
            throw new Exception("EL PRECIO DE LA RUTA DEBE SER MAYOR A CERO(0)");
        }

        double total = route.getBasePrice() * reservation.getChairReserved();
        reservation.setTotalPrice(total);

        reservation.setStatus("CONFIRMADA");

        route.setAvailableChairs(route.getAvailableChairs() - reservation.getChairReserved());
        reservationRepository.create(reservation);
    }

    public void cancelReservation(String code) throws Exception {

        Reservation reservation = reservationRepository.getByCode(code);

        if (reservation == null) {
            throw new Exception("NO HAY RESERVA CON ESE CODIGO");
        }

        Route route = reservation.getRoute();
        route.setAvailableChairs(
                route.getAvailableChairs() + reservation.getChairReserved()
        );

        reservation.setStatus("CANCELADA");
    }
}