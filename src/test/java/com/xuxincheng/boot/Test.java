package com.xuxincheng.boot;

import com.xuxincheng.bean.Student;

import javax.persistence.Table;
import java.util.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
      /*   System.out.println("启动");
        Integer a = 1;
        System.out.println(a instanceof Object);*/
     /*   Integer b = 130;
        Integer c = 130;
        System.out.println(b == c);*/
  /*      int d = 1;
        Integer e = 1;
        System.out.println(d == e);
        int d1 = 150;
        Integer e1 = 150;
        System.out.println(d1 == e1);
        Integer d2 = 150;
        Integer e2 = 150;
        System.out.println(d2 == e2);*/
       /* int f = 150;
        Long g = 150L;
        System.out.println(g == f);*/
     /*   int f1 = 10000;
        double g1 = 10000.1;
        System.out.println(g1 == f1);
        Double f2 = 100.0;
        Double g2 = 100.0;
        System.out.println(g2 == f2);
        double f3 = 100.0;
        Double g3 = 100.0;
        System.out.println(g3 == f3);
        List l = new ArrayList<>();
        Hashtable k = new Hashtable<>();*/
   /*     System.out.println(0.1*3 == 0.3);//有些特殊浮点数 精度丢失
        System.out.println(0.1*2 == 0.2);
        System.out.println(0.1*6 == 0.6);
        System.out.println(0.1*6);*/
       /* byte a1 = 121;
        byte a2 = 121;
        a1 += a2;
        System.out.println(a1);
        Student student = new Student();
        synchronized(student) {
           // udpClient.wait();

        }
        System.out.println("end");*/


        final  Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行T1");
            }
        });

        final  Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("执行T2");
            }
        });
        final  Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("执行T3");
            }
        });

        System.out.println("za");
        t3.start();
        t1.start();
        //t2.start();

    }
}
