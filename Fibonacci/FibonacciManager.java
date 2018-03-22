public class FibonacciManager {

  private int term;

  public FibonacciManager(int term) {
    this.term = term;
  }

  public void first() {
    int val1 = 0;
    int val2 = 1;
    int val3 = 0;
    for (int i = 1; i < term; i++) {
      val3 = val1 + val2;
      val1 = val2;
      val2 = val3;
    }
    System.out.println(val2);
  }

  public void second() {
    int fib[] = new int[term + 1];
    fib[0] = 0;
    fib[1] = 1;
    for (int i = 2; i <= term; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }
    System.out.println(fib[term]);
  }
}
