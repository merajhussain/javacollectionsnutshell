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



        StreamsDemo streamsDemo = new StreamsDemo();
        streamsDemo.simpleTest();
        streamsDemo.testHighestSalaryInDepartment();

       ThreadDemo demo = new ThreadDemo();
       // demo.testNumbersNoThreads();

       // demo.testNumbers();
        demo.threadStopTest();

        ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo();
        //executorServiceDemo.Testbasic();
        executorServiceDemo.ScheduledThreadExecutor();

        FutureDemo futureDemo = new FutureDemo();

        futureDemo.basicFutureUsage();

        Integer i= 20;

        StringBuilder sb = new StringBuilder();
        


    }
}