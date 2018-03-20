// Prints out Fizz Buzz for every number divisible by 3 and 5
// Showing the runtime difference between checking one statement vs checking 2
public class FizzBuzz {
  public static final int size = 100;

  public static void main(String[] args) {
    int arr[] = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = i + 1;
    }
    for (int i = 0; i < size; i++) {
      if (arr[i] % 15 == 0) {
        System.out.println(arr[i] + " FizzBuzz");
      }
      // if (arr[i] % 3 == 0 && arr[i] % 5 == 0) {
      //   System.out.println(arr[i] + " FizzBuzz");
      // }
    }
  }
}
