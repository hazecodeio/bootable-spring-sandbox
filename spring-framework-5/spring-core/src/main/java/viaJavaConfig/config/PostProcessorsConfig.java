package viaJavaConfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import viaJavaConfig.post_processors.BeanWithInitDestroyMethods;
import viaJavaConfig.post_processors.PostProcessorByMarkerInterface;

@Configuration
public class PostProcessorsConfig {

    @Bean
    public PostProcessorByMarkerInterface postProcessorByMarkerInterface(){
        return new PostProcessorByMarkerInterface();
    }

    @Bean
    public BeanWithInitDestroyMethods beanWithInitDestroyMethods(){
        BeanWithInitDestroyMethods beanWithInitDestroyMethods = new BeanWithInitDestroyMethods();
        beanWithInitDestroyMethods.setMsg("Random Message");
        return beanWithInitDestroyMethods;
    }
}
