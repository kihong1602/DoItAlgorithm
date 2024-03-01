package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem000 {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int[] array = {2, 6, 45, 1, 35, 91, 18, 3};

      Arrays.sort(array);
      bw.write(Arrays.toString(array));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
