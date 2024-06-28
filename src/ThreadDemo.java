import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreadDemo {

    void testNumbers()
    {
        int maxNUm=100000;

        List<Long> al = new LinkedList<>();

        Runnable task1 = ()->{
               for(long i=1;i<=50000000;i++){
                   try
                   {
                       al.add(i);
                   }catch (OutOfMemoryError e){
                       System.out.println("Out of memoery");
                   }

               }
        };

        Runnable task2 = ()->{
            for(long i=50000001;i<=100000000;i++){
                try
                {
                    al.add(i);
                }catch (OutOfMemoryError e){
                    System.out.println("Out of memoery");
                }
            }
        };


        long s = System.currentTimeMillis();
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.setName("test with threads task1");
        t1.setName("test with threads task2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        long e = System.currentTimeMillis();

        System.out.println("Thread Time elapsed:"+(e-s));

    }

    void testNumbersNoThreads()
    {
        int maxNUm=100000;
        List<Long> al = new LinkedList<>();
        long s = System.currentTimeMillis();

            for(long i=1;i<=100000000;i++){
               al.add(i);
            }








        long e = System.currentTimeMillis();

        System.out.println("no thread Time elapsed:"+(e-s));

    }

    void threadStopTest(){


           Thread t1= new Thread(()->{
               int count=0;
               while(true)
               {

                       System.out.println("Thread runinng");

                      if(Thread.currentThread().interrupted()){
                          count++;
                          if(count < 10)
                          {
                              System.out.println("I got interruption : "+count);

                          }
                          else
                          {
                              System.out.println("Stopping a thread as i was interruped 10 times");
                              Thread.currentThread().stop();
                          }

                      }



               }
           });


           Thread t2= new Thread(()->{
              while(true)
              {
                  synchronized(this)
                  {
                     // System.out.println("thread 2 running");
                      t1.interrupt();

                  }


              }

           });

           t1.start();
           t2.start();





    }
}
