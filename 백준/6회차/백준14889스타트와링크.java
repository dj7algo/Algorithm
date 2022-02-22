package a0222;
import java.util.*;
public class 백준14889스타트와링크 {

	static int num;
	static int[] result;
	static int[] result2;
	static int[][] arr;
	static int minnum = Integer.MAX_VALUE;
	
	static int cal() {
		
		int startsum = 0;
		int linksum = 0;
		
		for(int i=0; i<num/2; i++) {
			for(int j=i+1; j<num/2; j++) {
				startsum+=arr[result[i]][result[j]];
				startsum+=arr[result[j]][result[i]];
			}
		}
		
		int idx = 0;
		for(int i=0; i<num; i++) {
			int flag = 0;
			for(int j=0; j<num/2; j++) {
				if(i==result[j]) {
					flag = 1;
				}
			}
			if(flag==0)result2[idx++]=i;
		}
		
		for(int i=0; i<num/2; i++) {
			for(int j=i+1; j<num/2; j++) {
				linksum+=arr[result2[i]][result2[j]];
				linksum+=arr[result2[j]][result2[i]];
			}
		}
//		System.out.println(Arrays.toString(result));
//		System.out.println(Arrays.toString(result2));
//		System.out.println(linksum+" "+startsum);
		return Math.abs(linksum-startsum);
	}
	
	static void findmin(int cnt, int idx) {
		
		if(cnt==num/2) {
			int nownum = cal();
			if(minnum>nownum) {
				minnum = nownum;
			}
			return;
		}
		
		for(int i=idx; i<num; i++) {
			result[cnt] = i;
			findmin(cnt+1, i+1);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		result = new int[num/2];
		result2 = new int[num/2];
		arr = new int[num][num];
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		findmin(0, 0);
		System.out.println(minnum);
	}

}
