
import java.util.*;

class Methods {
    public int add(int a,int b){
        return a+b;
    }
    public boolean isEven(int num){
        return (num&1) == 0;
    }
    public int factorial(int num){
        if (num <= 1) return 1;
        return num * factorial(num-1);
    }
}
class p3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Methods obj = new Methods();
        System.out.print("ener a and b : ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(" "+obj.add(a,b));
        System.out.print("enter num : ");
        int num=sc.nextInt();
        if (obj.isEven(num)) System.out.println("\n number is even");
        else System.out.println("\n number is odd");
        System.out.println(" "+obj.factorial(num));
        sc.close();
        
    }
}
