import java.util.ConcurrentModificationException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.test();

        ListDemo listDemo = new ListDemo();

       listDemo.testStudents();

       StuedentComparisionDemo sdemp = new StuedentComparisionDemo();

       sdemp.testComparators();

    }
}