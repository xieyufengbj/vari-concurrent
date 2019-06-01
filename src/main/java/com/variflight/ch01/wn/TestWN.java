package com.variflight.ch01.wn;

/**
 * @ClassName: TestWN
 * @Description:
 * @Author xieyufeng
 * @Date 2019/6/1 17:12
 */
public class TestWN {
    public static Express express = new Express(0, Express.CITY);

    public static class ThreadWaitSite extends Thread {
        @Override
        public void run() {
           express.waitSite();
        }
    }

    public static class ThreadWaitKm extends Thread {
        @Override
        public void run() {
            express.waitKm();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new ThreadWaitSite().start();
        }

        for (int i = 0; i < 3; i++) {
            new ThreadWaitKm().start();
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        express.changeKm();
    }
}
