public class SortMain {
  public static void main(String[] args) {
    int arr[] = {3, 7, 2, 65, 22, 5, 0, 23};
    BubbleSort bSort = new BubbleSort(arr);
    System.out.print("Unsorted : ");
    bSort.print();
    bSort.sort();
    System.out.print("Sorted : ");
    bSort.print();
  }
}
