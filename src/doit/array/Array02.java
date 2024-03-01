package doit.array;

import java.util.Arrays;

public class Array02 {

  private static void swap(int[] array, int index1, int index2) {
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

  private static void reverse(int[] array) {
    for (int i = 0; i < array.length / 2; i++) {
      int index2 = array.length - i - 1;
      System.out.printf("a[%d]과 a[%d]을 교환합니다.\n", i, index2);
      swap(array, i, index2);
      System.out.println(Arrays.toString(array));
    }
  }

  public static void main(String[] args) {
    int[] array = {2, 5, 1, 3, 9, 6, 7};
    reverse(array);
  }
}
