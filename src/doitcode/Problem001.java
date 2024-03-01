package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem001 {

  //백준 11720 브론즈2 숫자의 합 구하기

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String input = br.readLine();
      int sum = 0;
      for (char token : input.toCharArray()) {
        sum += token - '0';
      }
      bw.write(String.valueOf(sum));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
