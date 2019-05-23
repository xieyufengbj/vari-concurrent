package com.variflight.ch01;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author XieYufeng
 * @ClassName: OnlyMain
 * @description:
 * @date 2019/5/19 21:26
 */
public class OnlyMain {

    public static void main(String[] args) {
        // 虚拟机线程管理入口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("["+ threadInfo.getThreadId() +"] " + threadInfo.getThreadName());
        }
    }
}
