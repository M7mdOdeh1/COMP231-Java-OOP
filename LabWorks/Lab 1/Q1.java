/*This program to take information from student then print it*/
import java.util.*;

  class Q1 {

  public static void main(String[] args){

    String name,id,course,instructor,section;


    Scanner input= new Scanner(System.in);

    System.out.println("Enter the name: ");
      name= input.nextLine();     
    System.out.println("Enter ID:");
      id = input.nextLine();
    System.out.println("Enter Course Name: ");
       course= input.nextLine();
    System.out.println("Enter instructor name: ");
       instructor=input.nextLine();
    System.out.println("Enter the section number: ");
       section= input.nextLine();

   System.out.println("Your name : " +name);
   System.out.println("Your ID: " +id);
   System.out.println("Instructor name: " +instructor);
   System.out.println("Course name: " +course);
   System.out.println("Section number: "+section);


     }


  }