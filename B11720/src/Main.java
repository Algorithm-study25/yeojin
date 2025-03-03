import java.util.Scanner;

/**
 * 2025-03-03
 * 백준 11720
 */
///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int n = sc.nextInt();
         String s = sc.next();
         char c[] = s.toCharArray();

         int total = 0;

         for(int i = 0; i < c.length; i++){
             total += c[i] - '0';
        }
         System.out.println(total);
         sc.close();
    }
}