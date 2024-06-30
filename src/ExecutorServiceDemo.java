import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceDemo {

    public void Testbasic()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        //fixed thread pool
        //single thread pool
        //scheduled thread pool
        //cache thread pool
        //work stealing thread pool > Java 7

        AtomicInteger count= new AtomicInteger();


            executorService.execute(()->{

                synchronized (this){

                    System.out.println("executing "+count.get()+" times");
                    try {
                        Thread.sleep(1000);//every 1 seconds only three threads are executed
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                    count.getAndIncrement();
                    if(count.get()>18){

                        executorService.shutdown();

                    }


                }

            });




    }

    public void ScheduledThreadExecutor()   {
        ScheduledExecutorService executorService =   Executors.newScheduledThreadPool(1);

        AtomicInteger count= new AtomicInteger();
        Runnable run = ()-> {



           System.out.println("Task executed "+count.get());
            count.getAndIncrement();
            if(count.get()>5){

                executorService.shutdown();

            }

        };
        executorService.scheduleAtFixedRate(run,0,1,TimeUnit.SECONDS);





        }
    }

