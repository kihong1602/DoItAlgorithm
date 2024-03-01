package doit.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Array01 {

  private static int maxOf(int[] a) {
    int max = a[0];
    for (int token : a) {
      if (token > max) {
        max = token;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Random random = new Random();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("키의 최댓값을 구합니다.");
      int num = random.nextInt(20);
      System.out.printf("사람수 : %d\n", num);
      int[] height = new int[num];

      System.out.println("키 값은 아래와 같습니다.");
      for (int i = 0; i < num; i++) {
        height[i] = 100 + random.nextInt(90);
        System.out.printf("height[%d]: %d\n", i, height[i]);
      }
      System.out.printf("최댓값은 %d 입니다.\n", maxOf(height));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
