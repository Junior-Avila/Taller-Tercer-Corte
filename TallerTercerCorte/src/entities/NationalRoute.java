package entities;

public class NationalRoute extends Route{

    private double estimatedDuration;
    private boolean scale;

    public NationalRoute(String code, String originCity, String arrivalCity, String dateExit, String timeExit, String estimatedTime, int capacity, int availableChairs, double basePrice, String status, double estimatedDuration, boolean scale) {
        super(code, originCity, arrivalCity, dateExit, timeExit, estimatedTime, capacity, availableChairs, basePrice, status);
        this.estimatedDuration = estimatedDuration;
        this.scale = scale;
    }

    public double getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(double estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public boolean isScale() {
        return scale;
    }

    public void setScale(boolean scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return super.toString()+
                "NationalRoute{" +
                "estimatedDuration=" + estimatedDuration +
                ", scale=" + scale +
                '}';
    }
}
