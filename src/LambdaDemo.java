
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {



    public interface  compute{

          int calc(int a,int b);

    }

    public interface Task {
        void run();
    }

    void testLambda(){

           compute add = (int a,int b)-> a+b;
           compute sub = (int a, int b)->a-b;
           compute mod = (int a,int b)->a%b;
           compute mul = (int a,int b)->a*b;

           System.out.println(add.calc(1,2));
        System.out.println(sub.calc(2,1));
        System.out.println(mul.calc(1,2));
        System.out.println(mod.calc(2,1));
    }

    void testLambda1(){

        doTask(()->System.out.println("task running"));

        //anonymous classes
        doTask(new Task() {
            @Override
            public void run() {
                System.out.println("Overridden task using anonymous class");
            }
        });

    }

    void doTask(Task task)
    {
        task.run();
    }

    void testJdkFunctionalInterfaces(){

        //Function FI takes one arguement and returns a value
        Function<Integer,Integer> square = x->x*x;

        //Consumer FI takes one arguement and returns nothing
        //Using lambdas
        Consumer<String> greeting = (name)->System.out.println("Hello "+name);

        //Using method references
        Consumer<String> greetingMethodReference = System.out::println;


        //Supplier FI takes no arguments but returns a value
        Supplier<Double>    pi= ()-> 3.14;
        //Predicate takes any number of arguments and returns true or false;
        Predicate<Integer> isEven=(x)->x%2==0;

        


        Function<Integer,Double> areaCircle = (x)->pi.get()*x*x;

        System.out.println(square.apply(2));
        greeting.accept("meraj");
        System.out.println(areaCircle.apply(4));

        System.out.println(isEven.test(4));


        greetingMethodReference.accept("hello meraj method reference");

    }

    void testChainingLambdas()
    {
          Function<Integer,Integer> increment = x->++x;
          Function<Integer,Integer> squareIt = x ->x*x;

          Function<Integer,Integer> incrementAndSquareIt=increment.andThen(squareIt);
          

    }
}


