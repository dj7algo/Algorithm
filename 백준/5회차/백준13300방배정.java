package a0217;
import java.util.*;

public class 방배정 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int maxnum = sc.nextInt();
		
		int[][] student = new int[2][7];
		
		for(int i=1; i<=num; i++) {
			int s = sc.nextInt();
			int grade = sc.nextInt();
			student[s][grade]++;
		}
		
		int sum = 0;
		for(int i=0; i<=1; i++) {
			for(int j=1; j<=6; j++) {
				sum+=student[i][j]/maxnum;
				if(student[i][j]%maxnum!=0)sum++;
			}
		}
		
		System.out.println(sum);
	}
}
