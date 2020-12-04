package edge_cases;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/*
 * Inspired by: https://www.baeldung.com/spring-inject-prototype-bean-into-singleton
 */
@Configuration
class ViaLookupAnnotation {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(ViaLookupAnnotation.class);
        SomeSingletonBean singleton1 = appCtx.getBean(SomeSingletonBean.class);
        singleton1.getSomePrototypeBean().counter++;
        System.out.println(singleton1.name);
        System.out.println(singleton1.getSomePrototypeBean().counter);

        singleton1.name = "DEF";

        SomeSingletonBean singleton2 = appCtx.getBean(SomeSingletonBean.class);
        singleton2.getSomePrototypeBean().counter++;
        System.out.println(singleton2.name);
        System.out.println(singleton2.getSomePrototypeBean().counter);
    }

    ////////////////////////////// Bean Wiring /////////////////////////
    @Bean
    @Scope(SCOPE_PROTOTYPE)
    SomePrototypeBean somePrototypeBean() {
        return new SomePrototypeBean();
    }

    @Bean
    SomeSingletonBean someSingletonBean() {
        SomeSingletonBean someSingletonBean = new SomeSingletonBean();
        someSingletonBean.name = "ABC";
        return someSingletonBean;
    }

    @Component
    class TargetLookup {
        @Lookup
        public SomePrototypeBean getSomePrototypeBean() {
            return null;
        }
    }

    /////////////////////////////// Beans ////////////////////////////

    class SomeSingletonBean {
        String name;

        @Autowired
        private TargetLookup targetLookup;

        public SomePrototypeBean getSomePrototypeBean() {
            return targetLookup.getSomePrototypeBean();
        }
    }

    class SomePrototypeBean {
        int counter;

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }

}

@Configuration
class ViaApplicationContextAware {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(ViaApplicationContextAware.class);

        SomeSingletonBean singleton1 = appCtx.getBean(SomeSingletonBean.class);
        singleton1.getSomePrototypeBean().counter++;
        System.out.println(singleton1.name);
        System.out.println(singleton1.getSomePrototypeBean().counter);

        singleton1.name = "DEF";

        SomeSingletonBean singleton2 = appCtx.getBean(SomeSingletonBean.class);
        singleton2.getSomePrototypeBean().counter++;
        System.out.println(singleton2.name);
        System.out.println(singleton2.getSomePrototypeBean().counter);
    }

    ////////////////////////////// Bean Wiring /////////////////////////
    @Bean
    @Scope(SCOPE_PROTOTYPE)
    SomePrototypeBean somePrototypeBean() {
        return new SomePrototypeBean();
    }

    @Bean
    SomeSingletonBean someSingletonBean() {
        SomeSingletonBean someSingletonBean = new SomeSingletonBean();
        someSingletonBean.name = "ABC";
        return someSingletonBean;
    }

    /////////////////////////////// Beans ////////////////////////////

    class SomeSingletonBean implements ApplicationContextAware {
        String name;

        private ApplicationContext appCtx;

        public SomePrototypeBean getSomePrototypeBean() {
            return appCtx.getBean(SomePrototypeBean.class);
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.appCtx = applicationContext;
        }
    }

    class SomePrototypeBean {
        int counter;

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }
    }

}

/*
 * Inspired by: https://www.baeldung.com/spring-inject-prototype-bean-into-singleton
 */
class ViaOtherWaysExplainedByBaeldung {
    /*
     * - Injecting ApplicationContext
     * - Method Injection
     * - ServiceLoader.Provider
     * - Scoped Proxy
     * - ObjectFactory Interface
     * - java.util.Function
     */
}