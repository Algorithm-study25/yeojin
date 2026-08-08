
import java.util.*;
class Solution{
    public int[] solution(int[] array, int[][] commands){
        
        // int[] answer = new int[array.length]; // answer를 한번만 만들고 계속 재사용하고 있음, 복사할 길이만큼만 만들어야 함, 지금은 배열의 크기만큼 만들고 있음
        
        int[] a = new int[commands.length];
        
        for(int m = 0; m < commands.length; m++){
            int i = commands[m][0]; // 2
            int j = commands[m][1]; // 5
            int k = commands[m][2]; // 3
            
            int[] answer = new int[j - i + 1];
            
            for(int n = 0; n < answer.length; n++){
                answer[n] = array[n + i - 1];
            } // 배열 복사 후
            
            Arrays.sort(answer);
            
            a[m] = answer[k - 1];
        }
        return a;
    }
}
