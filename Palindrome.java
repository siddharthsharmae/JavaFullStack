
import java.util.Scanner;

//Program to check whether a string is palindrome or not
public class Palindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i)==' ') i++;
            if(s.charAt(j)==' ') j--;
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean result = isPalindrome(str);
        if(result) System.out.println("Palindrome");
        else System.out.println("Not Palindrome");
    }
}
