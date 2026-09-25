import java.util.PriorityQueue;

public class outoever1 {
    static class Server{ // 왜 여기 static을 썼는지?
        long cumProcessed;
        long nextIdleTime;
    
        public Server(long cumProcessed, long nextIdleTime){
            this.cumProcessed = cumProcessed;
            this.nextIdleTime = nextIdleTime;
        }
    }

    public long solution(int[] dataSize, int[] processingTime){
        // 현재 작업 중인 서버 : nextIdleTime 오름차순 
        PriorityQueue<Server> workingServer = new PriorityQueue<>((a, b) -> Long.compare(a.nextIdleTime, b.nextIdleTime));

        PriorityQueue<Server> idleServer = new PriorityQueue<>((a,b) -> Long.compare(a.cumProcessed, b.cumProcessed));

        int N = dataSize.length;

        for(int i = 0; i < N; i++){
            long size = dataSize[i];
            long time = processingTime[i];

            // i 시점 이하로 작업이 완료된 모든 서버를 idle server로 이동시킨다
            while(!workingServer.isEmpty() && workingServer.peek().nextIdleTime <= i){
                idleServer.offer(workingServer.poll());
            }

            // 쉬는 서버가 있다면, 누적 처리량이 가장 작은 서버를 할당한다.
            if(!idleServer.isEmpty()){
                Server nextServer = idleServer.poll();
                nextServer.cumProcessed = nextServer.cumProcessed + size;
                nextServer.nextIdleTime += time;
                workingServer.offer(nextServer);
            }else{
                Server newServer = new Server(size, i+time);
                workingServer.offer(newServer);
            }

        }

        long maxProcessed = 0;

        for(Server s : workingServer){
            maxProcessed = Math.max(maxProcessed, s.cumProcessed);
        }
        for (Server s : idleServer) {
            maxProcessed = Math.max(maxProcessed, s.cumProcessed);
        }

        return maxProcessed;
    }


}
