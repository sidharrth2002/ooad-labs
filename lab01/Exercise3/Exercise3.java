import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val = 0;
        System.out.print("Enter an integer between 1 and 20: ");
        val = input.nextInt();
        do {
            int topValue = val * val - 1;
            for (int i = 1; i <= val; i++) {
                for (int j = i; j <= topValue + i; j=j+val) {
                    System.out.format("%5d", j);
                }
                System.out.println();
            }
            System.out.println("Enter an integer between 1 and 20: ");
            val = input.nextInt();
        } while(val >= 1 && val <= 20);
        System.out.println("Number not between 1 and 20. Exiting");
    }
}
