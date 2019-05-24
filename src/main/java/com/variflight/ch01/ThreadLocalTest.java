package com.variflight.ch01;

/**
 * @ClassName: ThreadLocalTest
 * @Description:
 * @Author xieyufeng
 * @Date 2019/5/24 07:23
 */
public class ThreadLocalTest {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public void runThreads() {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(new UseRun(i));
            threads[i].start();
        }
    }

    static class UseRun implements Runnable {
        private int id;

        public UseRun(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("threadName" + Thread.currentThread().getName() + " && id = " + threadLocal.get());
            Integer s = threadLocal.get();
            threadLocal.set(s + id);
            System.out.println("threadName" + Thread.currentThread().getName() + " && id = " + threadLocal.get());
            /**
             * 关于ThreadLocalMap<ThreadLocal, Object>弱引用问题，容易造成内存泄露
             * 使用完线程共享变量后，显示调用ThreadLocalMap.remove方法清除线程共享变量；
             * JDK建议ThreadLocal定义为private static ,这样ThreadLocal的弱引用问题则不存在了；
             */
            threadLocal.remove();
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.runThreads();
    }
}
