import java.util.*;

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the N: ");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=2;i<=n;i=i+2){
            System.out.print(i+" ");
        }
        System.out.println();
        int total_sum=0;
        for (int i=1;i<=n;i++){
            total_sum+=i;
        }
        System.out.println("Total sum: " + total_sum);
        sc.close();
    }
}
