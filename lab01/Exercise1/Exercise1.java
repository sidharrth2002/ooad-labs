import java.util.Scanner;

public class Exercise1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val = 0;
        System.out.print("Enter an integer between 1 and 20: ");
        val = input.nextInt();
        do {
            for(int i = 0; i < val; i++) {
                if (i == 0 || i == val - 1) {
                    for (int j = 0; j < val; j++) {
                        System.out.print("* ");
                    }
                    System.out.print("\n");
                } else {
                    System.out.print("* ");
                    for (int j = 0; j < val - 2; j++) {
                        System.out.print("  ");
                    }
                    System.out.print("* ");
                    System.out.print("\n");
                }
            }
            System.out.println("Enter an integer between 1 and 20: ");
            val = input.nextInt();
        } while(val >= 1 && val <= 20);
        System.out.println("Number not between 1 and 20. Exiting");
    }

}
