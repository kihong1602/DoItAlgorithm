package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem001 {

  //백준 11720 브론즈2 숫자의 합 구하기

  private static int solution(String inputs) {
    return Arrays.stream(inputs.split("")).mapToInt(Integer::parseInt).sum();
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String size = br.readLine();
      String inputs = br.readLine();
      int result = solution(inputs);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
