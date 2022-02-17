package a0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 백준10158개미 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int garo = Integer.parseInt(st.nextToken());
		int sero = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int starti = Integer.parseInt(st.nextToken());
		int startj = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(br.readLine());
		int x = garo - Math.abs(garo - (starti + T) % (garo * 2));
		int y = sero - Math.abs(sero - (startj + T) % (sero * 2));
		System.out.println(x + " " + y);
	}
}
