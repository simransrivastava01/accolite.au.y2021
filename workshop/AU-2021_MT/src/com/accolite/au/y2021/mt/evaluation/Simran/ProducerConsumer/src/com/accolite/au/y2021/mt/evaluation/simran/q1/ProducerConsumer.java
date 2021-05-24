
/* Multi threading Assignment
BY SIMRAN SRIVASTAVA (SDE INTERN AT ACCOLITE)*/

package com.accolite.au.y2021.mt.evaluation.simran.q1;
import java.util.*;

public class ProducerConsumer
{
   public static void main(String[] args)
   {
      Stack<Integer> sharedItems=new Stack<Integer>();
      Thread t1=new Thread(new Producer(sharedItems));
      Thread t2=new Thread(new Consumer(sharedItems));
      t1.start();
      t2.start();
   }
}

class Producer implements Runnable
{
    Stack<Integer> sharedItems =null;
    final int MaxSize=5;
    private int i=0;
    public Producer(Stack<Integer> sharedItems)
    {
       super();
       this.sharedItems=sharedItems;
     }
   
     @Override
     public void run()
     {
        while(true)
        try
        {
           produce(i++); 
         }
         catch(InterruptedException e)
         {
         }
      }

     public void produce(int i) throws InterruptedException    //push
     {
        synchronized (sharedItems)
        {
            while(sharedItems.size()==MaxSize)
            {
               System.out.println(" Shared Items are full..waiting for consumer to consume ");
               sharedItems.wait();
             }
         }
        
        synchronized (sharedItems)
        {
               System.out.println(" Producer produced element "+i);
               sharedItems.add(i);
               Thread.sleep(1000);
               sharedItems.notify();
             }
         }              
}

class Consumer implements Runnable
{
    Stack<Integer> sharedItems =null;

    public Consumer(Stack<Integer> sharedItems)
    {
       super();
       this.sharedItems=sharedItems;
     }
   
     @Override
     public void run()
     {
        while(true)
        try
        {
           consume(); 
         }
         catch(InterruptedException e)
         {
         }
      }

     public void consume() throws InterruptedException     //pop
     {
        synchronized (sharedItems)
        {
            while(sharedItems.isEmpty())
            {
               System.out.println(" Shared Items are not present..waiting for the producer to produce ");
               sharedItems.wait();
             }
         }
        
        synchronized (sharedItems)
        {
               Thread.sleep(1000);
               System.out.println(" Consumed the element "+sharedItems.remove(0)); 
               sharedItems.notify();
             }
         }             
}