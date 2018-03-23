import java.util.Scanner;

public class LongestSubMain {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter String 1:");
    String str1 = sc.nextLine();
    System.out.println("Enter String 2:");
    String str2 = sc.nextLine();
    LongestSubFinder finder = new LongestSubFinder();
    finder.longestFinder(str1, str2);
    System.out.println("Longest substring: " + finder.longest());
    System.out.println("Length of subString: " + finder.maxLength());
  }
}
