import java.util.Scanner;
import java.util.Arrays;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = input.nextLine();
        char[] charArray = word.toUpperCase().toCharArray();

        System.out.println(charArray);
        for (int j = 0; j < charArray.length - 1; j++) {
            char firstLetter = charArray[0];
            int i;
            for (i = 0; i < charArray.length - 1; i++) {
                charArray[i] = charArray[i + 1];
            }
            charArray[i] = firstLetter;
            System.out.println(charArray);
        }
    }
}
