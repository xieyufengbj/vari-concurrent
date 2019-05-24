package com.variflight.ch01;

/**
 * @ClassName: DaemonThread
 * @Description: 若将RunThread设置为守护线程，主线程消亡，守护线程也跟着消亡，
 *               但是不会执行finally中到内容
 * @Author xieyufeng
 * @Date 2019/5/24 06:47
 */
public class DaemonThread {

    static class RunThread extends Thread {

        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println("I am a extends Thread");
                }
                System.out.println("interrupted flag is " + isInterrupted());
            } finally {
                System.out.println("....................finally");
            }
        }
    }

    public static void main(String[] args) {
        RunThread thread = new RunThread();
        //thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
