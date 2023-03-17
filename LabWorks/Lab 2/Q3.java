import java.util.*;

  class Q3{
    public static void main(String[] args){
      int number;
    
        Scanner inp= new Scanner(System.in);
 
         System.out.println("Enter a number (less than 2 to end)");         
          for(number = inp.nextInt(); number>=2; number = inp.nextInt()){
            
             if(number>500){
               System.out.println("please enter a number less than 500 and more than 2 (or less than 2 to end)");
               continue;
               }    
              
             if(isPrime(number))
               System.out.println(number + " is prime");
              else
                System.out.println(number + " is not prime");   
         
              System.out.println("Enter a number (less than 2 to end)");             
           }    
 
                 System.out.println("Shutting down the program...");      
           
    }
 
   public static boolean isPrime( int number){

      boolean isprime=true;
       for(int x=2; x<=number/2; x++){
           
          if((number%x)==0){
            isprime=false;
            break;
            }
        } 
         return isprime;
    }

 }