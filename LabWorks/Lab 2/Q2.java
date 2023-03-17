import java.util.*;

  class Q2{
     public static void main(String[] args){
       
        double hours_worked,hourly_rate,salary;
         
          Scanner inp = new Scanner(System.in);
            
           System.out.println("Enter the hours worked(-1 to end)");                  
   
            for(hours_worked= inp.nextDouble(); hours_worked != -1; hours_worked= inp.nextDouble()){  
             
              System.out.println("Enter hourly rate of the worker");   
               hourly_rate= inp.nextDouble();
            
                if(hours_worked<=40)
                   salary= hours_worked*hourly_rate;
                  else
                    salary= (40*hourly_rate)+(hours_worked-40)*(1.5*hourly_rate);
 
               System.out.println("Salary is $" + salary);
               System.out.println("Enter the hours worked(-1 to end)");

              }

          System.out.println("Shutting down the program...");

    }



 } 