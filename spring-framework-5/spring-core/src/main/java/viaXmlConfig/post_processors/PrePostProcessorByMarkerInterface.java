package viaXmlConfig.post_processors;

import org.springframework.beans.factory.config.BeanPostProcessor;

/*
 * PostProcessors run before and after the initialization of any bean.
 */
public class PrePostProcessorByMarkerInterface implements BeanPostProcessor {

    @Override // overriding a default method in the interface
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        System.out.println("BeanPostProcessor - BeforeInitialization: " + beanName);

        return bean;  // you can return any other object as well
    }

    @Override // overriding a default method in the interface
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        System.out.println("BeanPostProcessor - AfterInitialization: " + beanName);

        return bean;  // you can return any other object as well
    }
}
