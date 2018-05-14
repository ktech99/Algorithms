import java.util.Scanner;

public class Closure {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter file name");
    String fileName = sc.nextLine();
    Scanner input = new Scanner(new File(fileName));
    List<String> lines = new ArrayList<>();
    while (input.hasNextLine()) {
      String next = input.nextLine().trim();
      if (next.length() > 0) {
        lines.add(next);
      }
    }
    ClosureCalc solver = new closureCalc(Collections.unmodifiableList(lines));
  }
}
