package com.iio;

public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr01 m1 = new Mgr01();
        Mgr01 m2 = new Mgr01();
        System.out.println(m2 == m2);
    }

    public void m() {
        System.out.println("m");
    }
}
