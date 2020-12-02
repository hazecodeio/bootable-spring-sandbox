package viaJavaConfig.post_processors;

import org.springframework.beans.factory.config.BeanPostProcessor;

/*
 * PostProcessors run before and after the initialization of any bean.
 */
public class PostProcessorByMarkerInterface implements BeanPostProcessor {

    @Override // overriding a default method in the interface
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        System.out.println("BeanPostProcessor - BeforeInitialization: " + beanName);

        return bean;  // Any other object can be returned as well
    }

    @Override // overriding a default method in the interface
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        System.out.println("BeanPostProcessor - AfterInitialization: " + beanName);

        return bean;  // Any other object can be returned as well
    }
}
