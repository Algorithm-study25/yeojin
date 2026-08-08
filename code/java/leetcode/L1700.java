import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < sandwiches.length; i++){
            q.offer(sandwiches[i]); // 샌드위치 i개를 큐에 넣고
        }

        for(int i = 0; i < students.length; i++){
            
            q2.offer(students[i]);
            if(q.peek().equals(students[i])){
                q.poll();
                q2.poll();
            }else{
                q2.poll();
                q2.offer(students[i]);
            }
        }
        

        return q2.size();
    }
}