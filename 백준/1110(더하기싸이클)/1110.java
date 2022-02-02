package ps;

import java.util.*;

public class B1110 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//배열 이용 3자리 만들기 나머지 연산 이용 
		// /10 은 0번째로, %10은 1번째로 
		// (0번째수 + 1번째수)%10 + 1번째수 * 10 = 2번째 
		// 2번째수를 다시 0번째 1번째로 반복 
		
		int firstnum = sc.nextInt();
		int[] nums = new int[3];
		int cnt = 0;
		int num = firstnum;
		
		while(true) {
			nums[0] = num/10;
			nums[1] = num%10;		//따로 10보다 작은수 예외처리 필요 없음 
			
			nums[2] = (nums[0]+nums[1])%10 + nums[1]*10;
			cnt++;
			
			if(nums[2]==firstnum) {
				System.out.println(cnt);
				break;
			}else {
				num = nums[2]; 
			}
		}
	}
}
