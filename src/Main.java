import java.util.ConcurrentModificationException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.test();

        ListDemo listDemo = new ListDemo();

       listDemo.testStudents();

       StuedentComparisionDemo sdemp = new StuedentComparisionDemo();

       sdemp.testComparators();

       SetDemo setDemo = new SetDemo();
       setDemo.testHashSet();
       setDemo.testLinkedHashSet();

       MapDemo mapDemo = new MapDemo();
       mapDemo.testHashMap();

       LambdaDemo lambdaDemo = new LambdaDemo();
       lambdaDemo.testLambda();
       lambdaDemo.testLambda1();
       lambdaDemo.testJdkFunctionalInterfaces();
       lambdaDemo.testChainingLambdas();


    }
}