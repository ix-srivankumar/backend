import java.util.Scanner;

class Student {
   private int id;
   private String name;
   private int marks=0;

   public Student(int id,String name,int marks){
     this.id=id;
     this.name=name;
     this.marks=marks;
   }

   public int getId(){
     return this.id;
   }

   public String getName(){
     return this.name;
   }

   public int getMarks(){
     return this.marks;
   }

   public boolean isPassed(){
     return marks >= 40;
   }
}

public class p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        Student[] students = new Student[n];
        
        for(int i = 0; i < n; i++){
            System.out.println("\n Student " + (i+1) + " -- ");
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            
            students[i] = new Student(id, name, marks);
        }
        
        System.out.println("\n Results");
        for(int i = 0; i < n; i++){
            System.out.println("Student " + (i+1) + ": " + students[i].getName() + " - Passed: " + students[i].isPassed());
        }
        
        sc.close();
    }
}



/*
🟢 Problem 4 – OOP: Class, Object & Encapsulation
Problem Statement
Create a class Student with:
Private fields:
id
name
marks
Constructor to initialize values
Getters and setters
Method:
isPassed() → returns true if marks ≥ 40
Create objects of Student and display result.
Must Use
✔ Class & object
✔ Constructor
✔ this keyword
✔ Encapsulation
✔ Methods
*/