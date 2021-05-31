import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon_16916 {
	
	static int[] makeTable(char[] p) {
        int psize = p.length;
        int[] table = new int[psize];
        int j = 0;
        for (int i = 1; i < psize; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = table[j - 1];
            }
            if (p[i] == p[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }
 
    static void kmp(char[] parent, char[] pattern) {
        int[] table = makeTable(pattern);
        int parentSize = parent.length;
        int patternSize = pattern.length;
        int j = 0;
        for (int i = 0; i < parentSize; i++) {
            while (j > 0 && parent[i] != pattern[j]) {
                j = table[j - 1];
            }
            if (parent[i] == pattern[j]) {
                if (j == patternSize - 1) {
                    cnt++;
                    j = table[j];
                    return;
                } else {
                    j++;
                }
            }
        }
    }
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		char parent[];
        char pattern[];
		
        
        String s;
        String sub_s;
       
        st = new StringTokenizer(br.readLine());
        s = st.nextToken();
        

        st = new StringTokenizer(br.readLine());
        sub_s = st.nextToken();
      
        
        parent = s.toCharArray();
        pattern = sub_s.toCharArray();
        kmp(parent,pattern);
 
        if(cnt==1) System.out.println(1);
        else System.out.println(0);
        
        
	}
}
