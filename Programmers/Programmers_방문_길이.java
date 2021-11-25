
public class Programmers_방문_길이 {
	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		System.out.println(solution(dirs));
	}
	
	static public int solution(String dirs) {
        int answer = 0;
        
        boolean[][] row = new boolean[11][11];
        boolean[][] col = new boolean[11][11];
        
        
        int[] ni = {-1,1,0,0};
        int[] nj = {0,0,-1,1};
        char[] dir = {'U','D','L','R'};
        
        
        
        int x = 5,y = 5;
        int next_x, next_y;
        
        char token;
        int dir_idx = 0;
        
        for(int i=0;i<dirs.length();i++) {
        	token = dirs.charAt(i);
        	
        	for(int d=0;d<4;d++) {
        		if(token ==dir[d]) {
        			dir_idx = d;
        		}
        	}
        	
        	next_x = x + nj[dir_idx];
        	next_y = y + ni[dir_idx];
        	
        	
        	if(next_x < 0 || next_y < 0 || next_x > 10 || next_y >10) {
        		continue;
        	}
        	
        	x = next_x;
        	y = next_y;
        	
        	if(dir_idx == 0 && !col[y][x]) {
        		col[y][x] = true;
        		answer++;
        	}else if(dir_idx ==1 && !col[y-1][x]) {
        		col[y-1][x] = true;
        		answer++;
        	}else if(dir_idx == 2 && !row[y][x]) {
        		row[y][x] = true;
        		answer++;
        	}else if(dir_idx==3 && !row[y][x-1]) {
        		row[y][x-1] = true;
        		answer++;
        	}

        	

        	
        }
        
        
        
        return answer;
    }
}
