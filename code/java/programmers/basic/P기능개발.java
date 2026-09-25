import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        // progresses는 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 배열
        // speeds는 개발 속도가 적힌 정수 배열

        // 각 배포마다 몇 개의 기능이 배포되는지 return
        // [93, 30, 55] / [1, 30, 5] => [2, 1]

        // 93 짜리는 젤 먼저 배포되어야하는데
        // 7일 뒤에 배포되는데, 뒤에거까지 같이 배포되고
        // 7일 뒤에도 아직 55는 한참 남았으니까 나중에 혼자 배포됨

        Queue<Integer> queue = new LinkedList<>();

        while(queue.peek() == 100){
            for
                queue.offer(progresses[i] + speeds[i]);
        }

        return answer;
    }
}