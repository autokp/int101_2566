package work02;

import work01.*;
import java.util.Objects;

public class Person {
    private static int nextId = 1;
    private final int id;
    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = Utilitor.testString(firstname);
        this.lastname = Utilitor.testString(lastname);
        this.id=nextId++;
    }

    @Override
    public  String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname+'" + lastname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && Objects.equals(getFirstname(), person.getFirstname()) && Objects.equals(getLastname(), person.getLastname());
    }
}
