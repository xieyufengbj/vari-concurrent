package com.variflight.ch01.wn;

import java.util.Objects;

/**
 * @ClassName: Express
 * @Description:
 * @Author xieyufeng
 * @Date 2019/6/1 16:50
 */
public class Express {

    public final static String CITY = "ShangHai";
    // 里程
    private int km;
    // 位置
    private String site;

    public Express() {

    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm() {
        this.km = 101;
        notifyAll();
    }

    public synchronized void waitKm() {
        while (km <= 100) {
            try {
                wait();
                System.out.println("check km thread["+ Thread.currentThread().getId() +"] ,is notify!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("now km="+ km  +" will be use");
    }

    public synchronized void changeSite() {
        this.site = "Beijing";
        notifyAll();
    }

    public synchronized void waitSite() {
        while (Objects.equals(site, CITY)) {
            try {
                wait();
                System.out.println("check site thread["+ Thread.currentThread().getId() +"] . is notify");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("now site=["+ site +"], will use");
    }
}
