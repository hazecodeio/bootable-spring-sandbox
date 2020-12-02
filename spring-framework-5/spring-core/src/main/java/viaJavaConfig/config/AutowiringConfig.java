package viaJavaConfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import viaJavaConfig.autowiring.Customer;
import viaJavaConfig.autowiring.Person;

@Configuration
public class AutowiringConfig {

    @Bean
    Customer customer() {
        Customer customer = new Customer();
        return customer;
    }

    @Bean
    Person person(){
        Person person = new Person();
        person.setFirstName("Kamal");
        person.setLastName("Harris");
        return person;
    }
}
