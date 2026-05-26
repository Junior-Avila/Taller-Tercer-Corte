package entities;

public class InternationalRoute extends Route{

    private String country;
    private boolean passportRequire;
    private double chargeInternational;

    public InternationalRoute(String code, String originCity, String arrivalCity, String dateExit, String timeExit, String estimatedTime, int capacity, int availableChairs, double basePrice, String status, String country, boolean passportRequire, double chargeInternational) {
        super(code, originCity, arrivalCity, dateExit, timeExit, estimatedTime, capacity, availableChairs, basePrice, status);
        this.country = country;
        this.passportRequire = passportRequire;
        this.chargeInternational = chargeInternational;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isPassportRequire() {
        return passportRequire;
    }

    public void setPassportRequire(boolean passportRequire) {
        this.passportRequire = passportRequire;
    }

    public double getChargeInternational() {
        return chargeInternational;
    }

    public void setChargeInternational(double chargeInternational) {
        this.chargeInternational = chargeInternational;
    }

    @Override
    public String toString() {
        return super.toString()+
                "InternationalRoute{" +
                "country='" + country + '\'' +
                ", passportRequire=" + passportRequire +
                ", chargeInternational=" + chargeInternational +
                '}';
    }
}
