// Simultation.java
// Kevin Duong
// keduong
// 12B - PA4
// May 9th, 2016
// Simulation that finds time to complete m jobs

import java.io.*;
import java.util.Scanner;

public class Simulation{
 
    public static Job getJob(Scanner in) {
      String[] s = in.nextLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int b = Integer.parseInt(s[1]);
      return new Job(a, b);
   }
  
   public static int getIndex(Queue[] s){
      int index = 0;
      if(((Job)s[index].peek()).getFinish() == -1){
         index = 1;
      }
      for(int i = 1; i<s.length;i++){
         if(s[i].length() < s[index].length()){
            if(s[i].length() == s[index].length()){
               index = index;
            }else{ 
            index = i;
            }
         }else if(s[i].length() < s[index].length() && (((Job)s[index].peek())).getFinish() != -1){
            index = index;
         }
      }
      return index;
   }

   public static int numJobs(Scanner in){
      int a;
      String s = in.nextLine();
      a = Integer.parseInt(s);
      return a;
   }      
   
   public static void printTrace(PrintWriter trace, Queue[] s, int n, int time){
      trace.println("time = " +time);
      for(int i = 0;i < n+1;i++){
         trace.println(i+": "+ s[i]);
      }
   }

   public static void main(String[] args) throws IOException{
 
     //variables
     Scanner in = null;
     PrintWriter report = null;
     PrintWriter trace = null;
     Queue storQueue = new Queue();
     int n,m,time;
   
     //invalid input
     if(args.length<1){
        System.err.println("Usage: Simulation input_file");
        System.exit(1);
     }
 
     //initilize input
     in = new Scanner(new File(args[0]));
     report = new PrintWriter(new FileWriter(args[0]+".rpt"));
     trace = new PrintWriter(new FileWriter(args[0]+".trc"));
     
     //declares m job and Queue
     m = numJobs(in);
     while(in.hasNext()){
        storQueue.enqueue((Job)getJob(in));
     }
     trace.println("Trace file: " +args[0] + ".trc");
     trace.println(m + " Jobs:");
     trace.println(storQueue+"\n");
     
     for(n=1;n<m;n++){
        time =0;
        Queue[] sim = new Queue[n+1];
        for(int i =0; i<n+1;i++){
           sim[i] = new Queue();
        }
    
        trace.println("*****************************");
        trace.println(n +" processor:");
        trace.println("*****************************");

        sim[0]= storQueue;
        while(((Job)sim[0].peek()).getFinish() == -1 || sim[0].length()!=m){
           if(time==0){  
              printTrace(trace,sim,n,time);
              time = ((Job)sim[0].peek()).getArrival();
              sim[1].enqueue(sim[0].dequeue());
              Job temp = (Job)sim[1].peek();
              temp.computeFinishTime(time);
           }else if(((Job)sim[0].peek()).getFinish() != -1){
              int z = getIndex(sim);
              time = ((Job)sim[z].peek()).getFinish();
              sim[0].enqueue(sim[z].dequeue());
              printTrace(trace,sim,n,time);
           }else{
              printTrace(trace,sim,n,time);
              int z = getIndex(sim);
           
              if(sim[z].length() == 0){
                 time = ((Job)sim[0].peek()).getArrival();
                 sim[z].enqueue(sim[0].dequeue());
                 Job temp = (Job)sim[z].peek();
                 temp.computeFinishTime(time);
                 printTrace(trace,sim,n,time);
 
                 z = getIndex(sim);
                 time = ((Job)sim[z].peek()).getFinish();
                 sim[0].enqueue(sim[z].dequeue());
                 printTrace(trace,sim,n,time);
             
                 z = getIndex(sim);
                 time = ((Job)sim[0].peek()).getFinish();
                 sim[z].enqueue(sim[0].dequeue());
                 temp=(Job)sim[z].peek();
                 temp.computeFinishTime(time);
                 printTrace(trace,sim,n,time);
         
                 time = ((Job)sim[z+1].peek()).getFinish();
                 sim[0].enqueue(sim[z+1].dequeue());
                 printTrace(trace,sim,n,time);
             
                 z = getIndex(sim);
                 time = ((Job)sim[z-1].peek()).getFinish();
                 sim[0].enqueue(sim[z-1].dequeue());
                 printTrace(trace,sim,n,time);
              }else if(((Job)sim[0].peek()).getArrival()<=((Job)sim[z].peek()).getFinish()){
                 time = ((Job)sim[0].peek()).getFinish();
                 sim[z].enqueue(sim[0].dequeue());
                 printTrace(trace,sim,n,time);
 
                 time = ((Job)sim[z].peek()).getFinish();
                 sim[0].enqueue(sim[z].dequeue());
                 Job temp=(Job)sim[z].peek();
                 temp.computeFinishTime(time);
                 printTrace(trace,sim,n,time);
              }else{
                 Job temp=(Job)sim[z].peek();
                 temp.computeFinishTime(time);
                 printTrace(trace,sim,n,time); 
       
                 time = ((Job)sim[z].peek()).getFinish();
                 sim[0].enqueue(sim[z].dequeue());
                 printTrace(trace,sim,n,time);             
              }
            }
         } 
         if(n==1){
            report.println("Report file: "+ args[0]+".rpt");
            report.println(m + " Jobs:");
            report.println(sim[0] +"\n");
            report.println("*****************************");
         }
         double avgWait=0.0;
         int totWait=0;
         int maxWait=0;
         int max=0;
         Queue holdQueue = new Queue();
      
         while(sim[0].length() !=0){
            max = ((Job)sim[0].peek()).getWaitTime();
            if (maxWait < max){          
               maxWait = max;
            }
            totWait += ((Job)sim[0].peek()).getWaitTime();
            holdQueue.enqueue((Job)sim[0].dequeue());
         }
         avgWait=(double)totWait/m;
         report.println(n+" processor: totalWait="+ totWait+" maxWait="+maxWait+" averageWait="+avgWait);
      
         while(holdQueue.length() !=0){
            ((Job)holdQueue.peek()).resetFinishTime();
            storQueue.enqueue((Job)holdQueue.dequeue());
         }
         trace.println();
      }      
   in.close();
   report.close();
   trace.close();
   } 
  
}

