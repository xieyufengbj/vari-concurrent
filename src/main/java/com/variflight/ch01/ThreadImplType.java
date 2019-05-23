package com.variflight.test01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author XieYufeng
 * @ClassName: ThreadImplType
 * @description:
 * @date 2019/5/20 20:33
 */
public class ThreadImplType {
    // 直接继承

    // 实现runnable接口
    static class UseRunable implements Runnable {

        @Override
        public void run() {
            System.out.println("I am runnable!");
        }
    }

    //实现callable接口
    static class UserCall implements Callable {

        @Override
        public Object call() throws Exception {
            System.out.println("I am callable!");
            return "use callable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread01 = new Thread();
        Thread thread02 = new Thread(new UseRunable());

        FutureTask futureTask = new FutureTask(new UserCall());
        Thread thread03 = new Thread(futureTask);

        thread01.start();
        thread02.start();
        thread03.start();
        System.out.println(futureTask.get());
    }
}
