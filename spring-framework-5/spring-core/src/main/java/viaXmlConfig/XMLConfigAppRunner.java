package viaXmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import viaXmlConfig.autowiring.Customer;
import viaXmlConfig.beans.Point;
import viaXmlConfig.beans.PointWithCons;
import viaXmlConfig.collections.CollectionOfThings;


public class XMLConfigAppRunner {
    public static void main(String[] args) {
        injectBeans();
        injectCollections();
        injectWithAutowiring();
    }

    private static void injectWithAutowiring() {
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("viaXmlConfig/di-autowiring-ctx.xml");

        Customer customerAutowiredByName = appCtx.getBean("customerAutowiredByType", Customer.class);
        System.out.println(customerAutowiredByName.getPerson());
        System.out.println();

        System.out.println("--------------------------------------------");

        Customer customerAutowiredByType = appCtx.getBean("customerAutowiredByType", Customer.class);
        System.out.println(customerAutowiredByType.getPerson());
        System.out.println();

        System.out.println("--------------------------------------------");

        Customer customerAutowiredByCons = appCtx.getBean("customerAutowiredByCons", Customer.class);
        System.out.println(customerAutowiredByCons.getPerson());
        System.out.println();

    }

    private static void injectCollections() {
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("viaXmlConfig/di-collection-ctx.xml");

        CollectionOfThings collectionOfThings = appCtx.getBean("collectionOfThings", CollectionOfThings.class);
        collectionOfThings.getNames().forEach(System.out::println);
        System.out.println();

        CollectionOfThings collectionOfThings2 = appCtx.getBean("collectionOfThingsWithPNamespace", CollectionOfThings.class);
        collectionOfThings2.getNames().forEach(System.out::println);

    }

    private static void injectBeans() {
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("viaXmlConfig/di-bean-ctx.xml"); // Alternatively ("classpath:**/di-bean-ctx.xml")

        System.out.println("--------------------------");
        Point point10 = (Point) appCtx.getBean("point10");
        System.out.println(point10.getX());
        System.out.println(point10.getY());
        System.out.println();

        System.out.println("Spring Beans are Singleton by default:");
        point10.setX(11);

        Point anotherPoint10 = (Point) appCtx.getBean("point10");
        System.out.println(anotherPoint10.getX());
        System.out.println(anotherPoint10.getY());
        System.out.println();

        System.out.println("--------------------------------");

        PointWithCons pointWithCons = (PointWithCons) appCtx.getBean("pointWithCons");
        System.out.println(pointWithCons.getX());
        System.out.println(pointWithCons.getY());
        System.out.println();

        PointWithCons pointWithCoordinatesObj = (PointWithCons) appCtx.getBean("pointWithCoordinatesObj");
        System.out.println(pointWithCoordinatesObj.getX());
        System.out.println(pointWithCoordinatesObj.getY());
        System.out.println();

        PointWithCons pointWithCoordinatesRef = (PointWithCons) appCtx.getBean("pointWithCoordinatesRef");
        System.out.println(pointWithCoordinatesRef.getX());
        System.out.println(pointWithCoordinatesRef.getY());
        System.out.println();
    }
}

class PrePostProcessorRunner {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("viaXmlConfig/post-processing-ctx.xml");
//        appCtx.getBean("randomBean",Coordinates.class);

        appCtx.registerShutdownHook(); // to invoke destroy-method before JVM shuts down; aka graceful shutdown

    }
}