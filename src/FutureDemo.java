import java.util.concurrent.*;

public class FutureDemo {

    public  class MyThread implements Runnable{

        private Future<Integer> f;
        ExecutorService executorService;
        public MyThread(Future<Integer> f,ExecutorService executorService){
            this.f = f;
            this.executorService  = executorService;
        }
        @Override
        public void run() {
            while(true){
                  if(this.f.isDone()){
                      try {
                          System.out.println("Future is computed:"+f.get());
                          executorService.shutdownNow();
                          Thread.currentThread().stop();
                      } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                      } catch (ExecutionException e) {
                          throw new RuntimeException(e);
                      }
                  }
                  else{
                        System.out.println("Future isn't computed");
                  }
            }
        }
    }

    void basicFutureUsage(){

        Callable<Integer> c = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                Thread.sleep(10000);
                return 100;
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> f =service.submit(c);
        service.execute(new MyThread(f,service));



    }

    
}
