package com.iio;

public class Mgr06 {
private static Mgr06 ADMIN;
private Mgr06(){}
public static Mgr06 getInstance(){
    if (ADMIN == null) {
        synchronized (Mgr06.class) {
            if (ADMIN == null) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ADMIN = new Mgr06();
            }
        }
    }
    return ADMIN;
}
public void m(){
    System.out.println("m");
}
    public static void main(String[] args) {

        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
//        for (int i = 0; i <100 ; i++) {
//            new Thread(Mgr06::run).start();
//        }
    }
}
