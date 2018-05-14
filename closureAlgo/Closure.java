import java.io.*;
import java.util.*;

public class Closure {
  public static void main(String args[]) throws FileNotFoundException {
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
    ClosureCalc solver = new ClosureCalc();
    solver.mapper(Collections.unmodifiableList(lines));
    while (solver.completer() == 1) ;
  }
}
