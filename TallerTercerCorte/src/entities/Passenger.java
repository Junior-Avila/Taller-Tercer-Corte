package entities;

public class Passenger extends Person {

    private String email;
    private String phoneNumber;
    private String passport;
    private String nationality;

    public Passenger(long id, int age, String names, String lastNames, String email, String phoneNumber, String passport, String nationality) {
        super(id, age, names, lastNames);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Passenger{" +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
