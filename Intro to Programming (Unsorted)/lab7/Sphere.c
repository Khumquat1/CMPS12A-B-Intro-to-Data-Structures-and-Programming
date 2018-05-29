/*  Sphere.c 
 *  Kevin Duong
 *  keduong
 *  lab7
 *  Computes the volume and surface area of a sphere given a user inputted radius.
*/
#include<stdio.h>
#include<math.h>

int main(void){
   double radius,surfacearea, volume;
   const double pi = 3.141592654;
   
   printf("Enter the radius of the sphere: ");
   scanf("%lf", &radius);
   
   volume = (4.0/3.0)*pi*pow(radius,3);
   surfacearea = 4.0*pi*pow(radius,2);

   printf("The volume is %f", volume);
   printf(" and the surface area is %f", surfacearea);
   printf(".\n");   
   return 0;
}
