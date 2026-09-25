import java.util.Queue;
import java.util.LinkedList;
class RecentCounter {

    Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {
        // RecentCounter 객체를 생성하는 함수
        // 해당 클래스는 최근 3000밀리초 동안 발생한 요청의 개수를 세는 역할을 함
        // 처음에는 최근 요청이 0개
        
        
    }
    
    public int ping(int t) {
        // 시간 t에 새로운 요청이 들어온다
        // 현재 시점 t를 기준으로 최근 3000밀리초 동안 발생한 요청의 개수를 return
        // 즉, 다음 범위에 포함되는 요청을 모두 센다.
        // [t - 3000, t]
        // ping이 호출될때마다 t는 이전 호출보다 항상 크다
        q.offer(t);

        while(q.peek() < t - 3000){
            q.poll();
        }

        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */