[백준 1026 보물](https://www.acmicpc.net/problem/1026)

```

B에 있는 수를 재배열하면 안된다. 라는 문구때문에 PERMUTATION으로 풀었다가.
시간초과가나서, 다시 생각해보니 문제에서 요구하는 답은
S의 최솟값이였다.

그러므로, 배열 B의 가장큰값에, 배열A의 가장작은값을 순서대로 곱하면서 더해주면 
S의 최솟값이 나오기 때문에, 

A는 오름차순,
B는 내림차순으로 정렬하여 문제 해결.

여기서, 정렬 시 Custom으로 작성한 Comparator는 속도에 영향을 미치므로,
내림차순 정렬은 Collections.reverseOrder API를 사용하자.

```