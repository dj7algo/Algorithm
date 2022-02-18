import java.io.*;
import java.util.*;

public class BOJ10158 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        int x = (q + t) % (2 * W);
        int y = (p + t) % (2 * H);

        x = W - Math.abs(W - x);
        y = H - Math.abs(H - y);

        System.out.println(x + " " + y);
    }
}
