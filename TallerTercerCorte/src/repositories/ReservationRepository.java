package repositories;

import entities.Reservation;

import java.util.ArrayList;

public class ReservationRepository {

    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void create(Reservation reservation) {
        reservations.add(reservation);
    }

    public ArrayList<Reservation> getAll() {
        return reservations;
    }

    public Reservation getByCode(String code) {
        for (Reservation r : reservations) {
            if (r.getCode().equals(code)) {
                return r;
            }
        }
        return null;
    }

    public boolean deleteByCode(String code) {
        return reservations.removeIf(r -> r.getCode().equals(code));
    }

    public boolean updateReservation(String code, int newChairReserved, String newStatus) {

        Reservation r = getByCode(code);

        if (r != null) {
            r.setChairReserved(newChairReserved);
            r.setStatus(newStatus);
            return true;
        }

        return false;
    }
}