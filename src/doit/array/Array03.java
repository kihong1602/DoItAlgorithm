package doit.array;

import java.util.Arrays;

public class Array03 {

  private static int sumOf(int[] array) {
    return Arrays.stream(array)
        .sum();
  }

  public static void main(String[] args) {
    int[] array = {2, 5, 1, 3, 9, 6, 7};
    System.out.println("array sum of :: " + sumOf(array));
  }
}
