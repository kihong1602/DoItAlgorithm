package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem003 {

  // 백준 11659 실버3 구간합 구하기
  // 1번째 줄에 수의 개수 N, 합을 구해야하는 횟수 M 이 주어짐.
  // 2번째 줄에 N개의 수가 주어짐. 3번째 줄에는 합을 구해야하는 구간 i와 j가 주어짐

  private static int[] solution(int[] inputs) {
    int[] sectionSum = new int[inputs.length + 1];
    for (int i = 1; i <= inputs.length; i++) {
      sectionSum[i] = sectionSum[i - 1] + inputs[i - 1];
    }
    return sectionSum;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int dataSize = Integer.parseInt(size[0]);
      int querySize = Integer.parseInt(size[1]);
      int[] inputs = new int[dataSize];
      String[] inputData = br.readLine().split(" ");
      for (int i = 0; i < inputData.length; i++) {
        inputs[i] = Integer.parseInt(inputData[i]);
      }

      int[] sums = solution(inputs);

      while (querySize-- > 0) {
        String[] query = br.readLine().split(" ");
        int first = Integer.parseInt(query[0]);
        int last = Integer.parseInt(query[1]);
        int result = sums[last] - sums[first - 1];
        bw.write(result + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
