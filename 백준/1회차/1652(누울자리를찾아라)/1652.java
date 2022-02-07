import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] abc = new char[N][N];
		for (int i = 0 ; i < N; i++) {
			String abc2= sc.next();
			for (int j = 0 ; j < N ; j++) {
				abc[i][j] = abc2.charAt(j);
			}
		}
//		int num_true = 0;
		int rowcnt = 0;
		int colcnt = 0;
		for (int i = 0 ; i < N; i++) {
			int x_true = 0;
            int y_true = 0;
			for (int j = 0 ; j < N; j++) {
				//가로줄
				if (abc[i][j] == '.') {
					x_true++;
				}else {
					if (x_true >= 2) {
						x_true = 0;
						rowcnt++;
					}else {
						x_true = 0;
					}
				}
				if (j == N-1) {
					if (x_true >= 2) {
						rowcnt++;
					}
				}
				//세로줄
                if (abc[j][i] == '.') {
					y_true++;
				}else {
					if (y_true >=2) {
						y_true = 0;
						colcnt++;
					}else {
						y_true = 0;
					}
				}
				if (j == N-1) {
					if (y_true >= 2) {
						colcnt++;
					}
				}
			}
		}
		System.out.println(rowcnt+ " " +colcnt);
	}
}