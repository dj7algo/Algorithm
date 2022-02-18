import java.io.*;
import java.util.*;

public class A10158개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st =new StringTokenizer(br.readLine()," ");
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        p = (p + t) % (2 * w);
        q = (q + t) % (2 * h);
        if (p > w) p = 2 * w - p;
        if (q > h) q = 2 * h - q;
       System.out.println(p+" "+q);
    }
}