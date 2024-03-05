package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem007 {

  // 백준 실버4 1940 주몽의 명령
  // 재료의 개수와 갑옷이 완성되는 값이 주어짐
  // 재료가 주어졌을때, 몇개의 갑옷을 만들 수 있는가?

  private static int solution(int[] stuffs, int target) {
    int count = 0;
    int leftPoint = 0;
    int rightPoint = stuffs.length - 1;
    while (leftPoint < rightPoint) {
      int smallStuff = stuffs[leftPoint];
      int bigStuff = stuffs[rightPoint];
      int sum = smallStuff + bigStuff;
      if (sum < target) {
        leftPoint++;
      } else if (sum > target) {
        rightPoint--;
      } else {
        leftPoint++;
        rightPoint--;
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int suitValue = Integer.parseInt(br.readLine());
      int[] stuffs = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .sorted()
          .toArray();
      int count = solution(stuffs, suitValue);
      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
