package viaJavaConfig.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import viaJavaConfig.collections.CollectionOfThings;

import java.util.List;

@Configuration
public class CollectionConfig {


    /*
     * This bean is Singleton!
     * Even though the List<String> is of prototype scope, it'll never get a different List
     * Because the same bean will be retrieved
     * So, don't be confused by the prototype scope on one of its fields
     */
    @Bean
    public CollectionOfThings collectionOfThings(List<String> names) {
        CollectionOfThings collectionOfThings = new CollectionOfThings();
        collectionOfThings.setNames(names);
        return collectionOfThings;
    }

    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    // If this bean is retrieved independently of the previous bean, then a new one will be created
    public List<String> names() {
        return List.of("Joe", "Kamala");
    }
}
