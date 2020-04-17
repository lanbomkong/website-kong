package com.biosh.owner.daily_log;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author konglingbiao
 * @description
 * @date 2020/3/31
 */
public class ThreadParable {


    private static AtomicInteger semaphore = new AtomicInteger(1);

    public void methodA() {
        while (true) {
            if (1 == semaphore.get()) {
                System.out.println("exe method A");
                break;
            }
        }
        semaphore.incrementAndGet();

    }

    public void methodB() {
        while (true) {
            if (2 == semaphore.get()) {
                System.out.println("exe method B");
                break;
            }
        }
        semaphore.incrementAndGet();
    }

    public void methodC() {
        while (true) {
            if (3 == semaphore.get()) {
                System.out.println("exe method C");
                break;
            }
        }
        semaphore.incrementAndGet();
    }


}
