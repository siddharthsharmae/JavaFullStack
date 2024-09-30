//Made by Siddharth Sharma
import java.util.Scanner;



public class Anagram {

    static boolean check(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] ch = new int[26];



        for (int i = 0; i < a.length(); i++) {
            int x = (int) a.charAt(i);
            int y = (int) b.charAt(i);
            ch[x - 'a']++;
            ch[y - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (ch[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
       boolean result = check(str1, str2);
       if (result)
           System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }
}
