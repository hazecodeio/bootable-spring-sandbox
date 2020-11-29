package xmlConfig._00_DI.autowiring;

import java.util.StringJoiner;

public class Customer {

    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "person=" + person +
                '}';
    }
}
