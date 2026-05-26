package entities;

public class Person {

    private long id;
    private int age;
    private String names;
    private String lastNames;

    public Person(long id, int age, String names, String lastNames) {
        this.id = id;
        this.age = age;
        this.names = names;
        this.lastNames = lastNames;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                '}';
    }
}
