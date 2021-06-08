---
## Backjoon_16118 달빛여우
### **Idea**
* 달빛 여우의 경우 일반적인 다익스트라 알고리즘을 적용
* 달빛 늑대의 경우, 정점에 홀수 번째에 도착하는 경우와 짝수 번째에 도착하는 결과 값을 따로 저장해준다


### ** 핵심 부분 구현**
```java
while (!wolf_pq.isEmpty()) {
			now_node = wolf_pq.poll();
			now = now_node.index;
			dist = now_node.weight;
			type=  now_node.type;
			next_type = -(type-1);
			if (wolf_result[type][now] < dist)
				continue;
			for (Node node : edge[now]) {
				long weight = type == 0 ? node.weight/2 : node.weight*2;
				if (wolf_result[type][now] + weight < wolf_result[next_type][node.index]) {
					wolf_result[next_type][node.index] = wolf_result[type][now] + weight;					
					wolf_pq.add(new Node(node.index, wolf_result[next_type][node.index], next_type));
				}
			}
		}


```

### 정리
정렬을 위해 Compare를 해줄 때, Double.Compare 하여 정렬하는 것보다 if문으로 크기를 비교하여 바로 return 해주는 것이 시간이 더 짧다
