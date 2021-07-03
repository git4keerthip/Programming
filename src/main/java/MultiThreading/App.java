package MultiThreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String args[]){
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0; i<20;i++) {
            executorService.execute(() -> new ATMSemaphore().withDrawMoney());
        }
       executorService.shutdown();
    }
}
