import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val = 0;
        System.out.print("Enter an integer between 1 and 20: ");
        val = input.nextInt();
        do {
            for(int i = 0; i < val; i++) {
                if (i == 0) {
                    for (int j = 0; j < val; j++) {
                        System.out.print((j+1) + " ");
                    }
                    System.out.print("\n");
                } else if (i == val - 1) {
                    for (int j = val; j > 0; j--) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                else {
                    System.out.print((i + 1) + " ");
                    for (int j = 0; j < val - 2; j++) {
                        System.out.print("  ");
                    }
                    System.out.print((val - i) + " ");
                    System.out.print("\n");
                }
            }
            System.out.println("Enter an integer between 1 and 20: ");
            val = input.nextInt();
        } while(val >= 1 && val <= 20);
        System.out.println("Number not between 1 and 20. Exiting");
    }

}
