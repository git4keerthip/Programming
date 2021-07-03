package MultiThreading;

import java.util.concurrent.Semaphore;

public class ATMSemaphore {
    Semaphore semaphore = new Semaphore(2);
    private Boolean[] atms = {true,true};
    public void withDrawMoney() {
        try {
            semaphore.acquire();
            System.out.println(" got permit to enter "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
             int atm = getFreeAtms(atms);
        System.out.println(
                Thread.currentThread().getName()
                        + ":-Withdrawing money from atm number :-"
                        + atm);

        System.out.println(
                "---------------------------------");

        try {
            Thread.sleep((long)(Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
                Thread.currentThread().getName()
                        + ":-done withdrawing money");

        synchronized (atms){
                atms[atm] = true;
            }
        System.out.println(atm+" is now free   ");
        semaphore.release();
    }

    private int getFreeAtms(Boolean[] atms) {
        int ret = -1;
        synchronized (atms) {
            if (atms[0]) {
                atms[0] = false;
                ret = 0;
            } else if (atms[1]) {
                atms[1] = false;
                ret = 1;
            }
        }
        return ret;
    }
}
