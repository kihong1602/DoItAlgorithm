package doit.array;

import java.util.Arrays;

public class Array05 {

  private static void copy(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) {
      b[i] = a[a.length - 1 - i];
    }
  }

  public static void main(String[] args) {
    int[] array = {2, 5, 1, 3, 9, 6, 7};
    int[] b = new int[array.length];
    copy(array, b);
    System.out.println("array :: " + Arrays.toString(array));
    System.out.println("b :: " + Arrays.toString(b));
  }
}
