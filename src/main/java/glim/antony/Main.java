package glim.antony;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *
 * @author antony.glim
 * Created at 04.08.2020
 * @see <https://examples.javacodegeeks.com/core-java/logback-file-appender-example/>
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        ExecutorService executor1 = Executors.newSingleThreadExecutor(new ThreadNameFactory("th1"));
        ExecutorService executor2 = Executors.newSingleThreadExecutor(new ThreadNameFactory("th2"));
        ExecutorService executor3 = Executors.newSingleThreadExecutor(new ThreadNameFactory("th3"));

        executor1.submit(new Printer1());
        executor2.submit(new Printer2());
        executor3.submit(new Printer3());

    }

    static class Printer1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
//                MDC.put("userid", "Thread1");
//                MDC.put("first", "Dorothy111");
//                MDC.put("last", "Parker111");
                log.info("info");
                System.out.println("info1");
//                MDC.remove("userid");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Printer2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                log.info("info2");
                System.out.println("info2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Printer3 implements Runnable {
        @Override
        public void run() {

            for (int i = 0; i < 100; i++) {
                log.trace("info3");
                log.debug("info3");
                log.info("info3");
                log.warn("info3");
                log.error("info3");
                System.out.println("info3");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

