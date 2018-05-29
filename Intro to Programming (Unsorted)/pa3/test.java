import java.util.Scanner;
class test{
   public static void main (String[] args){
      Scanner sc = new Scanner(System.in);
      int num1, num2, x=1, y=1,z;
System.out.print("first #: ");
num1 = sc.nextInt();
System.out.print("seoond #: ");
num2 = sc.nextInt();
while(num1 == 0 && num2 == 0){
System.out.println("The GCD of 0 and 0 cannot be computed. Please try again.");
System.out.print("first #: ");
num1 = sc.nextInt();
System.out.print("second #: ");
num2 = sc.nextInt();
}
if (num1 > num2){
x = num1;
y = num2;
}
else {
y = num1;
x = num2;
}
while(x != 0 && y!= 0){
z = x% y;
x = y;
y = z;

if (z==0) break;
}
while (x ==0 ^ y==0){
if (x==0){
y = y;
}
else
y=x;
}

System.out.println("gcd = "+y+".");
   }
}


     
