import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceDemo {

    public void Testbasic()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);



        AtomicInteger count= new AtomicInteger();
        while(true)
        {

            if(count.get()>20){
               executorService.shutdown();
                break;
            }

            executorService.execute(()->{
                try {
                    System.out.println("executing");
                    Thread.sleep(5000);//every 5 seconds only three threads are executed
                    synchronized (this){
                        count.getAndIncrement();

                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });


        }

    }
}
