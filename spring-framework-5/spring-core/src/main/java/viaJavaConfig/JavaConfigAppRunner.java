package viaJavaConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import viaJavaConfig.autowiring.Customer;
import viaJavaConfig.beans.Coordinates;
import viaJavaConfig.beans.PointWithCons;
import viaJavaConfig.collections.CollectionOfThings;
import viaJavaConfig.components.SomeComponent;
import viaJavaConfig.config.*;

import java.util.List;

import static _util.Utils.printClassNameViaStackWalker;
import static _util.Utils.printMethodNameViaStackWalker;

public class JavaConfigAppRunner {

    @Autowired
    public PointWithCons annotatedPointWithCons;

    public static void main(String[] args) {
        printClassNameViaStackWalker(1);

        injectBeans();
        injectCollection();
        injectComponent();
        injectWithAutowiring();
        postProcessor();
    }

    private static void injectBeans() {
        printMethodNameViaStackWalker(1);

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(BeansConfig.class);
        Coordinates annotatedCoordinates = appCtx.getBean("annotatedCoordinates", Coordinates.class);
        System.out.println(annotatedCoordinates);
        System.out.println();

        Coordinates anotherAnnotatedCoordinates = appCtx.getBean("anotherAnnotatedCoordinates", Coordinates.class);
        System.out.println(anotherAnnotatedCoordinates);
        System.out.println();
    }

    private static void injectComponent() {
        printMethodNameViaStackWalker(1);

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(ComponentsConfig.class);

        SomeComponent com1 = appCtx.getBean("com1", SomeComponent.class);
        System.out.println(com1.someQualifiedCoordinates);

        SomeComponent anotherCom1 = appCtx.getBean("com1", SomeComponent.class);
        System.out.println(anotherCom1.someQualifiedCoordinates);

        System.out.println(com1 == anotherCom1);

    }

    private static void injectCollection() {
        printMethodNameViaStackWalker(1);

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(CollectionConfig.class);
        CollectionOfThings collectionOfThings = appCtx.getBean(CollectionOfThings.class);
        System.out.println(collectionOfThings);
        System.out.println();

        CollectionOfThings collectionOfThings2 = appCtx.getBean(CollectionOfThings.class);
        System.out.println(collectionOfThings2);
        System.out.println();


        List<String> names1 = appCtx.getBean("names", List.class);
        System.out.println(names1);
        System.out.println();

        List<String> names2 = appCtx.getBean("names", List.class);
        System.out.println(names2);
        System.out.println();

        System.out.println(names1 == names2);
    }

    private static void injectWithAutowiring() {
        printMethodNameViaStackWalker(1);

        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AutowiringConfig.class);

        Customer customer = appCtx.getBean(Customer.class);
        System.out.println(customer);
        System.out.println();
    }

    private static void postProcessor() {
        printMethodNameViaStackWalker(1);

        AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(PostProcessorsConfig.class);
        appCtx.registerShutdownHook(); // to invoke destroy-method before JVM shuts down; aka graceful shutdown
        System.out.println();
    }

}
