public class SortMain {
  public static void main(String[] args) {
    int arr[] = {3, 7, 2, 65, 22, 5, 0, 23};
    MergeSort mSort = new MergeSort(arr);
    System.out.print("Unsorted : ");
    mSort.print();
    mSort.sort();
    System.out.print("Sorted : ");
    mSort.print();
  }
}
