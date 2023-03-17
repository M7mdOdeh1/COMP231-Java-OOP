import java.util.*;

 class Q1{
   public static void main(String[] args){

        double kilogram,centimeteres,bmi;

         Scanner inp= new Scanner(System.in);
          System.out.println("Please enter the Weight in kilograms");
            kilogram = inp.nextDouble();
             
           System.out.println("Please enter the height in centimeteres");
             centimeteres = inp.nextDouble();
                      
              bmi= (kilogramToPound(kilogram)*703)/Math.pow(centimetresToInches(centimeteres),2);
             

                if(bmi<15)
                    System.out.println("Very thin");
                 else if(bmi>=15 && bmi<19)
                      System.out.println("Underweight");
                  else if(bmi>=19 && bmi<25)
                        System.out.println("Normal");
                    else if(bmi>=25 && bmi<30)
                          System.out.println("Overweight");
                      else 
                            System.out.println("Over Obesity");
                                              
      }


    public static double centimetresToInches(double centimetres){
             
           return centimetres*0.39;

      }

    
    public static double kilogramToPound(double kilogram){

           return kilogram*2.2; 

     }

  }