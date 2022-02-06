package tomyself;


import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static ArrayList<Node> list = new ArrayList<>();
	static ArrayList<Node> left = new ArrayList<>();	
	static ArrayList<Node> right = new ArrayList<>();	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	// 기둥의 개수
		
		int mid = 0;
		for(int i=0; i<n; i++) {
			String [] input = br.readLine().split(" ");
			list.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		Collections.sort(list);	// x좌표 기준으로 정렬
		
		// 가장 높은 기둥을 기준으로 왼쪽 / 오른쪽을 나눈다
		// 왼쪽 과 오른쪽 모두 증가하는 부분만 담는다.
		
		// 가장 높은 기둥 찾기
		int max = 0;
		
		int left_mid=0;
		int right_mid =0;		// 가장 높은기둥이 여러개일경우 구분을 해야하기때문에 left,right미드를 둠
		for(int i=0; i<n; i++) {
			if(list.get(i).y > max) {
				max = list.get(i).y;
				left_mid =i;
				right_mid = i;
			}
			if(list.get(i).y == max) {
				right_mid = i;
			}
		}
		
		
		// 증가하는 왼쪽기둥만 넣는다 가장 왼쪽의 경우 시작점이니 들어가고 시작해야한다
		left.add(list.get(0));
		int left_h = list.get(0).y;
		for(int i=1; i<left_mid; i++) {
			if(list.get(i).y > left_h) {
				left_h = list.get(i).y;
				left.add(list.get(i));
			}
		}
		
		// 증가하는 오른쪽 기둥만 넣는다 가장 오른쪽도 시작점이니 들어가고 시작해야 한다.
		right.add(list.get(n-1));
		int right_h = list.get(n-1).y;
		
		for(int i=n-2; i>right_mid; i--) {
			if(list.get(i).y > right_h) {
				right_h = list.get(i).y;
				right.add(list.get(i));
			}
		}
		
		int left_sum = 0;	// 왼쪽 구간합
		int right_sum = 0; 	// 오른쪽 구간합
		
		
		for(int i=0; i<left.size()-1; i++) {
			int w = left.get(i+1).x-left.get(i).x;
			left_sum += w*left.get(i).y;
			
		}
		Node last_left = left.get(left.size()-1);
		int w = list.get(left_mid).x - last_left.x;
		left_sum += w * last_left.y;
		
		
		for(int i=0; i<right.size()-1; i++) {
			w = Math.abs(right.get(i).x - right.get(i+1).x);
			right_sum += w*right.get(i).y;
		}
		Node last_right = right.get(right.size()-1);
		w = Math.abs(list.get(right_mid).x - last_right.x);
		right_sum += w * last_right.y;
		
		
		
		int sum = 0;
		if(right_mid == left_mid) sum+=list.get(right_mid).y;
		else sum+= (list.get(right_mid).x - list.get(left_mid).x+1) * max;
		sum+= right_sum+left_sum;
		System.out.println(sum);
	}

 }
class Node implements Comparable<Node>{
	int x,y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		return this.x - o.x;
	}
}