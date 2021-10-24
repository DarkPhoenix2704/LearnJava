import java.util.Scanner;
public class kalkulatorCLI {
    
    public static void main(String args[])
    {
         Scanner input = new Scanner(System.in);
         int bil1, bil2, pil ,hasil = 0;
         System.out.println("SIMPLE CALCULATOR");
         System.out.println("1. multiplication");
         System.out.println("2. division");
         System.out.println("3. addition");
         System.out.println("4. subtraction");
         System.out.println("----------------------------");
         System.out.print("Number 1:");
         bil1=input.nextInt();
         System.out.print("Number 2:");
         bil2=input.nextInt();
         System.out.print("select options:");
         pil=input.nextInt();
         
         switch (pil){
             case 1 : hasil=bil1*bil2;break;
             case 2 : hasil=bil1/bil2;break;
             case 3 : hasil=bil1+bil2;break;
             case 4 : hasil=bil1-bil2;break;
             default : System.out.println("wrong input options");
         }
         
          System.out.println("Results :"+hasil);
    }
}