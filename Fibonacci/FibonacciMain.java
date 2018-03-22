import java.util.Scanner;

public class FibonacciMain {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of terms you want to find the sequence till: ");
    int n = sc.nextInt();
    FibonacciManager fib = new FibonacciManager(n);
    fib.first();
    fib.second();
  }
}
