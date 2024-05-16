package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem036 {

  // 백준 1541 잃어버린 괄호
  // 가장 작은 결과값을 가지려면 최대한 큰 수를 뺴야한다.
  // 따라서 + 연산을 먼저 수행한 후, - 를 진행하도록 구현

  private static int solution(String input) {
    int result = 0;
    String[] splits = input.split("-");
    for (int i = 0; i < splits.length; i++) {
      int sum = sum(splits[i]);
      if (i == 0) {
        result += sum;
      } else {
        result -= sum;
      }
    }
    return result;
  }

  private static int sum(String input) {
    String[] split = input.split("[+]");
    int sum = 0;
    for (String token : split) {
      sum += Integer.parseInt(token);
    }
    return sum;
  }


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String input = br.readLine();
      int result = solution(input);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
