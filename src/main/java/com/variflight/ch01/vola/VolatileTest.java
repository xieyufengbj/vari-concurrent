package com.variflight.ch01.vola;

/**
 * @ClassName: VolatileTest
 * @Description:
 *      关键字volatile是Java虚拟机提供的最轻量级的同步机制；
 *      当一个变量定义为volatile之后，具备两种特性
 *              第一 保证此变量对所有线程对可见性；
 *                  volatile适用的运算场景：运算结果并不依赖变量的当前值，或者能够确保只有单一的线程修改变量的值；
 *                                        变量不需要与其它的状态变量共同参与不变约束；
 *              第二 禁止指令重排序优化；
 * @Author xieyufeng
 * @Date 2019/5/24 07:42
 */
public class VolatileTest {

    private static volatile Integer race = 0;

    public static void increase() {
        race++;
    }

    public static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() == 1) {
            Thread.yield();
        }
        System.out.println("race = " + race);
    }
}
