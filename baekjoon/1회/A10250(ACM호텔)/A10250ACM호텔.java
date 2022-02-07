import java.io.*;

/**
 * A10250
 */
public class A10250ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
          String str[] = br.readLine().split(" ");
          int H = Integer.parseInt(str[0]);
          int N = Integer.parseInt(str[2]);
          if (N % H == 0)
            bw.write(Integer.toString(H * 100 + (N / H)) + '\n');
          else
            bw.write(Integer.toString((N % H) * 100 + (N / H + 1)) + '\n');
        }
        br.close();
        bw.close();
      }
}