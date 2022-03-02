package week6;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BJ_13458_시험감독 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //시험장 수
		StringTokenizer testcase = new StringTokenizer(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); //총감독 커버리지.
		int C = Integer.parseInt(st.nextToken()); //부감독 커버리지.
		BigInteger all = new BigInteger("0");
		for (int i = 0 ; i < N ; i++) {
			BigInteger student = BigInteger.valueOf(Integer.parseInt(testcase.nextToken()));
			student = student.subtract(BigInteger.valueOf(B));//총감독 하나 빼고 시작한다 
			all = all.add(new BigInteger("1")); //감독수 증가
			if (student.compareTo(BigInteger.valueOf(0)) < 0) { //근데 0명밖에 안남으면 나가
				continue;
			}
			
			BigInteger a = student.mod(BigInteger.valueOf(C)); //나머지
			BigInteger b = student.divide(BigInteger.valueOf(C)); //몫
			all = all.add(b);
			if (a.compareTo(BigInteger.valueOf(0)) != 0) {
				all = all.add(BigInteger.valueOf(1));
			}
			
		}
		System.out.print(all.toString());
		// N개의 시험장
		// Ai 시험장에 있는 응시자 수
		//감독관: 총감독 (B명감시가능) , 부감독 (C명 감시가능)
		//총감독은 무조건 1명, 부감독관은 여러명가능 ㅇㅇ
		// 필요한 [감독관수]의 최솟값 구하기
		br.close();
	}
}
