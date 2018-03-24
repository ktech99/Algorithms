import java.util.Arrays;

public class MergeSort {

  private int arr[];

  public MergeSort(int arr[]) {
    this.arr = arr;
  }

  public void sort() {
    sort(arr);
  }

  private void sort(int list[]) {
    int length = list.length;
    if (length < 2) {
      return;
    }
    int mid = length / 2;
    int i = 0;
    int left[] = new int[mid];
    int right[] = new int[length - mid];
    for (i = 0; i <= (mid - 1); i++) {
      left[i] = list[i];
    }
    for (i = mid; i <= (length - 1); i++) {
      right[i - mid] = list[i];
    }
    sort(left);
    sort(right);
    merge(left, right, list);
  }

  public void merge(int l[], int r[], int c[]) {

    int i = 0;
    int j = 0;
    int count = 0;

    while ((i < l.length) && (j < r.length)) {
      if (l[i] <= r[j]) {
        c[count] = l[i];
        i += 1;
      } else {
        c[count] = r[j];
        j += 1;
      }
      count += 1;
    }
    while (i < (l.length)) {
      c[count] = l[i];
      i += 1;
      count += 1;
    }
    while (j < (r.length)) {
      c[count] = r[j];
      j += 1;
      count += 1;
    }
  }

  public void print() {
    System.out.println(Arrays.toString(arr));
  }
}
