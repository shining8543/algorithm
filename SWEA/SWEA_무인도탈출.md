---
## SWEA 무인도 탈출
### **Idea**
* 블록이 가로, 세로, 높이로 주어지는데 가로가 제일 길이가 작고 높이가 제일 크도록 값을 서로 바꿔준다. (블록을 위로 올릴 수 있는지 확인하는 연산을 최소화 하기 위해)
* 고려해줄 것은 크게 3가지, 1)어떤 블록을 사용할 것인가 2)어떤 블록을 먼저 사용할 것인가 3)어느 면을 사용할 것인가
* 블록은 최대 20가지로 2^20의 경우의 확인 해주어야 한다
* 어느 블록을 제일 먼저 사용할지도 고려해주어야한다.
* 블록의 순서도 고려해주어야 한다.
* 소요되는 시간은 최악의 경우 n^2 * 2^n 이 된다 (n=20)
* 이미 확인한 블록 조합에 대해선 메모리제이션 해주어 최대값을 바로 반환해준다.
* 블록 선택 여부 bit로 관리


### ** 핵심 부분 구현**
```java
    private static int choice_block(int N, int bit,int now, int x,int y,int way) {
        //System.out.println(bit);
        if(dp[now][way][bit] != 0)
            return dp[now][way][bit];
         
        int height=0;
        int temp;
        for(int i=0;i<N;i++) {
            if((bit  & (1 << (i))) !=0) continue;
             
             
            if(x >= block[i].n && y>= block[i].m) {
                temp = choice_block(N,bit | (1 << (i)),i,block[i].n,block[i].m,0) + block[i].h; 
                if(height < temp) height =temp;;
            }
            if(x >= block[i].n && y>= block[i].h) {
                temp =choice_block(N,bit | (1 << (i)),i,block[i].n,block[i].h,1) + block[i].m;
                if(height < temp) height = temp;
            }
             
            if(x >= block[i].m && y>= block[i].h) {
                temp = choice_block(N,bit | (1 << (i)),i,block[i].m,block[i].h,2) + block[i].n;
                if(height < temp) height = temp;
            }
             
        }
         
        return dp[now][way][bit] = height;
    }
```

### 정리
시간이 굉장히 빡빡한 문제였다

메모리를 생성해줄 때 dp[bit][now][way]로 하면 stack에서 메모리 초과가 발생한다

dp[now][way][bit]로 하면 bit에 해당하는 것들이 모두 heap에 저장되어서 그런지 메모리 초과가 발생하지 않는다.

이는 자바의 메모리에 대해서 좀 더 파고 들어가야 정확히 알 것 같다.

static 변수는 method area에 저장되어서 stack과 heap과는 별개로 저장될 것이라고 생각했고,

배열이기에 첫 주소값만 참조하고 나머지 실제 메모리는 heap에 할당 될 것이라고 생각했는데 그렇지 않은 듯 하다.