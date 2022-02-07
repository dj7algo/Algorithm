import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		int lastIdx = 0; //배열 마지막부분
		int startIdx = 1000; //배열 시작부분
		
		int maxIdx = 0; //가장 높은 건물 인덱스
		int maxB = 0; //가장 높은 건물 값
		
		for (int i = 0 ; i < N; i++) { //배열에 넣기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			arr[index] = tall;
			if (tall > maxB) {
				maxIdx = index;
				maxB = tall;
			}
			if (index > lastIdx) {
				lastIdx = index;
			}
			if (index < startIdx) {
				startIdx = index;
			}
		}
		int result = 0;
		//최대값 만나기전까지 오르막길
		int maxA = 0;
		for (int i = startIdx ; i<maxIdx;i++) {
			if (maxA < arr[i]) {
				maxA = arr[i];
			}
			result += maxA;
		}
		//최대값
		result += maxB;
		//최대값 만나고난 후 거꾸로 오르막길
		int maxC = arr[lastIdx];
		for (int i = lastIdx ; i > maxIdx ; i--) {
			if( maxC < arr[i] ) {
				maxC = arr[i];
			}
			result += maxC;
		}
		System.out.println(result);

	}
}
