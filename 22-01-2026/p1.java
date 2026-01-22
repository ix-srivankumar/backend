import java.util.Scanner;
public class p1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.print("Enter a number : ");
        int num= sc.nextInt();

        if (num<0) System.out.println("Negative");
        else if (num==0) System.out.println("Zero");
        else System.out.println("Positive");

        if((num & 1) == 1) System.out.println("Odd");
        else System.out.println("Even");
        sc.close();
    }
}
