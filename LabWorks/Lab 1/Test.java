/* this program will calculate the area of circle*/

import java.util.*;

 class Test{
      final static double PI=22.0/7;
       public static void main(String[] args){
  
         double radius,area;

           Scanner input= new Scanner(System.in); 

          System.out.println("Please enter the radius of the circle");
          
          radius=input.nextDouble();
          area=computeArea(radius); 
          System.out.println("Area= "+area); 

        }  
         
       public static double computeArea(double radius){

          return radius*radius*PI;

       }   

   }