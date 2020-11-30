package xmlConfig._00_dependency_injection;

import xmlConfig._00_dependency_injection.autowiring.Customer;
import xmlConfig._00_dependency_injection.collections.CollectionOfThings;
import xmlConfig._00_dependency_injection.beans.Point;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xmlConfig._00_dependency_injection.beans.PointWithCons;


public class _00_AppRunner {
    public static void main(String[] args) {
        injectBeans();
        injectCollections();
        injectWithAutowiring();
    }

    private static void injectWithAutowiring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlConfig/_00_dependency_injection/di-autowiring-ctx.xml");

        Customer customerAutowiredByName = applicationContext.getBean("customerAutowiredByType", Customer.class);
        System.out.println(customerAutowiredByName.getPerson());
        System.out.println();

        System.out.println("--------------------------------------------");

        Customer customerAutowiredByType = applicationContext.getBean("customerAutowiredByType", Customer.class);
        System.out.println(customerAutowiredByType.getPerson());
        System.out.println();

        System.out.println("--------------------------------------------");

        Customer customerAutowiredByCons = applicationContext.getBean("customerAutowiredByCons", Customer.class);
        System.out.println(customerAutowiredByCons.getPerson());
        System.out.println();

    }

    private static void injectCollections() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlConfig/_00_dependency_injection/di-collection-ctx.xml");

        CollectionOfThings collectionOfThings = applicationContext.getBean("collectionOfThings", CollectionOfThings.class);
        collectionOfThings.getNames().forEach(System.out::println);
        System.out.println();

        CollectionOfThings collectionOfThings2 = applicationContext.getBean("collectionOfThingsWithPNamespace", CollectionOfThings.class);
        collectionOfThings2.getNames().forEach(System.out::println);

    }

    private static void injectBeans() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xmlConfig/_00_dependency_injection/di-bean-ctx.xml"); // Alternatively ("classpath:**/di-bean-ctx.xml")

        System.out.println("--------------------------");
        Point point10 = (Point) applicationContext.getBean("point10");
        System.out.println(point10.getX());
        System.out.println(point10.getY());
        System.out.println();

        System.out.println("Spring Beans are Singleton by default:");
        point10.setX(11);

        Point anotherPoint10 = (Point) applicationContext.getBean("point10");
        System.out.println(anotherPoint10.getX());
        System.out.println(anotherPoint10.getY());
        System.out.println();

        System.out.println("--------------------------------");

        PointWithCons pointWithCons = (PointWithCons)applicationContext.getBean("pointWithCons");
        System.out.println(pointWithCons.getX());
        System.out.println(pointWithCons.getY());
        System.out.println();

        PointWithCons pointWithCoordinatesObj = (PointWithCons)applicationContext.getBean("pointWithCoordinatesObj");
        System.out.println(pointWithCoordinatesObj.getX());
        System.out.println(pointWithCoordinatesObj.getY());
        System.out.println();

        PointWithCons pointWithCoordinatesRef = (PointWithCons)applicationContext.getBean("pointWithCoordinatesRef");
        System.out.println(pointWithCoordinatesRef.getX());
        System.out.println(pointWithCoordinatesRef.getY());
        System.out.println();
    }
}
