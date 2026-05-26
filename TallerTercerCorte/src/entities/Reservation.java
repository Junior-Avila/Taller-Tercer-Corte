package entities;

public class Reservation {

    private String code;
    private Passenger passenger;
    private Route route;
    private int chairReserved;
    private String reservationDate;
    private double totalPrice;
    private String status;

    public Reservation(String code, Passenger passenger, Route route, int chairReserved, String reservationDate, double totalPrice, String status) {
        this.code = code;
        this.passenger = passenger;
        this.route = route;
        this.chairReserved = chairReserved;
        this.reservationDate = reservationDate;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getChairReserved() {
        return chairReserved;
    }

    public void setChairReserved(int chairReserved) {
        this.chairReserved = chairReserved;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "code='" + code + '\'' +
                ", passenger=" + passenger +
                ", route=" + route +
                ", chairReserved=" + chairReserved +
                ", reservationDate='" + reservationDate + '\'' +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
