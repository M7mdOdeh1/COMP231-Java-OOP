/* This program to fine the avarage of 10 number*/

import java.util.*;

 class Q2{

  public static void main(String[] args){

       double avg, number,sum=0;
       int count=0;

   Scanner input= new Scanner(System.in);

     System.out.println("Please enter the ten numbers");
      while(count<10)
        {  
          number=input.nextDouble();
          sum+=number;
          count++;
        }

      avg=sum/10;
      
      System.out.println("the avarage is: "+avg);

    }


  }