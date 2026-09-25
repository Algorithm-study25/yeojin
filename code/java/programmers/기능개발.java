import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            queue.offer(progresses[i]);
        }
        
        while(queue.peek() == 100){
            i = 0;
            while(1){
                queue.offer(queue.peek() + speeds[i]);
                
                i++;
            }
            
        }
        
        return answer;
    }
}