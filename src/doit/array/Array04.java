package doit.array;

import java.util.Arrays;

public class Array04 {

  private static void copy(int[] a, int[] b) {
    System.arraycopy(a, 0, b, 0, a.length);
  }

  public static void main(String[] args) {
    int[] array = {2, 5, 1, 3, 9, 6, 7};
    int[] b = new int[array.length];
    copy(array, b);
    System.out.println("array equals b ? " + Arrays.equals(array, b));
  }
}
