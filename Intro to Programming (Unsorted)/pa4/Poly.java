import java.util.Scanner;
class Poly{
   public static void main(String[] args){
     
      Scanner sc= new Scanner(System.in);
      
      System.out.print("Enter the degree: ");
         int degree = sc.nextInt();
      System.out.print("Enter "+(degree+1)+" coefficents: ");
         double[] C= new double[degree+1];
         for(int i =0; i<C.length;i++){
            C[i]=sc.nextDouble();
         }
      System.out.print("Enter the left and right endpoints: ");
         double a = sc.nextInt();
         double b = sc.nextInt();
      System.out.println(poly(C,a));
      System.out.println(poly(C,b));
      System.out.println(C);
      System.out.println(diff(C));
   }

   static double poly(double[] C, double x){
      int a=C.length-1;
      double sum=0.0;
      for(int i=0;i<a;i++){
         sum+=C[i]*Math.pow(x,(a-i));
      }
      return sum;
   }
   
   static double[] diff(double[]C){
      int n = C.length-1;
      double []D = new double[n];
      for(int i=0; i<n;i++){
         D[i]=C[i]*(n-1);
      }
      return D;
   }
 
   static double findRoot(double[] C, double a, double b, double tolerance){
      double mid = 0.0, width;
      width = b-a;
      while(width>tolerance);
         mid = (a+b)/2;
         if(poly(C,
}
