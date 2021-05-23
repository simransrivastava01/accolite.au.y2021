package com.accolite.au.y2021.mt.evaluation.hitesh.q5;

import java.util.Scanner;

class counter
{
    volatile int c1;
    volatile int c2;
    int c3;
    boolean SecondConsumed =true;
    boolean ThirdConsumed = true;
    int maxCount = Integer.MIN_VALUE;

    public counter(int maxCount){
        this.maxCount = maxCount;
        c1=0;
        c2=0;
        c3=0;
    }

    public synchronized void increment1()
    {
        c1++;
    }
    public synchronized void increment2()
    {
        c2+=2;
    }
    public synchronized void increment3()
    {
        c3++;
    }
    public synchronized void takeWait(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void notifyOthers(){
        notify();
    }
}



class Mainn
{

    public static void main(String[] args) throws InterruptedException {

        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        counter obj1=new counter(n);
        Thread t2=new Thread(new Runnable(){
            public void run(){
                while(obj1.c1<=obj1.maxCount){
                    if(obj1.c1 %25 ==0 && obj1.c1 !=0 && !obj1.SecondConsumed){
                        obj1.increment2();
                        if(!obj1.ThirdConsumed){
                            obj1.takeWait();
                        }
                        if(obj1.c2 %4 == 0 && obj1.c2 !=0 ) {
                            obj1.ThirdConsumed = false;
                        }
                        obj1.SecondConsumed =true;
                        System.out.println("Counter 2-> "+obj1.c2);
                        obj1.notifyOthers();
                        obj1.takeWait();
                    }
                }
            }});

        Thread t1=new Thread(new Runnable(){
            public void run(){
                while(obj1.c1<obj1.maxCount){
                    obj1.increment1();
                    System.out.println("Counter 1-> "+obj1.c1);
                    if(!obj1.SecondConsumed || !obj1.ThirdConsumed){
                        obj1.takeWait();
                    }
                    if(obj1.c1 %25 == 0 && obj1.c1 !=0 ){
                        obj1.SecondConsumed = false;
                        obj1.notifyOthers();
                        obj1.takeWait();
                    }
                }
                while(!obj1.SecondConsumed && !obj1.ThirdConsumed);
                    obj1.increment1();
                    obj1.notifyOthers();
            }});

        Thread t3=new Thread(new Runnable(){
            public void run(){
                while(obj1.c1<=obj1.maxCount){
                    if(obj1.c2 %4 ==0 && obj1.c2 !=0 && !obj1.ThirdConsumed){
                        obj1.increment3();
                        obj1.ThirdConsumed = true;
                        System.out.println("Counter 3-> "+obj1.c3);
                        obj1.notifyOthers();
                    }
                }
            }});
        t1.start();
        t2.start();
        t3.start();
    }
}