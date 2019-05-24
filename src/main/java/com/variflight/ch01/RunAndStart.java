package com.variflight.ch01;

/**
 * @ClassName: RunAndStart
 * @Description:
 * @Author xieyufeng
 * @Date 2019/5/24 06:41
 */
public class RunAndStart {

    public static class RunThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("["+ Thread.currentThread().getId() +"], 线程名：" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread thread = new RunThread();
        // 相当于直接调用普通对象的方法
        //thread.run();
        // 调用start，虚拟机会将该方法映射到操作系统中线程
        thread.start();
    }
}
