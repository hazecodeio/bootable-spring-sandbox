package viaJavaConfig.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import viaJavaConfig.beans.Coordinates;
import viaJavaConfig.beans.PointWithCons;

@Configuration
public class BeansConfig {

    @Bean
    // Method's name will be the bean's name. It can be overridden by the @Ben's value
    public Coordinates annotatedCoordinates() {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(123);
        coordinates.setY(456);
        return coordinates;
    }

    @Bean
    // @Qualifier can be eliminated if Parameter's name is matching the method's name returning the target bean
    public PointWithCons annotatedPointWithCons(@Qualifier("anotherAnnotatedCoordinates") Coordinates coordinates) {

        PointWithCons pointWithCons = new PointWithCons(coordinates);
        return pointWithCons;
    }

    @Bean
    public Coordinates anotherAnnotatedCoordinates() { // Method's name will be the bean's name
        Coordinates coordinates = new Coordinates();
        coordinates.setX(12300);
        coordinates.setY(45600);
        return coordinates;
    }

}