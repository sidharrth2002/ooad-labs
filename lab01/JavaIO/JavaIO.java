public class JavaIO{
     public static void main(String[] args){
         int x=10,y=30;
         System.out.println("This displays a line of text"); 
         System.out.print("This line appears underneath the first,"); 
         System.out.print(" and this appears next to that\n");
         System.out.printf("This line uses printf with %s specifier\n", "one"); 
         System.out.format("This line uses format with %s specifier%n", "one");
         System.out.println("x * y = " + x * y);
         System.out.println("x + y = " + (x + y));
     } 
}
//1. JavaIO
//2. JavaIO.java
//3. %s
//4. doing string concatenation instead of adding
//5. brackets