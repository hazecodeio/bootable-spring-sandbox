package viaJavaConfig.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import viaJavaConfig.beans.Coordinates;

@Component("com1") // Make sure to use "@ComponentScan" in a Config file
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SomeComponent {

    @Autowired
    @Qualifier("annotatedCoordinates")
    // "@Qualifier" can be eliminated if field's name is matching the the construct's name  creating the bean to be autowired with this field
    public Coordinates someQualifiedCoordinates;

}
