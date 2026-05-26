package entities;

public class Route {

    private String code;
    private String originCity;
    private String arrivalCity;
    private String dateExit;
    private String timeExit;
    private String estimatedTime;
    private int capacity;
    private int availableChairs;
    private double basePrice;
    private String status;

    public Route(String code, String originCity, String arrivalCity, String dateExit, String timeExit, String estimatedTime, int capacity, int availableChairs, double basePrice, String status) {
        this.code = code;
        this.originCity = originCity;
        this.arrivalCity = arrivalCity;
        this.dateExit = dateExit;
        this.timeExit = timeExit;
        this.estimatedTime = estimatedTime;
        this.capacity = capacity;
        this.availableChairs = availableChairs;
        this.basePrice = basePrice;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDateExit() {
        return dateExit;
    }

    public void setDateExit(String dateExit) {
        this.dateExit = dateExit;
    }

    public String getTimeExit() {
        return timeExit;
    }

    public void setTimeExit(String timeExit) {
        this.timeExit = timeExit;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableChairs() {
        return availableChairs;
    }

    public void setAvailableChairs(int availableChairs) {
        this.availableChairs = availableChairs;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Route{" +
                "code='" + code + '\'' +
                ", originCity='" + originCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", dateExit='" + dateExit + '\'' +
                ", timeExit='" + timeExit + '\'' +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", capacity=" + capacity +
                ", availableChairs=" + availableChairs +
                ", basePrice=" + basePrice +
                ", status='" + status + '\'' +
                '}';
    }
}
