import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < sandwiches.length; i++){
            q.offer(sandwiches[i]); // [1 1 0 0]
        }

        for(int i = 0; i < students.length; i++){
            q2.offer(students[i]); // [0 1 0 1]
        }

        while(q2.contains(q.peek())){
            if(q.peek().equals(q2.peek())){ // 1 == 1
                q.poll(); // 1을 뺴고 -> [1 0 0] -> [1 0 0] 
                q2.poll(); // 1으 ㄹ뺴고 -> [0 1 0] -> [1 0 0] 
            }else{
                q2.offer(q2.poll()); // 1 0 1 0 (i = 0) 
            }
        }
            


        return q2.size();
    }
}