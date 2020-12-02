package viaJavaConfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"viaJavaConfig.components"})
@Import({BeansConfig.class}) // Since Component is having a dependency on a bean configured in BeansConfig
public class ComponentsConfig {
}
