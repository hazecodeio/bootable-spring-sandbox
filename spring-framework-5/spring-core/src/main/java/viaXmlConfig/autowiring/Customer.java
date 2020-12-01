package viaXmlConfig.autowiring;

public class Customer {

    Person person;

    public Customer() {
    }

    public Customer(Person person) { // will be used to autowire by "constructor"
        this.person = person;
    }

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
