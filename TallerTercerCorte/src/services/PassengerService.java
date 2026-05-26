package services;

import entities.Passenger;
import repositories.PassengerRepository;

public class PassengerService {

    private PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public void registerPassenger(Passenger passenger) throws Exception {

        if (passenger.getAge() < 0) {
            throw new Exception("LA EDAD DEBE SER IGUAL O MAYOR A CERO (0)");
        }

        if (!passenger.getEmail().contains("@")) {
            throw new Exception("EL CORREO DEBE CONTENER EL ARROBA (@)");
        }

        if (passengerRepository.getById(passenger.getId()) != null) {
            throw new Exception("YA SE ENCUENTRA REGISTRADO");
        }

        for (Passenger p : passengerRepository.getAll()) {
            if (p.getPassport().equals(passenger.getPassport())) {
                throw new Exception("PASAPORTE YA REGISTRADO");
            }
        }

        passengerRepository.create(passenger);
    }

    public Passenger findPassenger(long id) throws Exception {

        Passenger passenger = passengerRepository.getById(id);

        if (passenger == null) {
            throw new Exception("NO SE ENCONTRÓ EL PASAJERO");
        }
        return passenger;
    }

    public void deletePassenger(long id) throws Exception {

        boolean deleted = passengerRepository.deleteById(id);
        if (!deleted) {
            throw new Exception("NO SE PUDO ELIMINAR EL PASAJERO");
        }
    }

    public void updatePassenger(long id, int newAge, String newPhoneNumber) throws Exception {

        if (newAge < 0) {
            throw new Exception("LA EDAD DEBE SER IGUAL O MAYOR A CERO (0)");
        }

        boolean updated = passengerRepository.updatePassenger(id, newAge, newPhoneNumber);

        if (!updated) {
            throw new Exception("NO SE PUDO ACTUALIZAR EL PASAJERO");
        }
    }
}