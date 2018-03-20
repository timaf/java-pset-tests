package at.refugeescode.javapsettests.pset1.model;

public class Actor {

    private String name;
    private Gender gender;

    public Actor(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Actor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
