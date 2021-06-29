import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MultiThreading implements Executor{
    @Override
    public void execute(Runnable command) {
        command.run();
        Thread t1 = (Thread) command;

        System.out.println("execute method "+t1.isAlive());
    }
    public static void main (String args[]){

        MultiThreading mt = new MultiThreading();
        Thread t1 = new Thread();
        t1.start();
        mt.execute(t1);
        main(3);
        System.out.println("Thread t1 " +t1.isAlive());
       // main(new String[]{"12"}); //goes to infinite loop
    }
    public static void main(int r){
        System.out.println("overloaded main ");
    }
}
