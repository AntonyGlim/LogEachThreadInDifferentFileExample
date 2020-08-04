package glim.antony;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/*
 *
 * @author a.yatsenko
 * Created at 29.07.2020
 */
public class ThreadNameFactory implements ThreadFactory {

    private final AtomicLong threadIndex = new AtomicLong(0);
    private final String threadNamePrefix;

    public ThreadNameFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("th-" + threadNamePrefix + "-" + threadIndex.getAndIncrement());
        return thread;
    }

}
