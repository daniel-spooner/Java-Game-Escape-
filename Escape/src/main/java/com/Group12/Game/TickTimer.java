package com.Group12.Game;

import java.lang.*;

public class TickTimer implements Runnable {

   //Thread t;
   int FPS;

   public TickTimer() {
	   FPS = 30;
   }
   
   public TickTimer(int FPS) {
	   this.FPS = FPS;
   }
  
   
   public void run() {
      for (int i = 10; i < 13; i++) {

         // System.out.println(Thread.currentThread().getName() + "  " + i);
         try {
            Thread.sleep(1000 / this.FPS);
         } catch (Exception e) {
            System.out.println(e);
         }
      }
   }

   public static void main(String[] args) throws Exception {
      
	  Thread t = new Thread(new TickTimer(1));
      t.start();
      
   }
} 

