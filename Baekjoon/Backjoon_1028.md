---
## Baekjoon 1028 다이아몬드 광산
### **Idea**
* 현재 점까지 4방향의 대각선에서 오는 최대 길이를 기록
* 현재 아래에서 오는 길이 중 최소값 이내로 위에서 오는 길이가 존재하는지 확인
* 현재 만들 수 있는 다이아 크기의 최대값보다 작은 길이를 가진 곳은 확인하지 않고 넘긴다.

### ** 핵심 부분 구현**
```java
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				int k = Math.min(dp[i][j][2], dp[i][j][3]);
				if(k < result) continue;
				for(int l=k;l>0;l--) {
					int rev = (l-1)*2 + i; //반대편 꼭지점
					if(rev > R) continue;
					
					if(dp[rev][j][0] >= l && dp[rev][j][1] >= l) {
						result = Math.max(result, l);
						break;
					}
					
				}
			}
		}
```

### 정리
